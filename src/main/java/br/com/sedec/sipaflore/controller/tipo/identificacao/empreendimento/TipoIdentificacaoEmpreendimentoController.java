package br.com.sedec.sipaflore.controller.tipo.identificacao.empreendimento;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.entity.TipoIdentificacaoEmpreendimento;
import br.com.sedec.sipaflore.model.tipo.identificacao.empreendimento.TipoIdentificacaoEmpreendimentoInDTO;
import br.com.sedec.sipaflore.model.tipo.identificacao.empreendimento.TipoIdentificacaoEmpreendimentoMapper;
import br.com.sedec.sipaflore.model.tipo.identificacao.empreendimento.TipoIdentificacaoEmpreendimentoOutDTO;
import br.com.sedec.sipaflore.service.tipo.identificacao.empreendimento.ITipoIdentificacaoEmpreendimentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipos/identificacoes/empreendimentos")
@Tag(name = "Tipos de identificação do empreendimento")
public class TipoIdentificacaoEmpreendimentoController extends BaseSearchController<TipoIdentificacaoEmpreendimentoInDTO, TipoIdentificacaoEmpreendimento, TipoIdentificacaoEmpreendimentoOutDTO> {

    public TipoIdentificacaoEmpreendimentoController(final ITipoIdentificacaoEmpreendimentoService service,
                                                     final TipoIdentificacaoEmpreendimentoMapper mapper) {
        super(service, mapper);
    }

}
