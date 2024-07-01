package br.com.sedec.sipaflore.model.forma.pagamento;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.FormaPagamento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FormaPagamentoMapper extends BaseMapper<FormaPagamentoInDTO, FormaPagamento, FormaPagamentoOutDTO> {
}
