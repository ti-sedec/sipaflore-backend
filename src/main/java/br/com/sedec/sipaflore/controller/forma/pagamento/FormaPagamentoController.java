package br.com.sedec.sipaflore.controller.forma.pagamento;

import br.com.sedec.sipaflore.base.BaseSearchController;
import br.com.sedec.sipaflore.entity.FormaPagamento;
import br.com.sedec.sipaflore.model.forma.pagamento.FormaPagamentoInDTO;
import br.com.sedec.sipaflore.model.forma.pagamento.FormaPagamentoMapper;
import br.com.sedec.sipaflore.model.forma.pagamento.FormaPagamentoOutDTO;
import br.com.sedec.sipaflore.service.forma.pagamento.IFormaPagamentoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/formas/pagamentos")
@Tag(name = "Formas de pagamento")
public class FormaPagamentoController extends BaseSearchController<FormaPagamentoInDTO, FormaPagamento, FormaPagamentoOutDTO> {

    public FormaPagamentoController(final IFormaPagamentoService service,
                                    final FormaPagamentoMapper mapper) {
        super(service, mapper);
    }

}
