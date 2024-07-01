package br.com.sedec.sipaflore.entity;

import br.com.sedec.sipaflore.base.BaseEntity;
import br.com.sedec.sipaflore.enums.EnumPerfil;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.AuditJoinTable;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.GenerationType.IDENTITY;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;
import static org.hibernate.envers.RelationTargetAuditMode.NOT_AUDITED;
import static org.springframework.util.CollectionUtils.isEmpty;

@Getter
@Setter
@Entity
@Builder
@Audited
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "sedec_sipaflore_mt", name = "tb_usuario")
@AuditTable(schema = "sedec_sipaflore_mt_aud", value = "tb_usuario_aud")
@EqualsAndHashCode(of = "id", callSuper = false)
public class Usuario extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToMany(fetch = EAGER)
    @Audited(targetAuditMode = NOT_AUDITED)
    @AuditJoinTable(schema = "sedec_sipaflore_mt_aud", name = "tb_usuario_has_perfil_usuario_aud",
        inverseJoinColumns = {@JoinColumn(name = "id_perfil_usuario")})
    @JoinTable(schema = "sedec_sipaflore_mt", name = "tb_usuario_has_perfil_usuario",
        joinColumns = {@JoinColumn(name = "id_usuario")}, foreignKey = @ForeignKey(name = "fk_usuario_has_perfil_usuario_01"),
        inverseJoinColumns = {@JoinColumn(name = "id_perfil_usuario")}, inverseForeignKey = @ForeignKey(name = "fk_usuario_has_perfil_usuario_02"))
    private List<PerfilUsuario> perfis;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "jti_token", nullable = false)
    private String jtiToken;

    @Column(name = "sub_uuid", nullable = false)
    private String uuid;

    public List<SimpleGrantedAuthority> getAuthorities() {
        if (isEmpty(perfis)) {
            return emptyList();
        }

        return perfis
            .stream()
            .map(PerfilUsuario::getPerfil)
            .map(EnumPerfil::getAuthorities)
            .flatMap(List::stream)
            .collect(toList());
    }

}
