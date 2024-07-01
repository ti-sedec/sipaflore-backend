package br.com.sedec.sipaflore.base;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BaseMapper<R, T, D> {

    T fromInDto(final R request);

    List<T> fromInDto(final List<R> request);

    D toOutDto(final T entity);

    List<D> toOutDto(final List<T> entity);

    R toInDto(final T entity);

}
