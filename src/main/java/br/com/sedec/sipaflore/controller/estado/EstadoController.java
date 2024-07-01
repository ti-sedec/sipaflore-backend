package br.com.sedec.sipaflore.controller.estado;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.entity.Estado;
import br.com.sedec.sipaflore.model.estado.EstadoInDTO;
import br.com.sedec.sipaflore.model.estado.EstadoMapper;
import br.com.sedec.sipaflore.model.estado.EstadoOutDTO;
import br.com.sedec.sipaflore.service.estado.IEstadoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
@Tag(name = "Estados")
public class EstadoController extends BaseSearchController<EstadoInDTO, Estado, EstadoOutDTO> {

    public EstadoController(final IEstadoService service,
                            final EstadoMapper mapper) {
        super(service, mapper);
    }

}
