package br.com.sedec.sipaflore.service.analise.documento;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.AnaliseDocumento;
import br.com.sedec.sipaflore.repository.analise.documento.AnaliseDocumentoRepository;
import org.springframework.stereotype.Service;

@Service
public class AnaliseDocumentoService extends BaseService<AnaliseDocumento> implements IAnaliseDocumentoService {

    protected AnaliseDocumentoService(final BaseRepository<AnaliseDocumento> repository) {
        super(repository);
    }

    @Override
    public AnaliseDocumentoRepository getRepository() {
        return (AnaliseDocumentoRepository) super.getRepository();
    }

}
