package br.com.sedec.sipaflore.controller.common;

import br.com.sedec.sipaflore.service.common.IPublicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
@Tag(name = "Rotas públicas")
@RequiredArgsConstructor
public class PublicController {

    private final IPublicService publicService;

    @GetMapping("/versao")
    @Operation(description = "Busca a versão da API")
    public String getVersion() {
        return publicService.getVersao();
    }

}
