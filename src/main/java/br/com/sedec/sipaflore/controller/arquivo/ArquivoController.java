package br.com.sedec.sipaflore.controller.arquivo;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.entity.Arquivo;
import br.com.sedec.sipaflore.model.arquivo.ArquivoInDTO;
import br.com.sedec.sipaflore.model.arquivo.ArquivoMapper;
import br.com.sedec.sipaflore.model.arquivo.ArquivoOutDTO;
import br.com.sedec.sipaflore.service.arquivo.IArquivoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/arquivos")
@Tag(name = "Arquivos/documentos salvos no armazenamento externo de arquivos")
public class ArquivoController extends BaseSearchController<ArquivoInDTO, Arquivo, ArquivoOutDTO> {

    public ArquivoController(final IArquivoService service,
                             final ArquivoMapper mapper) {
        super(service, mapper);
    }

    @GetMapping("/base-64/{id}")
    @Operation(description = "Retorna o arquivo em Base64")
    public String buscarBase64(@PathVariable final Long id) {
        return getService().buscarBase64(id);
    }

    @Override
    public IArquivoService getService() {
        return (IArquivoService) super.getService();
    }

    @Override
    public ArquivoMapper getMapper() {
        return (ArquivoMapper) super.getMapper();
    }

}
