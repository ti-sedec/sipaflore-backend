package br.com.sedec.sipaflore.model.certificado.recolhimento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificadoRecolhimentoOutDTO {

    private Long id;
    private UsuarioOutDTO usuario;
    private EmpreendimentoOutDTO empreendimento;
    private FormaPagamentoOutDTO formaPagamento;
    private StatusCertificadoOutDTO statusCertificado;
    private Integer numeroTotalParcelas;
    private LocalDate dataAssinaturaDocumentoEmitidoOrgaoAmbiental;
    private BigDecimal areaHectaresEmpreendimento;
    private String numeroProcessoSedec;
    private String numeroProcessoSema;

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
    public static class EmpreendimentoOutDTO {

        private Long id;
        private String nome;
        private BigDecimal areaHectares;

    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FormaPagamentoOutDTO {

        private Long id;
        private String codigo;
        private String nome;

    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StatusCertificadoOutDTO {

        private Long id;
        private String codigo;
        private String descricao;

    }

}
