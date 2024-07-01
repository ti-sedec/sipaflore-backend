package br.com.sedec.sipaflore.base;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    public abstract Long getId();

    public abstract void setId(final Long id);

}
