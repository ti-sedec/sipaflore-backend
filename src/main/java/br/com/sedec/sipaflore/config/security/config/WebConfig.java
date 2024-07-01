package br.com.sedec.sipaflore.config.security.config;

import br.com.sedec.sipaflore.config.common.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.PATCH;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;

@Configuration
@RequiredArgsConstructor
public class WebConfig {

    private static final Long MAX_AGE = 3600L;
    private static final List<String> ALLOWED_METHODS = asList(GET.name(), POST.name(), PUT.name(), DELETE.name(), PATCH.name());
    private static final List<String> ALLOWED_HEADERS = asList(AUTHORIZATION, CONTENT_TYPE, ACCEPT);
    private final ApplicationProperties properties;

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterRegistration() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(properties.getAllowedOrigins());
        config.setAllowedHeaders(ALLOWED_HEADERS);
        config.setAllowedMethods(ALLOWED_METHODS);
        config.setMaxAge(MAX_AGE);
        source.registerCorsConfiguration("/**", config);

        final FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(HIGHEST_PRECEDENCE);
        return bean;
    }

}
