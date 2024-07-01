package br.com.sedec.sipaflore.model.estado;

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
public class EstadoOutDTO {

    private Long id;
    private String nome;
    private String sigla;

}
