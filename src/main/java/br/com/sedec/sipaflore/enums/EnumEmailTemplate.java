package br.com.sedec.sipaflore.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumEmailTemplate {

    EXAMPLE("example");

    private final String filename;

}
