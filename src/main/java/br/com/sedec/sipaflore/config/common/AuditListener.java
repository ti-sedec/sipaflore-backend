package br.com.sedec.sipaflore.config.common;

import br.com.sedec.sipaflore.config.exception.BadRequestException;
import br.com.sedec.sipaflore.entity.Audit;
import br.com.sedec.sipaflore.service.usuario.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.hibernate.envers.RevisionListener;
import org.springframework.context.annotation.Lazy;

public class AuditListener implements RevisionListener {

    private final IUsuarioService usuarioService;

    public AuditListener(@Lazy final IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    public void newRevision(final Object revisionEntity) {
        try {
            final Audit audit = (Audit) revisionEntity;
            audit.setUsuario(usuarioService.getUsuarioLogado());
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
    }

}
