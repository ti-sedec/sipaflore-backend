package br.com.sedec.sipaflore.config.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "email")
public class EmailProperties {

    private String host;
    private Integer port;
    private String username;
    private String password;
    private String protocol;
    private Boolean debug;

}
