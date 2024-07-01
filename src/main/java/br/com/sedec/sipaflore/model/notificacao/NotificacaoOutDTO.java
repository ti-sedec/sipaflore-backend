package br.com.sedec.sipaflore.model.notificacao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificacaoOutDTO {

    private Long id;
    private UsuarioOutDTO usuario;
    private TipoNotificacaoOutDTO tipoNotificacao;
    private String titulo;
    private String descricao;
    private String descricaoBreve;
    private Boolean flagVisualizada;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraUltimaAtualizacao;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UsuarioOutDTO {

        private Long id;
        private String nome;

    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TipoNotificacaoOutDTO {

        private Long id;
        private String nome;

    }

}
