package br.com.sedec.sipaflore.util;

import br.com.sedec.sipaflore.config.common.ApplicationProperties;
import br.com.sedec.sipaflore.config.exception.BadRequestException;
import br.com.sedec.sipaflore.enums.EnumEmailTemplate;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class FreeMarkerUtils {

    private static final String EMAIL_EXTENSION = ".ftlh";
    private final Configuration config;
    private final ApplicationProperties properties;

    private void setDirectoryForTemplateLoading(final String path) throws IOException {
        config.setDirectoryForTemplateLoading(new DefaultResourceLoader().getResource(path).getFile());
    }

    public String getTemplate(final EnumEmailTemplate template,
                              final Map<String, Object> data) throws BadRequestException {
        try {
            setDirectoryForTemplateLoading(properties.getPathEmailTemplate());
            final String filename = template.getFilename().concat(EMAIL_EXTENSION);
            final Template temp = config.getTemplate(filename);
            final StringWriter writer = new StringWriter();
            temp.process(data, writer);
            return writer.toString();
        } catch (final IOException | TemplateException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

}
