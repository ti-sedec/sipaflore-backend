package br.com.sedec.sipaflore.service.arquivo;

import br.com.sedec.sipaflore.base.IBaseService;
import br.com.sedec.sipaflore.config.exception.BadRequestException;
import br.com.sedec.sipaflore.entity.Arquivo;
import org.springframework.web.multipart.MultipartFile;

public interface IArquivoService extends IBaseService<Arquivo> {

    String buscarBase64(final Long id);

    Arquivo salvarArquivo(final MultipartFile file, final String nomeGrupo) throws BadRequestException;

}
