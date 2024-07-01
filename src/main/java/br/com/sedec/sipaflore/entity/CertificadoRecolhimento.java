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
@Table(schema = "sedec_sipaflore_mt", name = "tb_certif_recolhi_taxa_repo_florest")
@AuditTable(schema = "sedec_sipaflore_mt_aud", value = "tb_certif_recolhi_taxa_repo_florest_aud")
@EqualsAndHashCode(of = "id", callSuper = false)
public class CertificadoRecolhimento extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_certif_recolhi_taxa_repo_florest_01"), nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_empreendimento", foreignKey = @ForeignKey(name = "fk_certif_recolhi_taxa_repo_florest_02"), nullable = false)
    private Empreendimento empreendimento;

    @ManyToOne(fetch = LAZY)
    @Audited(targetAuditMode = NOT_AUDITED)
    @JoinColumn(name = "id_forma_pagamento", foreignKey = @ForeignKey(name = "fk_certif_recolhi_taxa_repo_florest_03"), nullable = false)
    private FormaPagamento formaPagamento;

    @ManyToOne(fetch = LAZY)
    @Audited(targetAuditMode = NOT_AUDITED)
    @JoinColumn(name = "id_status_certificado", foreignKey = @ForeignKey(name = "fk_certif_recolhi_taxa_repo_florest_04"), nullable = false)
    private StatusCertificado statusCertificado;

    @Column(name = "numero_total_parcelas", nullable = false)
    private Integer numeroTotalParcelas;

    @Column(name = "data_assinatura_doc_emitido_orgao_ambiental", nullable = false)
    private LocalDate dataAssinaturaDocumentoEmitidoOrgaoAmbiental;

    @Column(name = "area_em_hectares_empreendimento", nullable = false)
    private BigDecimal areaHectaresEmpreendimento;

    @Column(name = "numero_processo_sedec")
    private String numeroProcessoSedec;

    @Column(name = "numero_processo_sema")
    private String numeroProcessoSema;

}
