package br.com.sedec.sipaflore.service.justificativa.indeferimento;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.JustificativaIndeferimento;
import br.com.sedec.sipaflore.repository.justificativa.indeferimento.JustificativaIndeferimentoRepository;
import org.springframework.stereotype.Service;

@Service
public class JustificativaIndeferimentoService extends BaseService<JustificativaIndeferimento> implements IJustificativaIndeferimentoService {

    protected JustificativaIndeferimentoService(final BaseRepository<JustificativaIndeferimento> repository) {
        super(repository);
    }

    @Override
    public JustificativaIndeferimentoRepository getRepository() {
        return (JustificativaIndeferimentoRepository) super.getRepository();
    }

}
