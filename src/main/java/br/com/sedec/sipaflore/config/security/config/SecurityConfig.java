package br.com.sedec.sipaflore.config.security.config;

import br.com.sedec.sipaflore.config.common.AuthProperties;
import br.com.sedec.sipaflore.config.security.domain.JwtAuthenticationTokenConverter;
import br.com.sedec.sipaflore.service.perfil.usuario.IPerfilUsuarioService;
import br.com.sedec.sipaflore.service.usuario.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserAuthenticationEntryPoint userAuthenticationEntryPoint;
    private final AuthProperties authProperties;
    private final IUsuarioService usuarioService;
    private final IPerfilUsuarioService perfilService;
    private final TokenDecoder tokenDecoder;

    @Bean
    public SecurityFilterChain securityFilterChain(final HttpSecurity http) throws Exception {
        final JwtAuthenticationTokenConverter converter = new JwtAuthenticationTokenConverter(
            authProperties, usuarioService, perfilService);

        return http
            .exceptionHandling(ex -> ex.authenticationEntryPoint(userAuthenticationEntryPoint).accessDeniedHandler(new JwtAccessDeniedHandler()))
            .oauth2ResourceServer(
                oauth2 -> oauth2
                    .jwt(jwt -> jwt
                            .decoder(tokenDecoder)
                            .jwtAuthenticationConverter(converter)
//                                        .jwkSetUri(authProperties.getJwksUri())
                    )
                    .authenticationEntryPoint(userAuthenticationEntryPoint)
                    .accessDeniedHandler(new JwtAccessDeniedHandler())
            )
            .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
            .csrf(AbstractHttpConfigurer::disable)
            .httpBasic(withDefaults())
            .authorizeHttpRequests(request -> request
                .requestMatchers("/public/**").permitAll()
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()
                .anyRequest().authenticated())
            .build();
    }

}
