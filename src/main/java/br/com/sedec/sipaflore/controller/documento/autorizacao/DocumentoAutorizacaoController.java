package br.com.sedec.sipaflore.controller.documento.autorizacao;

import br.com.sedec.sipaflore.base.BaseController;
import br.com.sedec.sipaflore.config.exception.BadRequestException;
import br.com.sedec.sipaflore.entity.DocumentoAutorizacao;
import br.com.sedec.sipaflore.model.documento.autorizacao.DocumentoAutorizacaoInDTO;
import br.com.sedec.sipaflore.model.documento.autorizacao.DocumentoAutorizacaoMapper;
import br.com.sedec.sipaflore.model.documento.autorizacao.DocumentoAutorizacaoOutDTO;
import br.com.sedec.sipaflore.service.documento.autorizacao.IDocumentoAutorizacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@RestController
@RequestMapping("/documentos/autorizacoes")
@Tag(name = "Documentos de autorização")
public class DocumentoAutorizacaoController extends BaseController<DocumentoAutorizacaoInDTO, DocumentoAutorizacao, DocumentoAutorizacaoOutDTO> {

    private static final String ERROR_INVALID_REQUEST = "error.invalid.request";

    public DocumentoAutorizacaoController(final IDocumentoAutorizacaoService service,
                                          final DocumentoAutorizacaoMapper mapper) {
        super(service, mapper);
    }

    @Override
    public DocumentoAutorizacaoOutDTO create(final DocumentoAutorizacaoInDTO request) throws BadRequestException {
        throw new BadRequestException(ERROR_INVALID_REQUEST);
    }

    @Override
    public DocumentoAutorizacaoOutDTO update(final Long id, final DocumentoAutorizacaoInDTO request) throws BadRequestException {
        throw new BadRequestException(ERROR_INVALID_REQUEST);
    }

    @PostMapping(path = "/salvar", consumes = {APPLICATION_JSON_VALUE, MULTIPART_FORM_DATA_VALUE})
    @Operation(description = "Cria um novo registro de documento de autorização/procuração")
    public DocumentoAutorizacaoOutDTO create(@RequestPart @Valid final DocumentoAutorizacaoInDTO request,
                                             @RequestPart final MultipartFile file) throws BadRequestException {
        return getMapper().toOutDto(getService().create(getMapper().fromInDto(request), file));
    }

    @PutMapping(path = "/atualizar/{id}", consumes = {APPLICATION_JSON_VALUE, MULTIPART_FORM_DATA_VALUE})
    @Operation(description = "Atualiza um registro existente de documento de autorização/procuração")
    public DocumentoAutorizacaoOutDTO update(@PathVariable final Long id,
                                             @RequestPart @Valid final DocumentoAutorizacaoInDTO request,
                                             @RequestPart(required = false) final MultipartFile file) throws BadRequestException {
        return getMapper().toOutDto(getService().update(id, getMapper().fromInDto(request), file));
    }

    @Override
    public IDocumentoAutorizacaoService getService() {
        return (IDocumentoAutorizacaoService) super.getService();
    }

    @Override
    public DocumentoAutorizacaoMapper getMapper() {
        return (DocumentoAutorizacaoMapper) super.getMapper();
    }

}
