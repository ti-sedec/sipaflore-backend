package br.com.sedec.sipaflore.service.documento.autorizacao.papel.usuario;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.PapelUsuarioDocumentoAutorizacao;
import br.com.sedec.sipaflore.repository.documento.autorizacao.papel.usuario.PapelUsuarioDocumentoAutorizacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class PapelUsuarioDocumentoAutorizacaoService extends BaseService<PapelUsuarioDocumentoAutorizacao> implements IPapelUsuarioDocumentoAutorizacaoService {

    protected PapelUsuarioDocumentoAutorizacaoService(final BaseRepository<PapelUsuarioDocumentoAutorizacao> repository) {
        super(repository);
    }

    @Override
    public PapelUsuarioDocumentoAutorizacaoRepository getRepository() {
        return (PapelUsuarioDocumentoAutorizacaoRepository) super.getRepository();
    }

}
