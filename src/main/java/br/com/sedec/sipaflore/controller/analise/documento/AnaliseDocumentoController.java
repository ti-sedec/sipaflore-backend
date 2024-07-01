package br.com.sedec.sipaflore.controller.analise.documento;

import br.com.sedec.sipaflore.base.BaseController;
import br.com.sedec.sipaflore.entity.AnaliseDocumento;
import br.com.sedec.sipaflore.model.analise.documento.AnaliseDocumentoInDTO;
import br.com.sedec.sipaflore.model.analise.documento.AnaliseDocumentoMapper;
import br.com.sedec.sipaflore.model.analise.documento.AnaliseDocumentoOutDTO;
import br.com.sedec.sipaflore.service.analise.documento.IAnaliseDocumentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analises/documentos")
@Tag(name = "Análises de documentos")
public class AnaliseDocumentoController extends BaseController<AnaliseDocumentoInDTO, AnaliseDocumento, AnaliseDocumentoOutDTO> {

    public AnaliseDocumentoController(final IAnaliseDocumentoService service,
                                      final AnaliseDocumentoMapper mapper) {
        super(service, mapper);
    }

}
