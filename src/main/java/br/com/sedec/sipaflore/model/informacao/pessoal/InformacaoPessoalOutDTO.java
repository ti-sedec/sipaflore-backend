package br.com.sedec.sipaflore.model.informacao.pessoal;

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
public class InformacaoPessoalOutDTO {

    private Long id;
    private UsuarioOutDTO usuario;
    private MunicipioOutDTO municipio;
    private ArquivoOutDTO arquivo;
    private String nomeRazaoSocial;
    private String cpfCnpj;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String telefone;

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
    public static class ArquivoOutDTO {

        private Long id;
        private String nomeArquivo;
        private String contentType;
        private String etag;
        private Long size;

    }

}
