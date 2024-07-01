package br.com.sedec.sipaflore.service.arquivo;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.config.exception.BadRequestException;
import br.com.sedec.sipaflore.entity.Arquivo;
import br.com.sedec.sipaflore.repository.arquivo.ArquivoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang3.BooleanUtils.isTrue;

@Service
public class ArquivoService extends BaseService<Arquivo> implements IArquivoService {

    private static final Integer MAX_CARACTERES_NOME_ARQUIVO = 255;

    protected ArquivoService(final BaseRepository<Arquivo> repository) {
        super(repository);
    }

    @Override
    public ArquivoRepository getRepository() {
        return (ArquivoRepository) super.getRepository();
    }

    @Transactional(readOnly = true)
    public String buscarBase64(final Long id) {
        return "";
    }

    @Transactional(rollbackFor = Exception.class)
    public Arquivo salvarArquivo(final MultipartFile file, final String nomeGrupo) throws BadRequestException {
        validateFile(file);

        return Arquivo.builder()
            .usuario(getLoggedUser())
            .contentType("")
            .nomeArquivo("")
            .path("")
            .size(0L)
            .build();
    }

    private void validateFile(final MultipartFile file) throws BadRequestException {
        if (isTrue(requireNonNull(file.getOriginalFilename()).length() > MAX_CARACTERES_NOME_ARQUIVO)) {
            throw new BadRequestException("error.file.filename.length", MAX_CARACTERES_NOME_ARQUIVO);
        }
    }

}
