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

import java.time.LocalDateTime;

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
@Table(schema = "sedec_sipaflore_mt", name = "tb_analise_documento")
@AuditTable(schema = "sedec_sipaflore_mt_aud", value = "tb_analise_documento_aud")
@EqualsAndHashCode(of = "id", callSuper = false)
public class AnaliseDocumento extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_analise_documento_01"), nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = LAZY)
    @Audited(targetAuditMode = NOT_AUDITED)
    @JoinColumn(name = "id_status_analise_documento", foreignKey = @ForeignKey(name = "fk_analise_documento_02"), nullable = false)
    private StatusAnaliseDocumento status;

    @ManyToOne(fetch = LAZY)
    @Audited(targetAuditMode = NOT_AUDITED)
    @JoinColumn(name = "id_certif_recolhi_taxa_repo_florest", foreignKey = @ForeignKey(name = "fk_analise_documento_03"), nullable = false)
    private CertificadoRecolhimento certificadoRecolhimento;

    @Column(name = "data_hora_registro", nullable = false)
    private LocalDateTime dataHoraRegistro;

    @Column(name = "data_hora_ultima_alteracao", nullable = false)
    private LocalDateTime dataHoraUltimaAlteracao;

    @Column(name = "versao", nullable = false)
    private Integer versao;

    @Column(name = "parecer")
    private String parecer;

}
