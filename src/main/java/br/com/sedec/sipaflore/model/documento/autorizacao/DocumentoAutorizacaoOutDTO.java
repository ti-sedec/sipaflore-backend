package br.com.sedec.sipaflore.model.documento.autorizacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoAutorizacaoOutDTO {

    private Long id;
    private PapelUsuarioDocumentoAutorizacaoOutDTO papelUsuario;
    private TipoDocumentoAutorizacaoOutDTO tipo;
    private UsuarioOutDTO usuario;
    private ArquivoOutDTO arquivo;
    private String cpfCnpjOutraParte;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private Boolean ativo;
    private Boolean desabilitado;
    private String justificativaIndeferimento;
    private String poderes;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PapelUsuarioDocumentoAutorizacaoOutDTO {

        private Long id;
        private String codigo;
        private String descricao;

    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TipoDocumentoAutorizacaoOutDTO {

        private Long id;
        private String codigo;
        private String descricao;

    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UsuarioOutDTO {

        private Long id;

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
