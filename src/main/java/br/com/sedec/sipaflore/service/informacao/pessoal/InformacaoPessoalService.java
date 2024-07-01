package br.com.sedec.sipaflore.service.informacao.pessoal;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.config.exception.BadRequestException;
import br.com.sedec.sipaflore.entity.InformacaoPessoal;
import br.com.sedec.sipaflore.repository.informacao.pessoal.InformacaoPessoalRepository;
import br.com.sedec.sipaflore.service.arquivo.IArquivoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import static br.com.sedec.sipaflore.util.FileUtils.DEFAULT_IMAGE_EXTENSIONS;
import static br.com.sedec.sipaflore.util.FileUtils.validateFile;
import static java.lang.Boolean.FALSE;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Optional.of;
import static org.apache.commons.lang3.BooleanUtils.isFalse;
import static org.apache.commons.lang3.BooleanUtils.isTrue;
import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class InformacaoPessoalService extends BaseService<InformacaoPessoal> implements IInformacaoPessoalService {

    private static final String NOME_GRUPO = "informacao-pessoal";
    private static final int TAMANHO_MAXIMO_ARQUIVO = 1;
    private final IArquivoService arquivoService;

    protected InformacaoPessoalService(final BaseRepository<InformacaoPessoal> repository,
                                       final IArquivoService arquivoService) {
        super(repository);
        this.arquivoService = arquivoService;
    }

    @Override
    public InformacaoPessoalRepository getRepository() {
        return (InformacaoPessoalRepository) super.getRepository();
    }

    @Override
    public void validate(final InformacaoPessoal entity) throws BadRequestException {
        final Long id = isNull(entity.getId()) ? 0L : entity.getId();

        if (isTrue(hasRegistroFromUsuario(getLoggedUser().getId(), id))) {
            throw new BadRequestException("informacao.pessoal.registro.existente");
        }
    }

    private Boolean hasRegistroFromUsuario(final Long idUsuario, final Long id) {
        return of(getRepository().existsUsuarioById(idUsuario, id)).orElse(FALSE);
    }

    @Transactional(readOnly = true)
    public InformacaoPessoal buscarPorUsuarioLogado() {
        return getRepository().findByUsuario_Id(getLoggedUser().getId()).orElse(null);
    }

    @Transactional(rollbackFor = Exception.class)
    public InformacaoPessoal salvar(final InformacaoPessoal entity, final MultipartFile file) throws BadRequestException {
        validate(entity);
        validateFile(file, TAMANHO_MAXIMO_ARQUIVO, DEFAULT_IMAGE_EXTENSIONS);

        entity.setArquivo(arquivoService.salvarArquivo(file, NOME_GRUPO));
        entity.setUsuario(getLoggedUser());

        return getRepository().save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public InformacaoPessoal atualizar(final InformacaoPessoal update, final MultipartFile file, final Long id) throws BadRequestException {
        final InformacaoPessoal entity = super.findById(id);
        update.setId(id);
        copy(update, entity);
        validate(entity);

        if (nonNull(file) && isFalse(file.isEmpty())) {
            validateFile(file, TAMANHO_MAXIMO_ARQUIVO, DEFAULT_IMAGE_EXTENSIONS);
            entity.setArquivo(arquivoService.salvarArquivo(file, NOME_GRUPO));
        }

        return getRepository().save(entity);
    }

    @Override
    public void copy(final InformacaoPessoal update, final InformacaoPessoal entity) {
        copyProperties(update, entity, "id", "usuario", "arquivo");
    }

}
