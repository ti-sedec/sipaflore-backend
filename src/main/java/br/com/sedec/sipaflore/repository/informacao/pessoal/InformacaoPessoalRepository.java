package br.com.sedec.sipaflore.repository.informacao.pessoal;

import br.com.sedec.sipaflore.base.BaseRepository;
import br.com.sedec.sipaflore.entity.InformacaoPessoal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InformacaoPessoalRepository extends BaseRepository<InformacaoPessoal> {

    @Query("SELECT CASE WHEN COUNT(ip) > 0 THEN TRUE ELSE FALSE END " +
        "FROM InformacaoPessoal ip " +
        "JOIN ip.usuario u " +
        "WHERE u.id = :idUsuario " +
        "AND ip.id <> :id")
    Boolean existsUsuarioById(final Long idUsuario, final Long id);

    Optional<InformacaoPessoal> findByUsuario_Id(final Long idUsuario);

}
