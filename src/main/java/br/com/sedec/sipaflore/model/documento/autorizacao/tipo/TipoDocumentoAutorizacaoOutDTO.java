package br.com.sedec.sipaflore.model.documento.autorizacao.tipo;

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
public class TipoDocumentoAutorizacaoOutDTO {

    private Long id;
    private String codigo;
    private String descricao;
    private String descricaoLonga;

}
