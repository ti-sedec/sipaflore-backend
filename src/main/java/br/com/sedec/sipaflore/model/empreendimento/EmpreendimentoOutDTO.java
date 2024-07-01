package br.com.sedec.sipaflore.model.empreendimento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpreendimentoOutDTO {

    private Long id;
    private UsuarioOutDTO usuario;
    private MunicipioOutDTO municipio;
    private TipoIdentificacaoEmpreendimentoOutDTO tipoIdentificacao;
    private StatusEmpreendimentoOutDTO status;
    private String nome;
    private String cpfCnpj;
    private BigDecimal areaHectares;
    private String cadastroCcSema;
    private Boolean ativo;

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
    public static class MunicipioOutDTO {

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

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TipoIdentificacaoEmpreendimentoOutDTO {

        private Long id;
        private String codigo;
        private String descricao;

    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StatusEmpreendimentoOutDTO {

        private Long id;
        private String codigo;
        private String descricao;

    }

}
