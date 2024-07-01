package br.com.sedec.sipaflore.service.status.certificado;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.StatusCertificado;
import br.com.sedec.sipaflore.repository.status.certificado.StatusCertificadoRepository;
import org.springframework.stereotype.Service;

@Service
public class StatusCertificadoService extends BaseService<StatusCertificado> implements IStatusCertificadoService {

    protected StatusCertificadoService(final BaseRepository<StatusCertificado> repository) {
        super(repository);
    }

    @Override
    public StatusCertificadoRepository getRepository() {
        return (StatusCertificadoRepository) super.getRepository();
    }

}
