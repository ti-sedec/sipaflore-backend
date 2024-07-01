package br.com.sedec.sipaflore.model.perfil.usuario;

import br.com.sedec.sipaflore.enums.EnumPerfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PerfilUsuarioOutDTO {

    private Long id;
    private String codigo;
    private EnumPerfil perfil;

}
