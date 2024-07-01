package br.com.sedec.sipaflore.model.arquivo;

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
public class ArquivoOutDTO {

    private Long id;
    private String nomeArquivo;
    private String contentType;
    private String etag;
    private Long size;

}
