package br.com.sedec.sipaflore.service.documento.autorizacao;

import br.com.sedec.sipaflore.base.IBaseService;
import br.com.sedec.sipaflore.config.exception.BadRequestException;
import br.com.sedec.sipaflore.entity.DocumentoAutorizacao;
import org.springframework.web.multipart.MultipartFile;

public interface IDocumentoAutorizacaoService extends IBaseService<DocumentoAutorizacao> {

    DocumentoAutorizacao create(final DocumentoAutorizacao entity, final MultipartFile file) throws BadRequestException;

    DocumentoAutorizacao update(final Long id, final DocumentoAutorizacao update, final MultipartFile file) throws BadRequestException;

}
