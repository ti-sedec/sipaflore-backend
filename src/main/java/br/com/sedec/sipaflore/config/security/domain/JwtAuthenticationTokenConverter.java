package br.com.sedec.sipaflore.config.security.domain;

import br.com.sedec.sipaflore.config.common.AuthProperties;
import br.com.sedec.sipaflore.config.exception.UnauthorizedException;
import br.com.sedec.sipaflore.config.security.config.AuthenticationToken;
import br.com.sedec.sipaflore.config.security.model.MtLoginUserDTO;
import br.com.sedec.sipaflore.entity.PerfilUsuario;
import br.com.sedec.sipaflore.entity.Usuario;
import br.com.sedec.sipaflore.service.perfil.usuario.IPerfilUsuarioService;
import br.com.sedec.sipaflore.service.usuario.IUsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.format.DateTimeFormatter;
import java.util.List;

import static br.com.sedec.sipaflore.enums.EnumPerfil.USUARIO_PADRAO;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Collections.singletonList;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.BooleanUtils.isFalse;

@Slf4j
@Service
@RequiredArgsConstructor
public class JwtAuthenticationTokenConverter implements Converter<Jwt, AuthenticationToken> {

    public static final String ERROR_INVALID_TOKEN = "error.invalid-token";
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();
    private static final DateTimeFormatter FORMAT_DATE = ofPattern("dd/MM/yyyy");
    private static final String EMAIL_CLAIM = "email";
    private static final String JTI_CLAIM = "jti";
    private final AuthProperties authProperties;
    private final IUsuarioService usuarioService;
    private final IPerfilUsuarioService perfilService;

    @Override
    public AuthenticationToken convert(@NotNull final Jwt source) {
        final String email = getValueFromClaim(source, EMAIL_CLAIM);
        final Usuario usuario = usuarioService.findByEmail(email);

        if (nonNull(usuario)) {
            if (isFalse(usuario.getJtiToken().equals(getValueFromClaim(source, JTI_CLAIM)))) {
                return createUpdateUsuario(source, usuario);
            }

            return new AuthenticationToken(usuario.getAuthorities(), source, usuario);
        }

        return createUpdateUsuario(source, null);
    }

    private AuthenticationToken createUpdateUsuario(final Jwt source, final Usuario usuarioBase) {
        try {
            final HttpEntity<String> httpEntity = new HttpEntity<>(getHeaders(source));

            final MtLoginUserDTO mtLoginUserDTO =
                REST_TEMPLATE.postForObject(authProperties.getIntrospectUri(), httpEntity, MtLoginUserDTO.class);

            if (isNull(mtLoginUserDTO)) {
                throw new UnauthorizedException(ERROR_INVALID_TOKEN);
            }

            final Usuario usuario = Usuario.builder()
                .username(mtLoginUserDTO.preferred_username())
                .email(mtLoginUserDTO.email())
                .jtiToken(getValueFromClaim(source, JTI_CLAIM))
                .uuid(mtLoginUserDTO.sub())
                .perfis(getPerfis())
                .build();

            if (nonNull(usuarioBase)) {
                usuario.setId(usuarioBase.getId());
            }

            return new AuthenticationToken(usuario.getAuthorities(), source, usuarioService.create(usuario));
        } catch (final Exception e) {
            throw new UnauthorizedException(ERROR_INVALID_TOKEN);
        }
    }

    private HttpHeaders getHeaders(final Jwt source) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(source.getTokenValue());
        return httpHeaders;
    }

    private List<PerfilUsuario> getPerfis() {
        return perfilService.findByCodigos(singletonList(USUARIO_PADRAO.getCodigo()));
    }

    private String getValueFromClaim(final Jwt source, final String claim) {
        return ofNullable(source.getClaims())
            .map(claims -> claims.get(claim))
            .map(Object::toString)
            .orElseThrow(() -> new UnauthorizedException(ERROR_INVALID_TOKEN));
    }

}
