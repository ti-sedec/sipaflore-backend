package br.com.sedec.sipaflore.controller.empreendimento;

import br.com.sedec.sipaflore.base.BaseController;
import br.com.sedec.sipaflore.entity.Empreendimento;
import br.com.sedec.sipaflore.model.empreendimento.EmpreendimentoInDTO;
import br.com.sedec.sipaflore.model.empreendimento.EmpreendimentoMapper;
import br.com.sedec.sipaflore.model.empreendimento.EmpreendimentoOutDTO;
import br.com.sedec.sipaflore.service.empreendimento.IEmpreendimentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empreendimentos")
@Tag(name = "Empreendimentos")
public class EmpreendimentoController extends BaseController<EmpreendimentoInDTO, Empreendimento, EmpreendimentoOutDTO> {

    public EmpreendimentoController(final IEmpreendimentoService service,
                                    final EmpreendimentoMapper mapper) {
        super(service, mapper);
    }

}
