package br.com.sedec.sipaflore.controller.documento.autorizacao.papel.usuario;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.entity.PapelUsuarioDocumentoAutorizacao;
import br.com.sedec.sipaflore.model.documento.autorizacao.papel.usuario.PapelUsuarioDocumentoAutorizacaoInDTO;
import br.com.sedec.sipaflore.model.documento.autorizacao.papel.usuario.PapelUsuarioDocumentoAutorizacaoMapper;
import br.com.sedec.sipaflore.model.documento.autorizacao.papel.usuario.PapelUsuarioDocumentoAutorizacaoOutDTO;
import br.com.sedec.sipaflore.service.documento.autorizacao.papel.usuario.IPapelUsuarioDocumentoAutorizacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documentos/autorizacoes/papeis/usuarios")
@Tag(name = "Papeis do usuário no documento de autorização")
public class PapelUsuarioDocumentoAutorizacaoController extends BaseSearchController<PapelUsuarioDocumentoAutorizacaoInDTO, PapelUsuarioDocumentoAutorizacao, PapelUsuarioDocumentoAutorizacaoOutDTO> {

    public PapelUsuarioDocumentoAutorizacaoController(final IPapelUsuarioDocumentoAutorizacaoService service,
                                                      final PapelUsuarioDocumentoAutorizacaoMapper mapper) {
        super(service, mapper);
    }

}
