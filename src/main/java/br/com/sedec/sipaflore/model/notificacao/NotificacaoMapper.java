package br.com.sedec.sipaflore.model.notificacao;

import br.com.sedec.sipaflore.base.BaseMapper;
import br.com.sedec.sipaflore.entity.Notificacao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificacaoMapper extends BaseMapper<NotificacaoInDTO, Notificacao, NotificacaoOutDTO> {
}
