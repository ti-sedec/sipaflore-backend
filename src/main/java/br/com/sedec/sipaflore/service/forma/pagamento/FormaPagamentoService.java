package br.com.sedec.sipaflore.service.forma.pagamento;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.FormaPagamento;
import br.com.sedec.sipaflore.repository.forma.pagamento.FormaPagamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class FormaPagamentoService extends BaseService<FormaPagamento> implements IFormaPagamentoService {

    protected FormaPagamentoService(final BaseRepository<FormaPagamento> repository) {
        super(repository);
    }

    @Override
    public FormaPagamentoRepository getRepository() {
        return (FormaPagamentoRepository) super.getRepository();
    }

}
