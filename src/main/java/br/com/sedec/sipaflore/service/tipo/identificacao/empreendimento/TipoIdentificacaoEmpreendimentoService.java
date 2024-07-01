package br.com.sedec.sipaflore.service.tipo.identificacao.empreendimento;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.TipoIdentificacaoEmpreendimento;
import br.com.sedec.sipaflore.repository.tipo.identificacao.empreendimento.TipoIdentificacaoEmpreendimentoRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoIdentificacaoEmpreendimentoService extends BaseService<TipoIdentificacaoEmpreendimento> implements ITipoIdentificacaoEmpreendimentoService {

    protected TipoIdentificacaoEmpreendimentoService(final BaseRepository<TipoIdentificacaoEmpreendimento> repository) {
        super(repository);
    }

    @Override
    public TipoIdentificacaoEmpreendimentoRepository getRepository() {
        return (TipoIdentificacaoEmpreendimentoRepository) super.getRepository();
    }

}
