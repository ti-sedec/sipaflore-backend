package br.com.sedec.sipaflore.entity;

import br.com.sedec.sipaflore.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import java.math.BigDecimal;

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
@Table(schema = "sedec_sipaflore_mt", name = "tb_empreendimento")
@AuditTable(schema = "sedec_sipaflore_mt_aud", value = "tb_empreendimento_aud")
@EqualsAndHashCode(of = "id", callSuper = false)
public class Empreendimento extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_empreendimento_01"), nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = LAZY)
    @Audited(targetAuditMode = NOT_AUDITED)
    @JoinColumn(name = "id_municipio", foreignKey = @ForeignKey(name = "fk_empreendimento_02"), nullable = false)
    private Municipio municipio;

    @ManyToOne(fetch = LAZY)
    @Audited(targetAuditMode = NOT_AUDITED)
    @JoinColumn(name = "id_tipo_identificacao_empreendimento", foreignKey = @ForeignKey(name = "fk_empreendimento_03"), nullable = false)
    private TipoIdentificacaoEmpreendimento tipoIdentificacao;

    @ManyToOne(fetch = LAZY)
    @Audited(targetAuditMode = NOT_AUDITED)
    @JoinColumn(name = "id_status_empreendimento", foreignKey = @ForeignKey(name = "fk_empreendimento_04"), nullable = false)
    private StatusEmpreendimento status;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf_ou_cnpj", nullable = false)
    private String cpfCnpj;

    @Column(name = "area_em_hectares", nullable = false)
    private BigDecimal areaHectares;

    @Column(name = "cadastro_cc_sema")
    private String cadastroCcSema;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo;

}
