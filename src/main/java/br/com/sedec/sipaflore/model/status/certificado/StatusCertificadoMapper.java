package br.com.sedec.sipaflore.model.status.certificado;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.StatusCertificado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusCertificadoMapper extends BaseMapper<StatusCertificadoInDTO, StatusCertificado, StatusCertificadoOutDTO> {
}
