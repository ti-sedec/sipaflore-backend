package br.com.sedec.sipaflore.service.documento.autorizacao;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.config.exception.BadRequestException;
import br.com.sedec.sipaflore.entity.DocumentoAutorizacao;
import br.com.sedec.sipaflore.repository.documento.autorizacao.DocumentoAutorizacaoRepository;
import br.com.sedec.sipaflore.service.arquivo.IArquivoService;
import br.com.sedec.sipaflore.service.usuario.IUsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import static br.com.sedec.sipaflore.enums.EnumPerfil.ANALISTA_SEDEC;
import static br.com.sedec.sipaflore.util.FileUtils.DEFAULT_DOCUMENT_EXTENSIONS;
import static br.com.sedec.sipaflore.util.FileUtils.validateFile;
import static java.lang.Boolean.TRUE;
import static java.time.LocalDate.now;
import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.BooleanUtils.isFalse;
import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class DocumentoAutorizacaoService extends BaseService<DocumentoAutorizacao> implements IDocumentoAutorizacaoService {

    private static final String NOME_GRUPO = "documento-autorizacao";
    private final IArquivoService arquivoService;
    private final IUsuarioService usuarioService;

    protected DocumentoAutorizacaoService(final BaseRepository<DocumentoAutorizacao> repository,
                                          final IArquivoService arquivoService,
                                          final IUsuarioService usuarioService) {
        super(repository);
        this.arquivoService = arquivoService;
        this.usuarioService = usuarioService;
    }

    @Override
    public DocumentoAutorizacaoRepository getRepository() {
        return (DocumentoAutorizacaoRepository) super.getRepository();
    }

    @Transactional(rollbackFor = Exception.class)
    public DocumentoAutorizacao create(final DocumentoAutorizacao entity, final MultipartFile file) throws BadRequestException {
        validateFile(file, 5, DEFAULT_DOCUMENT_EXTENSIONS);
        entity.setArquivo(arquivoService.salvarArquivo(file, NOME_GRUPO));
        entity.setUsuario(getLoggedUser());
        entity.setDesabilitado(TRUE);
        return getRepository().save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public DocumentoAutorizacao update(final Long id, final DocumentoAutorizacao update, final MultipartFile file) throws BadRequestException {
        final DocumentoAutorizacao entity = super.findById(id);
        validateUpdate(entity);
        update.setId(id);
        copy(update, entity);

        if (nonNull(file) && isFalse(file.isEmpty())) {
            validateFile(file, 5, DEFAULT_DOCUMENT_EXTENSIONS);
            entity.setArquivo(arquivoService.salvarArquivo(file, NOME_GRUPO));
        }

        return getRepository().save(entity);
    }

    @Override
    public void copy(final DocumentoAutorizacao update, final DocumentoAutorizacao entity) {
        copyProperties(update, entity, "id", "usuario", "desabilitado");
    }

    private void validateUpdate(final DocumentoAutorizacao entity) throws BadRequestException {
        final Boolean isUserLogadoAnalista = usuarioService.usuarioLogadoHasPerfil(ANALISTA_SEDEC);

        if (isFalse(entity.getAtivo()) && isFalse(isUserLogadoAnalista)
            && nonNull(entity.getDataFinal()) && now().isAfter(entity.getDataFinal())) {
            throw new BadRequestException("documento.autorizacao.inativo.apenas.analista");
        }
    }

}
