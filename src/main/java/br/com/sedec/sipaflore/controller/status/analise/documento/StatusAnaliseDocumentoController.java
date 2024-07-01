package br.com.sedec.sipaflore.controller.status.analise.documento;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.entity.StatusAnaliseDocumento;
import br.com.sedec.sipaflore.model.status.analise.documento.StatusAnaliseDocumentoInDTO;
import br.com.sedec.sipaflore.model.status.analise.documento.StatusAnaliseDocumentoMapper;
import br.com.sedec.sipaflore.model.status.analise.documento.StatusAnaliseDocumentoOutDTO;
import br.com.sedec.sipaflore.service.status.analise.documento.IStatusAnaliseDocumentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status/analises/documentos")
@Tag(name = "Status da análise do documento")
public class StatusAnaliseDocumentoController extends BaseSearchController<StatusAnaliseDocumentoInDTO, StatusAnaliseDocumento, StatusAnaliseDocumentoOutDTO> {

    public StatusAnaliseDocumentoController(final IStatusAnaliseDocumentoService service,
                                            final StatusAnaliseDocumentoMapper mapper) {
        super(service, mapper);
    }

}
