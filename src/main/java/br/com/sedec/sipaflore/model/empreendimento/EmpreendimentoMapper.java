package br.com.sedec.sipaflore.model.empreendimento;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.Empreendimento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpreendimentoMapper extends BaseMapper<EmpreendimentoInDTO, Empreendimento, EmpreendimentoOutDTO> {
}
