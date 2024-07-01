package br.com.sedec.sipaflore.model.status.analise.documento;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.StatusAnaliseDocumento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusAnaliseDocumentoMapper extends BaseMapper<StatusAnaliseDocumentoInDTO, StatusAnaliseDocumento, StatusAnaliseDocumentoOutDTO> {
}
