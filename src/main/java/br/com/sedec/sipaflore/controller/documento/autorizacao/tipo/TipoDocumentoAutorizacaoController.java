package br.com.sedec.sipaflore.controller.documento.autorizacao.tipo;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.entity.TipoDocumentoAutorizacao;
import br.com.sedec.sipaflore.model.documento.autorizacao.tipo.TipoDocumentoAutorizacaoInDTO;
import br.com.sedec.sipaflore.model.documento.autorizacao.tipo.TipoDocumentoAutorizacaoMapper;
import br.com.sedec.sipaflore.model.documento.autorizacao.tipo.TipoDocumentoAutorizacaoOutDTO;
import br.com.sedec.sipaflore.service.documento.autorizacao.tipo.ITipoDocumentoAutorizacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documentos/autorizacoes/tipos")
@Tag(name = "Tipos de documento de autorização")
public class TipoDocumentoAutorizacaoController extends BaseSearchController<TipoDocumentoAutorizacaoInDTO, TipoDocumentoAutorizacao, TipoDocumentoAutorizacaoOutDTO> {

    public TipoDocumentoAutorizacaoController(final ITipoDocumentoAutorizacaoService service,
                                              final TipoDocumentoAutorizacaoMapper mapper) {
        super(service, mapper);
    }

}
