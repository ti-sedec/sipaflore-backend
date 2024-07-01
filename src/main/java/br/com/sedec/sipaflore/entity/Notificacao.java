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
@Table(schema = "sedec_sipaflore_mt", name = "tb_notificacao")
@AuditTable(schema = "sedec_sipaflore_mt_aud", value = "tb_notificacao_aud")
@EqualsAndHashCode(of = "id", callSuper = false)
public class Notificacao extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_notificacao_01"), nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = LAZY)
    @Audited(targetAuditMode = NOT_AUDITED)
    @JoinColumn(name = "id_tipo_notificacao", foreignKey = @ForeignKey(name = "fk_notificacao_02"), nullable = false)
    private TipoNotificacao tipoNotificacao;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "descricao_breve", nullable = false)
    private String descricaoBreve;

    @Column(name = "visualizada", nullable = false)
    private Boolean flagVisualizada;

    @Column(name = "data_hora_criacao", nullable = false)
    private LocalDateTime dataHoraCriacao;

    @Column(name = "data_hora_ultima_atualizacao", nullable = false)
    private LocalDateTime dataHoraUltimaAtualizacao;

}
