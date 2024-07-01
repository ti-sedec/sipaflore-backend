package br.com.sedec.sipaflore.config.security.config;

import br.com.sedec.sipaflore.entity.Usuario;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;
import java.util.Objects;

@Getter
public class AuthenticationToken extends JwtAuthenticationToken {

    private final transient Usuario user;

    public AuthenticationToken(final Collection<? extends GrantedAuthority> authorities,
                               final Jwt jwt, final Usuario user) {
        super(jwt, authorities);
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthenticationToken that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user);
    }

}
