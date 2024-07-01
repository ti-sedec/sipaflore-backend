package br.com.sedec.sipaflore.model.documento.autorizacao.tipo;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.TipoDocumentoAutorizacao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoDocumentoAutorizacaoMapper extends BaseMapper<TipoDocumentoAutorizacaoInDTO, TipoDocumentoAutorizacao, TipoDocumentoAutorizacaoOutDTO> {
}
