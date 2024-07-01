package br.com.sedec.sipaflore.config.security.domain;

import br.com.sedec.sipaflore.config.exception.UnauthorizedException;
import br.com.sedec.sipaflore.config.security.config.AuthenticationToken;
import br.com.sedec.sipaflore.entity.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
public class AuthenticationService {

    public Usuario instrospect() throws UnauthorizedException {
        return ofNullable(SecurityContextHolder.getContext())
            .map(security -> (AuthenticationToken) security.getAuthentication())
            .map(AuthenticationToken::getUser)
            .orElse(null);
    }

}
