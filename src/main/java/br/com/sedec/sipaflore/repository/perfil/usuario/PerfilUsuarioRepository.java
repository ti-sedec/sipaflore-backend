package br.com.sedec.sipaflore.repository.perfil.usuario;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.entity.PerfilUsuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfilUsuarioRepository extends BaseRepository<PerfilUsuario> {

    List<PerfilUsuario> findByCodigoIn(final List<String> codigos);

}
