package br.com.sedec.sipaflore.model.municipio;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.Municipio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MunicipioMapper extends BaseMapper<MunicipioInDTO, Municipio, MunicipioOutDTO> {
}
