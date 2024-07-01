package br.com.sedec.sipaflore.service.certificado.recolhimento;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.CertificadoRecolhimento;
import br.com.sedec.sipaflore.repository.certificado.recolhimento.CertificadoRecolhimentoRepository;
import org.springframework.stereotype.Service;

@Service
public class CertificadoRecolhimentoService extends BaseService<CertificadoRecolhimento> implements ICertificadoRecolhimentoService {

    protected CertificadoRecolhimentoService(final BaseRepository<CertificadoRecolhimento> repository) {
        super(repository);
    }

    @Override
    public CertificadoRecolhimentoRepository getRepository() {
        return (CertificadoRecolhimentoRepository) super.getRepository();
    }

}
