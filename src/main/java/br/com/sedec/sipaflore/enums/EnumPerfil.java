package br.com.sedec.sipaflore.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static br.com.sedec.sipaflore.enums.EnumPermissao.ADMIN_CREATE;
import static br.com.sedec.sipaflore.enums.EnumPermissao.ADMIN_DELETE;
import static br.com.sedec.sipaflore.enums.EnumPermissao.ADMIN_READ;
import static br.com.sedec.sipaflore.enums.EnumPermissao.ADMIN_UPDATE;
import static br.com.sedec.sipaflore.enums.EnumPermissao.MANAGER_CREATE;
import static br.com.sedec.sipaflore.enums.EnumPermissao.MANAGER_DELETE;
import static br.com.sedec.sipaflore.enums.EnumPermissao.MANAGER_READ;
import static br.com.sedec.sipaflore.enums.EnumPermissao.MANAGER_UPDATE;
import static java.util.Collections.emptySet;

@Getter
@RequiredArgsConstructor
public enum EnumPerfil {

    USUARIO_PADRAO("USER", emptySet()),
    ADMINISTRADOR("ADMIN",
        Set.of(
            ADMIN_READ,
            ADMIN_UPDATE,
            ADMIN_DELETE,
            ADMIN_CREATE,
            MANAGER_READ,
            MANAGER_UPDATE,
            MANAGER_DELETE,
            MANAGER_CREATE
        )
    ),
    ANALISTA_SEDEC("MANAGER",
        Set.of(
            MANAGER_READ,
            MANAGER_UPDATE,
            MANAGER_DELETE,
            MANAGER_CREATE
        )
    );

    private final String codigo;
    private final Set<EnumPermissao> permissoes;

    public List<SimpleGrantedAuthority> getAuthorities() {
        final var authorities = getPermissoes()
            .stream()
            .map(enumPermissao -> new SimpleGrantedAuthority(enumPermissao.getPermission()))
            .collect(Collectors.toList());

        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

}
