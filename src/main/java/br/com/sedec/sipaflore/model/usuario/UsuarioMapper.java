package br.com.sedec.sipaflore.model.usuario;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends BaseMapper<UsuarioInDTO, Usuario, UsuarioOutDTO> {
}
