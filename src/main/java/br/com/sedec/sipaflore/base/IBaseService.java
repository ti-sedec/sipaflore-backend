package br.com.sedec.sipaflore.base;

import br.com.sedec.sipaflore.config.exception.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBaseService<T> {

    T create(final T entity) throws BadRequestException;

    List<T> create(final List<T> entities) throws BadRequestException;

    T findById(final Long id) throws BadRequestException;

    Page<T> findAll(final Pageable pageable);

    Page<T> findAll(final Pageable pageable, final String search);

    List<T> findAll();

    T update(final Long id, final T update) throws BadRequestException;

    void delete(final Long id) throws BadRequestException;

}
