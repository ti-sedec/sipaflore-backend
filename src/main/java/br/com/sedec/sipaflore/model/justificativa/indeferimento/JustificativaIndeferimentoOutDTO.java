package br.com.sedec.sipaflore.model.justificativa.indeferimento;

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
public class JustificativaIndeferimentoOutDTO {

    private Long id;
    private AnaliseDocumentoOutDTO analiseDocumento;
    private String descricao;
    private Boolean problemaResolvido;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AnaliseDocumentoOutDTO {

        private Long id;

    }

}
