package br.com.sedec.sipaflore.config.common;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static io.swagger.v3.oas.models.security.SecurityScheme.Type.HTTP;

@Configuration
@RequiredArgsConstructor
public class SwaggerConfig {

    private static final String SCHEME_NAME = "bearerAuth";
    private static final String SCHEME = "bearer";
    private final ApplicationProperties properties;

    @Bean
    public OpenAPI customOpenAPI() {
        final String name = "API " + properties.getAppname();
        return new OpenAPI()
            .components(new Components()
                .addSecuritySchemes(SCHEME_NAME, createSecurityScheme()))
            .info(new Info()
                .title(name)
                .version(properties.getVersion())
                .summary(name))
            .addSecurityItem(new SecurityRequirement().addList(SCHEME_NAME));
    }

    @Bean
    public SecurityScheme createSecurityScheme() {
        return new SecurityScheme()
            .name(SCHEME_NAME)
            .type(HTTP)
            .scheme(SCHEME);
    }

}
