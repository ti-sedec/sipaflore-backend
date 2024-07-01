package br.com.sedec.sipaflore.model.informacao.pessoal;

import br.com.sedec.sipaflore.base.BaseEntityDTO;
import br.com.sedec.sipaflore.config.annotation.CPForCNPJ;
import br.com.sedec.sipaflore.config.annotation.Mandatory;
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
public class InformacaoPessoalInDTO {

    @Mandatory(field = "informacao.pessoal.municipio")
    private BaseEntityDTO municipio;

    private BaseEntityDTO arquivo;

    @Mandatory(field = "informacao.pessoal.nome.razao.social", max = 255)
    private String nomeRazaoSocial;

    @CPForCNPJ
    @Mandatory(field = "informacao.pessoal.cpf.cnpj", max = 255)
    private String cpfCnpj;

    @Mandatory(field = "informacao.pessoal.cep", max = 9)
    private String cep;

    @Mandatory(field = "informacao.pessoal.logradouro", max = 255)
    private String logradouro;

    @Mandatory(field = "informacao.pessoal.numero", max = 255)
    private String numero;

    @Mandatory(field = "informacao.pessoal.complemento", max = 255, necessary = false)
    private String complemento;

    @Mandatory(field = "informacao.pessoal.telefone", max = 255)
    private String telefone;

}
