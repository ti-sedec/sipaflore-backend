package br.com.sedec.sipaflore.entity;

import br.com.sedec.sipaflore.config.common.AuditListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static java.time.LocalDateTime.ofInstant;
import static java.time.ZoneId.systemDefault;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "sedec_sipaflore_mt_aud", name = "revinfo", catalog = "sedec_sipaflore_mt_aud")
@RevisionEntity(AuditListener.class)
public class Audit {

    @Id
    @RevisionNumber
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "rev")
    private Long id;

    @RevisionTimestamp
    @Column(nullable = false)
    private Date timestamp;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public LocalDateTime getRevisionDate() {
        return ofInstant(timestamp.toInstant(), systemDefault());
    }

}
