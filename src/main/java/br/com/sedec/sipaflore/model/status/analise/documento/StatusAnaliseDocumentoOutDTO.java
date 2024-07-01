package br.com.sedec.sipaflore.model.status.analise.documento;

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
public class StatusAnaliseDocumentoOutDTO {

    private Long id;
    private String codigo;
    private String descricao;

}
