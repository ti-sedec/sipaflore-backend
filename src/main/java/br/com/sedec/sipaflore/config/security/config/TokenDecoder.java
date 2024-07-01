package br.com.sedec.sipaflore.config.security.config;

import br.com.sedec.sipaflore.config.exception.UnauthorizedException;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.JWTParser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static java.time.LocalDateTime.ofInstant;
import static java.time.ZoneId.systemDefault;
import static java.util.Collections.emptyMap;
import static java.util.Objects.requireNonNull;
import static org.springframework.security.oauth2.jwt.Jwt.withTokenValue;
import static org.springframework.security.oauth2.jwt.MappedJwtClaimSetConverter.withDefaults;

@Component
@RequiredArgsConstructor
public class TokenDecoder implements JwtDecoder {

    private static final String ERROR_EXPIRED_TOKEN = "error.expired-token";
    private final Converter<Map<String, Object>, Map<String, Object>> claimSetConverter = withDefaults(emptyMap());

    @Override
    public Jwt decode(final String token) {
        try {
            final JWT parsedJwt = JWTParser.parse(token);

            final JWTClaimsSet jwtClaimsSet = parsedJwt.getJWTClaimsSet();
            final Map<String, Object> headers = new LinkedHashMap<>(parsedJwt.getHeader().toJSONObject());
            final Map<String, Object> claims = this.claimSetConverter.convert(jwtClaimsSet.getClaims());

            final Jwt jwt = withTokenValue(token)
                .headers(h -> h.putAll(headers))
                .claims(c -> c.putAll(requireNonNull(claims)))
                .build();

            validateToken(jwt);
            return jwt;

        } catch (final Exception e) {
            throw new UnauthorizedException(e.getMessage());
        }
    }

    private void validateToken(final Jwt source) throws UnauthorizedException {
        final LocalDateTime expiration = ofInstant(requireNonNull(source.getExpiresAt()), systemDefault());

        if (expiration.isBefore(now())) {
            throw new UnauthorizedException(ERROR_EXPIRED_TOKEN);
        }
    }

}
