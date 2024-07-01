package br.com.sedec.sipaflore.repository.usuario;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario> {

    Optional<Usuario> findByEmailIgnoreCase(final String email);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN TRUE ELSE FALSE END " +
        "FROM Usuario u " +
        "JOIN u.perfis p " +
        "WHERE p.codigo = :codigoPerfil " +
        "AND u.id = :idUsuario")
    Boolean usuarioHasPerfil(final String codigoPerfil, final Long idUsuario);

}
