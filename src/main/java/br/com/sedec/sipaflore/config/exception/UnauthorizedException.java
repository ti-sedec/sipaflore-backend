package br.com.sedec.sipaflore.config.exception;

import br.com.sedec.sipaflore.util.Message;
import org.springframework.security.core.AuthenticationException;

public class UnauthorizedException extends AuthenticationException {

    public UnauthorizedException(final String message) {
        super(Message.getMessage(message));
    }

    public UnauthorizedException(final String message, final Object... args) {
        super(Message.getMessage(message, args));
    }

}
