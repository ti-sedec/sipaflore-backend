package br.com.sedec.sipaflore.service.estado;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.Estado;
import br.com.sedec.sipaflore.repository.estado.EstadoRepository;
import org.springframework.stereotype.Service;

@Service
public class EstadoService extends BaseService<Estado> implements IEstadoService {

    protected EstadoService(final BaseRepository<Estado> repository) {
        super(repository);
    }

    @Override
    public EstadoRepository getRepository() {
        return (EstadoRepository) super.getRepository();
    }

}
