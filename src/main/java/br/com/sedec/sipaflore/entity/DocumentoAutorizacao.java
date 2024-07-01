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

import java.time.LocalDate;

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
@Table(schema = "sedec_sipaflore_mt", name = "tb_doc_autorizacao")
@AuditTable(schema = "sedec_sipaflore_mt_aud", value = "tb_doc_autorizacao_aud")
@EqualsAndHashCode(of = "id", callSuper = false)
public class DocumentoAutorizacao extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @Audited(targetAuditMode = NOT_AUDITED)
    @JoinColumn(name = "id_papel_usuario_doc_autorizacao", foreignKey = @ForeignKey(name = "fk_doc_autorizacao_01"), nullable = false)
    private PapelUsuarioDocumentoAutorizacao papelUsuario;

    @ManyToOne(fetch = LAZY)
    @Audited(targetAuditMode = NOT_AUDITED)
    @JoinColumn(name = "id_tipo_doc_autorizacao", foreignKey = @ForeignKey(name = "fk_doc_autorizacao_02"), nullable = false)
    private TipoDocumentoAutorizacao tipo;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_doc_autorizacao_03"), nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = LAZY)
    @Audited(targetAuditMode = NOT_AUDITED)
    @JoinColumn(name = "id_arquivo", foreignKey = @ForeignKey(name = "fk_doc_autorizacao_04"), nullable = false)
    private Arquivo arquivo;

    @Column(name = "cpf_ou_cnpj_da_outra_parte", nullable = false)
    private String cpfCnpjOutraParte;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_final")
    private LocalDate dataFinal;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo;

    @Column(name = "desabilitado", nullable = false)
    private Boolean desabilitado;

    @Column(name = "justificativa_indeferimento")
    private String justificativaIndeferimento;

    @Column(name = "poderes", nullable = false)
    private String poderes;

}
