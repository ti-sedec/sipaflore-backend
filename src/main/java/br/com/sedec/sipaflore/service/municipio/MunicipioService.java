package br.com.sedec.sipaflore.service.municipio;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.base.BaseService;
import br.com.sedec.sipaflore.entity.Municipio;
import br.com.sedec.sipaflore.repository.municipio.MunicipioRepository;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService extends BaseService<Municipio> implements IMunicipioService {

    protected MunicipioService(final BaseRepository<Municipio> repository) {
        super(repository);
    }

    @Override
    public MunicipioRepository getRepository() {
        return (MunicipioRepository) super.getRepository();
    }

}
