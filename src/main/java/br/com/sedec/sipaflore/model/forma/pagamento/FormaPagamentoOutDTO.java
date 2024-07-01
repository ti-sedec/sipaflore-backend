package br.com.sedec.sipaflore.model.forma.pagamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FormaPagamentoOutDTO {

    private Long id;
    private String codigo;
    private String nome;

}
