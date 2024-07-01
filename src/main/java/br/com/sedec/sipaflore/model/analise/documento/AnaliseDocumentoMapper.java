package br.com.sedec.sipaflore.model.analise.documento;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.AnaliseDocumento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnaliseDocumentoMapper extends BaseMapper<AnaliseDocumentoInDTO, AnaliseDocumento, AnaliseDocumentoOutDTO> {
}
