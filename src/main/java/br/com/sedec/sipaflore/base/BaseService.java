package br.com.sedec.sipaflore.base;

import br.com.sedec.sipaflore.config.common.ApplicationProperties;
import br.com.sedec.sipaflore.config.exception.BadRequestException;
import br.com.sedec.sipaflore.config.security.config.AuthenticationToken;
import br.com.sedec.sipaflore.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static br.com.sedec.sipaflore.config.rsql.RsqlUtil.parseRsql;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.springframework.beans.BeanUtils.copyProperties;

@Getter
@Service
@AllArgsConstructor
public abstract class BaseService<T extends BaseEntity> implements IBaseService<T> {

    protected final BaseRepository<T> repository;

    @Autowired
    private ApplicationProperties properties;

    protected BaseService(final BaseRepository<T> repository) {
        this.repository = repository;
    }

    @Transactional(rollbackFor = Exception.class)
    public T create(final T entity) throws BadRequestException {
        preSave(entity);
        validate(entity);
        return getRepository().save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<T> create(final List<T> entities) throws BadRequestException {
        for (final T entity : entities) {
            preSave(entity);
            validate(entity);
        }

        return getRepository().saveAll(entities);
    }

    @Transactional(readOnly = true)
    public T findById(final Long id) throws BadRequestException {
        return getRepository().findById(id)
            .orElseThrow(() -> new BadRequestException("error.not-found", id));
    }

    @Transactional(readOnly = true)
    public Page<T> findAll(final Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Page<T> findAll(final Pageable pageable, final String search) {
        if (isBlank(search)) {
            return findAll(pageable);
        }

        final Specification<T> specification = parseRsql(search);
        return getRepository().findAll(specification, pageable);
    }

    @Transactional(readOnly = true)
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public T update(final Long id, final T update) throws BadRequestException {
        final T entity = findById(id);
        update.setId(id);
        copy(update, entity);
        preSave(entity);
        validate(entity);
        return getRepository().save(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(final Long id) throws BadRequestException {
        final T entity = findById(id);
        getRepository().delete(entity);
    }

    public void copy(final T update, final T entity) {
        copyProperties(update, entity, "id");
    }

    public void validate(final T entity) throws BadRequestException {
    }

    public void preSave(final T entity) throws BadRequestException {
    }

    public Usuario getLoggedUser() {
        return ofNullable(SecurityContextHolder.getContext())
            .map(security -> (AuthenticationToken) security.getAuthentication())
            .map(AuthenticationToken::getUser)
            .orElse(null);
    }

}
