package br.com.sedec.sipaflore.service.perfil.usuario;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.PerfilUsuario;
import br.com.sedec.sipaflore.repository.perfil.usuario.PerfilUsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilUsuarioService extends BaseService<PerfilUsuario> implements IPerfilUsuarioService {

    protected PerfilUsuarioService(final BaseRepository<PerfilUsuario> repository) {
        super(repository);
    }

    @Override
    public PerfilUsuarioRepository getRepository() {
        return (PerfilUsuarioRepository) super.getRepository();
    }

    public List<PerfilUsuario> findByCodigos(final List<String> codigos) {
        return getRepository().findByCodigoIn(codigos);
    }

}
