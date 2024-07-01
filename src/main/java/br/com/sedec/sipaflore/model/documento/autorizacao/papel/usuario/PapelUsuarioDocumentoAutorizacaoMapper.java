package br.com.sedec.sipaflore.model.documento.autorizacao.papel.usuario;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.PapelUsuarioDocumentoAutorizacao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PapelUsuarioDocumentoAutorizacaoMapper extends BaseMapper<PapelUsuarioDocumentoAutorizacaoInDTO, PapelUsuarioDocumentoAutorizacao, PapelUsuarioDocumentoAutorizacaoOutDTO> {
}
