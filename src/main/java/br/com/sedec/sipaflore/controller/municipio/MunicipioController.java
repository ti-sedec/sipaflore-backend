package br.com.sedec.sipaflore.controller.municipio;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.entity.Municipio;
import br.com.sedec.sipaflore.model.municipio.MunicipioInDTO;
import br.com.sedec.sipaflore.model.municipio.MunicipioMapper;
import br.com.sedec.sipaflore.model.municipio.MunicipioOutDTO;
import br.com.sedec.sipaflore.service.municipio.IMunicipioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/municipios")
@Tag(name = "Municípios")
public class MunicipioController extends BaseSearchController<MunicipioInDTO, Municipio, MunicipioOutDTO> {

    public MunicipioController(final IMunicipioService service,
                               final MunicipioMapper mapper) {
        super(service, mapper);
    }

}
