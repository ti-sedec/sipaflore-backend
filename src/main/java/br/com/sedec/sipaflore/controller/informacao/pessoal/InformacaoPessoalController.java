package br.com.sedec.sipaflore.controller.informacao.pessoal;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.config.exception.BadRequestException;
import br.com.sedec.sipaflore.entity.InformacaoPessoal;
import br.com.sedec.sipaflore.model.informacao.pessoal.InformacaoPessoalInDTO;
import br.com.sedec.sipaflore.model.informacao.pessoal.InformacaoPessoalMapper;
import br.com.sedec.sipaflore.model.informacao.pessoal.InformacaoPessoalOutDTO;
import br.com.sedec.sipaflore.service.informacao.pessoal.IInformacaoPessoalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/informacoes/pessoais")
@Tag(name = "Informações pessoais dos usuários")
public class InformacaoPessoalController extends BaseSearchController<InformacaoPessoalInDTO, InformacaoPessoal, InformacaoPessoalOutDTO> {

    public InformacaoPessoalController(final IInformacaoPessoalService service,
                                       final InformacaoPessoalMapper mapper) {
        super(service, mapper);
    }

    @GetMapping("/validacoes/usuario-logado")
    @Operation(description = "Busca o registro salvo a partir do usuário logado")
    public InformacaoPessoalOutDTO buscarPorUsuarioLogado() {
        return getMapper().toOutDto(getService().buscarPorUsuarioLogado());
    }

    @PostMapping(path = "/salvar", consumes = {APPLICATION_JSON_VALUE, MULTIPART_FORM_DATA_VALUE})
    @Operation(description = "Cria um novo registro de informações pessoais para o usuário logado")
    public InformacaoPessoalOutDTO salvar(@RequestPart @Valid final InformacaoPessoalInDTO request,
                                          @RequestPart final MultipartFile file) throws BadRequestException {
        return getMapper().toOutDto(getService().salvar(getMapper().fromInDto(request), file));
    }

    @PutMapping(path = "/atualizar/{id}", consumes = {APPLICATION_JSON_VALUE, MULTIPART_FORM_DATA_VALUE})
    @Operation(description = "Atualiza um registro existente de informações pessoais do usuário logado")
    public InformacaoPessoalOutDTO atualizar(@RequestPart @Valid final InformacaoPessoalInDTO request,
                                             @RequestPart(required = false) final MultipartFile file,
                                             @PathVariable final Long id) throws BadRequestException {
        return getMapper().toOutDto(getService().atualizar(getMapper().fromInDto(request), file, id));
    }

    @Override
    public IInformacaoPessoalService getService() {
        return (IInformacaoPessoalService) super.getService();
    }

    @Override
    public InformacaoPessoalMapper getMapper() {
        return (InformacaoPessoalMapper) super.getMapper();
    }

}
