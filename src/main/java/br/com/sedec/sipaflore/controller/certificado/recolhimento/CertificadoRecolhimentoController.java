package br.com.sedec.sipaflore.controller.certificado.recolhimento;

import br.com.sedec.sipaflore.base.BaseController;
import br.com.sedec.sipaflore.entity.CertificadoRecolhimento;
import br.com.sedec.sipaflore.model.certificado.recolhimento.CertificadoRecolhimentoInDTO;
import br.com.sedec.sipaflore.model.certificado.recolhimento.CertificadoRecolhimentoMapper;
import br.com.sedec.sipaflore.model.certificado.recolhimento.CertificadoRecolhimentoOutDTO;
import br.com.sedec.sipaflore.service.certificado.recolhimento.ICertificadoRecolhimentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certificados/recolhimentos")
@Tag(name = "Certificados de recolhimento de taxa de reposição florestal")
public class CertificadoRecolhimentoController extends BaseController<CertificadoRecolhimentoInDTO, CertificadoRecolhimento, CertificadoRecolhimentoOutDTO> {

    public CertificadoRecolhimentoController(final ICertificadoRecolhimentoService service,
                                             final CertificadoRecolhimentoMapper mapper) {
        super(service, mapper);
    }

}
