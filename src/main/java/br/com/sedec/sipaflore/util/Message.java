package br.com.sedec.sipaflore.util;

import java.util.Locale;

public class Message {

    private static MessageService messageService;

    public Message() {
        // Empty constructor.
    }

    public static void setMessageService(MessageService messageService) {
        Message.messageService = messageService;
    }

    public static String getMessage(final String message) {
        return messageService.getMessage(message);
    }

    public static String getMessage(final String message, final Object... args) {
        return messageService.getMessage(message, args);
    }

    public static String getMessage(final String message, final Locale locale, final Object... args) {
        return messageService.getMessage(message, locale, args);
    }

}
