package br.com.sedec.sipaflore.model.municipio;

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
public class MunicipioOutDTO {

    private Long id;
    private String nome;
    private EstadoOutDTO estado;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class EstadoOutDTO {

        private Long id;
        private String nome;
        private String sigla;

    }

}
