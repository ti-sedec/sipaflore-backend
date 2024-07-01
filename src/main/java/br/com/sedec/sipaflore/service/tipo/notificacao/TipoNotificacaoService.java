package br.com.sedec.sipaflore.service.tipo.notificacao;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.TipoNotificacao;
import br.com.sedec.sipaflore.repository.tipo.notificacao.TipoNotificacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoNotificacaoService extends BaseService<TipoNotificacao> implements ITipoNotificacaoService {

    protected TipoNotificacaoService(final BaseRepository<TipoNotificacao> repository) {
        super(repository);
    }

    @Override
    public TipoNotificacaoRepository getRepository() {
        return (TipoNotificacaoRepository) super.getRepository();
    }

}
