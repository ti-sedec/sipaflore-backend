package br.com.sedec.sipaflore.model.status.empreendimento;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.StatusEmpreendimento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusEmpreendimentoMapper extends BaseMapper<StatusEmpreendimentoInDTO, StatusEmpreendimento, StatusEmpreendimentoOutDTO> {
}
