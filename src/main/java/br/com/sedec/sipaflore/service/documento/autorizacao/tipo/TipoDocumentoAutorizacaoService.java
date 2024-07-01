package br.com.sedec.sipaflore.service.documento.autorizacao.tipo;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.TipoDocumentoAutorizacao;
import br.com.sedec.sipaflore.repository.documento.autorizacao.tipo.TipoDocumentoAutorizacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoDocumentoAutorizacaoService extends BaseService<TipoDocumentoAutorizacao> implements ITipoDocumentoAutorizacaoService {

    protected TipoDocumentoAutorizacaoService(final BaseRepository<TipoDocumentoAutorizacao> repository) {
        super(repository);
    }

    @Override
    public TipoDocumentoAutorizacaoRepository getRepository() {
        return (TipoDocumentoAutorizacaoRepository) super.getRepository();
    }

}
