package br.com.sedec.sipaflore.model.tipo.identificacao.empreendimento;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.TipoIdentificacaoEmpreendimento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoIdentificacaoEmpreendimentoMapper extends BaseMapper<TipoIdentificacaoEmpreendimentoInDTO, TipoIdentificacaoEmpreendimento, TipoIdentificacaoEmpreendimentoOutDTO> {
}
