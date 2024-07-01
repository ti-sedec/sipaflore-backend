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

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Builder
@Audited
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "sedec_sipaflore_mt", name = "tb_justificativa_indeferimento")
@AuditTable(schema = "sedec_sipaflore_mt_aud", value = "tb_justificativa_indeferimento_aud")
@EqualsAndHashCode(of = "id", callSuper = false)
public class JustificativaIndeferimento extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_analise_documento", foreignKey = @ForeignKey(name = "fk_justificativa_indeferimento_01"), nullable = false)
    private AnaliseDocumento analiseDocumento;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "problema_resolvido", nullable = false)
    private Boolean problemaResolvido;

}
