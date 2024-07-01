package br.com.sedec.sipaflore.config.security.model;

import java.util.List;

public record RealmAccessDTO(List<String> roles) {
}
