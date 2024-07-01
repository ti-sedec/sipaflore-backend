package br.com.sedec.sipaflore.service.notificacao;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.Notificacao;
import br.com.sedec.sipaflore.repository.notificacao.NotificacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoService extends BaseService<Notificacao> implements INotificacaoService {

    protected NotificacaoService(final BaseRepository<Notificacao> repository) {
        super(repository);
    }

    @Override
    public NotificacaoRepository getRepository() {
        return (NotificacaoRepository) super.getRepository();
    }

}
