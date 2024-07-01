package br.com.sedec.sipaflore.model.certificado.recolhimento;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.CertificadoRecolhimento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CertificadoRecolhimentoMapper extends BaseMapper<CertificadoRecolhimentoInDTO, CertificadoRecolhimento, CertificadoRecolhimentoOutDTO> {
}
