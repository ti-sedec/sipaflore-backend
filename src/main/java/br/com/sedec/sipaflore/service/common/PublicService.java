package br.com.sedec.sipaflore.service.common;

import br.com.sedec.sipaflore.config.common.ApplicationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublicService implements IPublicService {

    private final ApplicationProperties properties;

    public String getVersao() {
        return properties.getVersion();
    }

}
