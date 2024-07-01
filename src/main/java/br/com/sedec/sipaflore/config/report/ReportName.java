package br.com.sedec.sipaflore.config.report;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReportName {

    EXAMPLE("example");

    private final String description;

}
