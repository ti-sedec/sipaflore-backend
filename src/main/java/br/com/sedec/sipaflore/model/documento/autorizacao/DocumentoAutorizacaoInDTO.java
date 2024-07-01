package br.com.sedec.sipaflore.model.documento.autorizacao;

import br.com.sedec.sipaflore.base.BaseEntityDTO;
import br.com.sedec.sipaflore.config.annotation.CPForCNPJ;
import br.com.sedec.sipaflore.config.annotation.Mandatory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

import static java.lang.Boolean.TRUE;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoAutorizacaoInDTO {

    @Mandatory(field = "documento.autorizacao.papel.usuario")
    private BaseEntityDTO papelUsuario;

    private BaseEntityDTO arquivo;

    @Mandatory(field = "documento.autorizacao.tipo")
    private BaseEntityDTO tipo;

    @CPForCNPJ
    @Mandatory(field = "documento.autorizacao.cpf.cnpj", max = 255)
    private String cpfCnpjOutraParte;

    @DateTimeFormat(iso = DATE)
    @Mandatory(field = "documento.autorizacao.data.inicio")
    private LocalDate dataInicio;

    @DateTimeFormat(iso = DATE)
    private LocalDate dataFinal;

    @Builder.Default
    private Boolean ativo = TRUE;

    @Mandatory(field = "documento.autorizacao.poderes")
    private String poderes;

}
