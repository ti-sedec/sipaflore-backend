package br.com.sedec.sipaflore.model.documento.autorizacao;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.DocumentoAutorizacao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DocumentoAutorizacaoMapper extends BaseMapper<DocumentoAutorizacaoInDTO, DocumentoAutorizacao, DocumentoAutorizacaoOutDTO> {
}
