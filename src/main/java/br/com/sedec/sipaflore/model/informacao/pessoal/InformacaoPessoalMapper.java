package br.com.sedec.sipaflore.model.informacao.pessoal;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.InformacaoPessoal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InformacaoPessoalMapper extends BaseMapper<InformacaoPessoalInDTO, InformacaoPessoal, InformacaoPessoalOutDTO> {
}
