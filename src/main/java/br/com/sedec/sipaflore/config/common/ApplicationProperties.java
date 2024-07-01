package br.com.sedec.sipaflore.config.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "application")
public class ApplicationProperties {

    private String secretKey;
    private String appname;
    private String env;
    private String version;
    private String pathEmailTemplate;
    private String clientEmail;
    private List<String> allowedOrigins;
    private Boolean stacktraceEnabled;
    private String apiSubModulos;

}
