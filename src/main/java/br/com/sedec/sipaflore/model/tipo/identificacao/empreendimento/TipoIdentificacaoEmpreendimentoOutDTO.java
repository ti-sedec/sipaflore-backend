package br.com.sedec.sipaflore.model.tipo.identificacao.empreendimento;

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
public class TipoIdentificacaoEmpreendimentoOutDTO {

    private Long id;
    private String descricao;
    private String codigo;

}
