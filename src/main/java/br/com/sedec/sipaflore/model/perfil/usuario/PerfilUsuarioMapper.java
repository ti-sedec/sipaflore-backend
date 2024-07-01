package br.com.sedec.sipaflore.model.perfil.usuario;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.PerfilUsuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PerfilUsuarioMapper extends BaseMapper<PerfilUsuarioInDTO, PerfilUsuario, PerfilUsuarioOutDTO> {
}
