package br.com.sedec.sipaflore.controller.notificacao;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.entity.Notificacao;
import br.com.sedec.sipaflore.model.notificacao.NotificacaoInDTO;
import br.com.sedec.sipaflore.model.notificacao.NotificacaoMapper;
import br.com.sedec.sipaflore.model.notificacao.NotificacaoOutDTO;
import br.com.sedec.sipaflore.service.notificacao.INotificacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notificacoes")
@Tag(name = "Notificações dos usuários")
public class NotificacaoController extends BaseSearchController<NotificacaoInDTO, Notificacao, NotificacaoOutDTO> {

    public NotificacaoController(final INotificacaoService service,
                                 final NotificacaoMapper mapper) {
        super(service, mapper);
    }

}
