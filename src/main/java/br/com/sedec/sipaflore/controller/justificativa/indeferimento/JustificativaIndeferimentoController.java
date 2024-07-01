package br.com.sedec.sipaflore.controller.justificativa.indeferimento;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.entity.JustificativaIndeferimento;
import br.com.sedec.sipaflore.model.justificativa.indeferimento.JustificativaIndeferimentoInDTO;
import br.com.sedec.sipaflore.model.justificativa.indeferimento.JustificativaIndeferimentoMapper;
import br.com.sedec.sipaflore.model.justificativa.indeferimento.JustificativaIndeferimentoOutDTO;
import br.com.sedec.sipaflore.service.justificativa.indeferimento.IJustificativaIndeferimentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/justificativas/indeferimentos")
@Tag(name = "Justificativas do indeferimento de análise de documento")
public class JustificativaIndeferimentoController extends BaseSearchController<JustificativaIndeferimentoInDTO, JustificativaIndeferimento, JustificativaIndeferimentoOutDTO> {

    public JustificativaIndeferimentoController(final IJustificativaIndeferimentoService service,
                                                final JustificativaIndeferimentoMapper mapper) {
        super(service, mapper);
    }

}
