package br.com.sedec.sipaflore.model.justificativa.indeferimento;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.JustificativaIndeferimento;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JustificativaIndeferimentoMapper extends BaseMapper<JustificativaIndeferimentoInDTO, JustificativaIndeferimento, JustificativaIndeferimentoOutDTO> {
}
