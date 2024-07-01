package br.com.sedec.sipaflore.config.security.model;

public record MtLoginUserDTO(
    String sub,
    Boolean email_verified,
    RealmAccessDTO realm_access,
    String phone,
    String name,
    String preferred_username,
    String given_name,
    String dataNascimento,
    String family_name,
    String nomeMae,
    String email) {
}
