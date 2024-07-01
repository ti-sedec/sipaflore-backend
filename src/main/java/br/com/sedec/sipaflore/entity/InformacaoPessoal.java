package br.com.sedec.sipaflore.entity;

import br.com.sedec.sipaflore.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;

@Getter
@Setter
@Entity
@Builder
@Audited
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "sedec_sipaflore_mt", name = "tb_info_pessoal")
@AuditTable(schema = "sedec_sipaflore_mt_aud", value = "tb_info_pessoal_aud")
@EqualsAndHashCode(of = "id", callSuper = false)
public class InformacaoPessoal extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_info_pessoal_01"), nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = LAZY)
    @Audited(targetAuditMode = NOT_AUDITED)
    @JoinColumn(name = "id_municipio", foreignKey = @ForeignKey(name = "fk_info_pessoal_02"), nullable = false)
    private Municipio municipio;

    @ManyToOne(fetch = LAZY)
    @Audited(targetAuditMode = NOT_AUDITED)
    @JoinColumn(name = "id_arquivo", foreignKey = @ForeignKey(name = "fk_info_pessoal_03"), nullable = false)
    private Arquivo arquivo;

    @Column(name = "nome_ou_razao_social", nullable = false)
    private String nomeRazaoSocial;

    @Column(name = "cpf_ou_cnpj", nullable = false)
    private String cpfCnpj;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "numero", nullable = false)
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "telefone", nullable = false)
    private String telefone;

}
