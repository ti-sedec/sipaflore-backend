package br.com.sedec.sipaflore.controller.perfil.usuario;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.entity.PerfilUsuario;
import br.com.sedec.sipaflore.model.perfil.usuario.PerfilUsuarioInDTO;
import br.com.sedec.sipaflore.model.perfil.usuario.PerfilUsuarioMapper;
import br.com.sedec.sipaflore.model.perfil.usuario.PerfilUsuarioOutDTO;
import br.com.sedec.sipaflore.service.perfil.usuario.IPerfilUsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfis/usuarios")
@Tag(name = "Perfis dos usuários")
public class PerfilUsuarioController extends BaseSearchController<PerfilUsuarioInDTO, PerfilUsuario, PerfilUsuarioOutDTO> {

    public PerfilUsuarioController(final IPerfilUsuarioService service,
                                   final PerfilUsuarioMapper mapper) {
        super(service, mapper);
    }

}
