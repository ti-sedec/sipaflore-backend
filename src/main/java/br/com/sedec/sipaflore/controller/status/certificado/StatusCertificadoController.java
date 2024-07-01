package br.com.sedec.sipaflore.controller.status.certificado;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.entity.StatusCertificado;
import br.com.sedec.sipaflore.model.status.certificado.StatusCertificadoInDTO;
import br.com.sedec.sipaflore.model.status.certificado.StatusCertificadoMapper;
import br.com.sedec.sipaflore.model.status.certificado.StatusCertificadoOutDTO;
import br.com.sedec.sipaflore.service.status.certificado.IStatusCertificadoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status/certificados")
@Tag(name = "Status dos certificados")
public class StatusCertificadoController extends BaseSearchController<StatusCertificadoInDTO, StatusCertificado, StatusCertificadoOutDTO> {

    public StatusCertificadoController(final IStatusCertificadoService service,
                                       final StatusCertificadoMapper mapper) {
        super(service, mapper);
    }

}
