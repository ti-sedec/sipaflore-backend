package br.com.sedec.sipaflore.model.estado;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.Estado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstadoMapper extends BaseMapper<EstadoInDTO, Estado, EstadoOutDTO> {
}
