package br.com.sedec.sipaflore.service.usuario;

import br.com.sedec.sipaflore.base.IBaseService;
import br.com.sedec.sipaflore.config.exception.BadRequestException;
import br.com.sedec.sipaflore.entity.Usuario;
import br.com.sedec.sipaflore.enums.EnumPerfil;

public interface IUsuarioService extends IBaseService<Usuario> {

    Usuario findByEmail(final String email);

    Usuario getUsuarioLogado() throws BadRequestException;

    Boolean usuarioLogadoHasPerfil(final EnumPerfil perfil) throws BadRequestException;

}
