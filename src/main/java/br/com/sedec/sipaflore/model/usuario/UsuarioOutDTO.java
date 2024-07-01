package br.com.sedec.sipaflore.model.usuario;

import br.com.sedec.sipaflore.enums.EnumPerfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioOutDTO {

    private Long id;
    private String username;
    private String jtiToken;
    private String uuid;
    private String email;
    private List<PerfilOutDTO> perfis;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PerfilOutDTO {

        private Long id;
        private String codigo;
        private EnumPerfil perfil;

    }

}
