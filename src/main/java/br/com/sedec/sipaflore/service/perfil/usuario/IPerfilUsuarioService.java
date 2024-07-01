package br.com.sedec.sipaflore.service.perfil.usuario;

import br.com.sedec.sipaflore.base.IBaseService;
import br.com.sedec.sipaflore.entity.PerfilUsuario;

import java.util.List;

public interface IPerfilUsuarioService extends IBaseService<PerfilUsuario> {

    List<PerfilUsuario> findByCodigos(final List<String> codigos);

}
