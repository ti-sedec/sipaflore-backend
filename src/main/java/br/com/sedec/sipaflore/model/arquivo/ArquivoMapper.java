package br.com.sedec.sipaflore.model.arquivo;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.Arquivo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArquivoMapper extends BaseMapper<ArquivoInDTO, Arquivo, ArquivoOutDTO> {
}
