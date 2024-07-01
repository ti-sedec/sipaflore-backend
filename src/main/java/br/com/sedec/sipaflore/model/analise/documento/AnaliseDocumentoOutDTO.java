package br.com.sedec.sipaflore.model.analise.documento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnaliseDocumentoOutDTO {

    private Long id;
    private UsuarioOutDTO usuario;
    private StatusAnaliseDocumentoOutDTO status;
    private CertificadoRecolhimentoOutDTO certificadoRecolhimento;
    private LocalDateTime dataHoraRegistro;
    private LocalDateTime dataHoraUltimaAlteracao;
    private Integer versao;
    private String parecer;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UsuarioOutDTO {

        private Long id;
        private String nome;

    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StatusAnaliseDocumentoOutDTO {

        private Long id;
        private String codigo;
        private String descricao;

    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CertificadoRecolhimentoOutDTO {

        private Long id;

    }

}
