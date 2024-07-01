package br.com.sedec.sipaflore.config.security.domain;

import br.com.sedec.sipaflore.config.exception.UnauthorizedException;
import br.com.sedec.sipaflore.model.usuario.UsuarioMapper;
import br.com.sedec.sipaflore.model.usuario.UsuarioOutDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UsuarioMapper usuarioMapper;

    public AuthenticationController(final AuthenticationService authenticationService,
                                    final UsuarioMapper usuarioMapper) {
        this.authenticationService = authenticationService;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping("/instrospect")
    @Operation(description = "Instrospect returning the user infos")
    public UsuarioOutDTO instrospect() throws UnauthorizedException {
        return usuarioMapper.toOutDto(authenticationService.instrospect());
    }

}
