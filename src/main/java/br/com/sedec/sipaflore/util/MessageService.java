package br.com.sedec.sipaflore.util;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static br.com.sedec.sipaflore.util.Message.setMessageService;
import static org.springframework.context.i18n.LocaleContextHolder.getLocale;

@Component
public class MessageService {

    private final ResourceBundleMessageSource messageSource;

    public MessageService(final ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
        setMessageService(this);
    }

    public String getMessage(final String message) {
        try {
            return messageSource.getMessage(message, null, getLocale());
        } catch (final Exception e) {
            return message;
        }
    }

    public String getMessage(final String message, final Object... args) {
        try {
            return messageSource.getMessage(message, args, getLocale());
        } catch (final Exception e) {
            return message;
        }
    }

    public String getMessage(final String message, final Locale locale, final Object... args) {
        try {
            return messageSource.getMessage(message, args, locale);
        } catch (final Exception e) {
            return message;
        }
    }

}
