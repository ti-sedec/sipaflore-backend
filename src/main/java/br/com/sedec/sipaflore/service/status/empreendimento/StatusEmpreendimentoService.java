package br.com.sedec.sipaflore.service.status.empreendimento;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.StatusEmpreendimento;
import br.com.sedec.sipaflore.repository.status.empreendimento.StatusEmpreendimentoRepository;
import org.springframework.stereotype.Service;

@Service
public class StatusEmpreendimentoService extends BaseService<StatusEmpreendimento> implements IStatusEmpreendimentoService {

    protected StatusEmpreendimentoService(final BaseRepository<StatusEmpreendimento> repository) {
        super(repository);
    }

    @Override
    public StatusEmpreendimentoRepository getRepository() {
        return (StatusEmpreendimentoRepository) super.getRepository();
    }

}
