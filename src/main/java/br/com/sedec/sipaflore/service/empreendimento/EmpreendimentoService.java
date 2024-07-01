package br.com.sedec.sipaflore.service.empreendimento;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.Empreendimento;
import br.com.sedec.sipaflore.repository.empreendimento.EmpreendimentoRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpreendimentoService extends BaseService<Empreendimento> implements IEmpreendimentoService {

    protected EmpreendimentoService(final BaseRepository<Empreendimento> repository) {
        super(repository);
    }

    @Override
    public EmpreendimentoRepository getRepository() {
        return (EmpreendimentoRepository) super.getRepository();
    }

}
