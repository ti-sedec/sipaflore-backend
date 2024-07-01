package br.com.sedec.sipaflore.controller.status.empreendimento;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.entity.StatusEmpreendimento;
import br.com.sedec.sipaflore.model.status.empreendimento.StatusEmpreendimentoInDTO;
import br.com.sedec.sipaflore.model.status.empreendimento.StatusEmpreendimentoMapper;
import br.com.sedec.sipaflore.model.status.empreendimento.StatusEmpreendimentoOutDTO;
import br.com.sedec.sipaflore.service.status.empreendimento.IStatusEmpreendimentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status/empreendimentos")
@Tag(name = "Status dos empreendimentos")
public class StatusEmpreendimentoController extends BaseSearchController<StatusEmpreendimentoInDTO, StatusEmpreendimento, StatusEmpreendimentoOutDTO> {

    public StatusEmpreendimentoController(final IStatusEmpreendimentoService service,
                                          final StatusEmpreendimentoMapper mapper) {
        super(service, mapper);
    }

}
