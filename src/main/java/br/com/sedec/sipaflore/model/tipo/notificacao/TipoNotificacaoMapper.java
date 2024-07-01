package br.com.sedec.sipaflore.model.tipo.notificacao;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.TipoNotificacao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoNotificacaoMapper extends BaseMapper<TipoNotificacaoInDTO, TipoNotificacao, TipoNotificacaoOutDTO> {
}
