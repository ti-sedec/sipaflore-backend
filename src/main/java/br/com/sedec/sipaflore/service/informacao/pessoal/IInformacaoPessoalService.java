package br.com.sedec.sipaflore.service.informacao.pessoal;

import br.com.sedec.sipaflore.base.IBaseService;
import br.com.sedec.sipaflore.config.exception.BadRequestException;
import br.com.sedec.sipaflore.entity.InformacaoPessoal;
import org.springframework.web.multipart.MultipartFile;

public interface IInformacaoPessoalService extends IBaseService<InformacaoPessoal> {

    InformacaoPessoal buscarPorUsuarioLogado();

    InformacaoPessoal salvar(final InformacaoPessoal entity, final MultipartFile file) throws BadRequestException;

    InformacaoPessoal atualizar(final InformacaoPessoal update, final MultipartFile file, final Long id) throws BadRequestException;

}
