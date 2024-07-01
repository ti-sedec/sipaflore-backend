package br.com.sedec.sipaflore.service.usuario;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.config.exception.BadRequestException;
import br.com.sedec.sipaflore.entity.Usuario;
import br.com.sedec.sipaflore.enums.EnumPerfil;
import br.com.sedec.sipaflore.repository.usuario.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;

@Service
public class UsuarioService extends BaseService<Usuario> implements IUsuarioService {

    protected UsuarioService(final BaseRepository<Usuario> repository) {
        super(repository);
    }

    @Override
    public UsuarioRepository getRepository() {
        return (UsuarioRepository) super.getRepository();
    }

    public Usuario findByEmail(final String email) {
        return getRepository().findByEmailIgnoreCase(email).orElse(null);
    }

    @Transactional(readOnly = true)
    public Usuario getUsuarioLogado() throws BadRequestException {
        final Usuario usuarioLogado = super.getLoggedUser();

        if (isNull(usuarioLogado)) {
            return null;
        }

        return getRepository().findById(usuarioLogado.getId())
            .orElseThrow(() -> new BadRequestException("usuario.logado.not-found"));
    }

    @Transactional(readOnly = true)
    public Boolean usuarioLogadoHasPerfil(final EnumPerfil perfil) throws BadRequestException {
        final Long idUsuario = ofNullable(getLoggedUser())
            .map(Usuario::getId)
            .orElseThrow(() -> new BadRequestException("usuario.logado.not-found"));

        return getRepository().usuarioHasPerfil(perfil.getCodigo(), idUsuario);
    }

}
