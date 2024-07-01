package br.com.sedec.sipaflore.config.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "auth")
public class AuthProperties {

    private String jwksUri;
    private String introspectUri;

}
