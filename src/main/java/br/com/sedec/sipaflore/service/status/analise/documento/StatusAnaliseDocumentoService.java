package br.com.sedec.sipaflore.service.status.analise.documento;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.StatusAnaliseDocumento;
import br.com.sedec.sipaflore.repository.status.analise.documento.StatusAnaliseDocumentoRepository;
import org.springframework.stereotype.Service;

@Service
public class StatusAnaliseDocumentoService extends BaseService<StatusAnaliseDocumento> implements IStatusAnaliseDocumentoService {

    protected StatusAnaliseDocumentoService(final BaseRepository<StatusAnaliseDocumento> repository) {
        super(repository);
    }

    @Override
    public StatusAnaliseDocumentoRepository getRepository() {
        return (StatusAnaliseDocumentoRepository) super.getRepository();
    }

}
