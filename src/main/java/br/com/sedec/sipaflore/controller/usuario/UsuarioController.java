package br.com.sedec.sipaflore.controller.usuario;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.entity.Usuario;
import br.com.sedec.sipaflore.model.usuario.UsuarioInDTO;
import br.com.sedec.sipaflore.model.usuario.UsuarioMapper;
import br.com.sedec.sipaflore.model.usuario.UsuarioOutDTO;
import br.com.sedec.sipaflore.service.usuario.IUsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuários")
public class UsuarioController extends BaseSearchController<UsuarioInDTO, Usuario, UsuarioOutDTO> {

    public UsuarioController(final IUsuarioService service,
                             final UsuarioMapper mapper) {
        super(service, mapper);
    }

}
