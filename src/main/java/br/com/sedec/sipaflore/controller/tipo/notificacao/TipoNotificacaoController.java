package br.com.sedec.sipaflore.controller.tipo.notificacao;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.entity.TipoNotificacao;
import br.com.sedec.sipaflore.model.tipo.notificacao.TipoNotificacaoInDTO;
import br.com.sedec.sipaflore.model.tipo.notificacao.TipoNotificacaoMapper;
import br.com.sedec.sipaflore.model.tipo.notificacao.TipoNotificacaoOutDTO;
import br.com.sedec.sipaflore.service.tipo.notificacao.ITipoNotificacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipos/notificacoes")
@Tag(name = "Tipos de notificação do usuário")
public class TipoNotificacaoController extends BaseSearchController<TipoNotificacaoInDTO, TipoNotificacao, TipoNotificacaoOutDTO> {

    public TipoNotificacaoController(final ITipoNotificacaoService service,
                                     final TipoNotificacaoMapper mapper) {
        super(service, mapper);
    }

}
