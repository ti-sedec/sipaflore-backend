package br.com.sedec.sipaflore.base;

import br.com.sedec.sipaflore.config.exception.BadRequestException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

public abstract class BaseController<R, T, D> extends BaseSearchController<R, T, D> {

    protected BaseController(final IBaseService<T> service,
                             final BaseMapper<R, T, D> mapper) {
        super(service, mapper);
    }

    @PostMapping
    @Operation(description = "Save a register.")
    public D create(@RequestBody @Valid final R request) throws BadRequestException {
        final T entity = mapper.fromInDto(request);
        return mapper.toOutDto(service.create(entity));
    }

    @PostMapping("/save-all")
    @Operation(description = "Save a register list.")
    public List<D> create(@RequestBody @Valid final List<R> requests) throws BadRequestException {
        final List<T> entities = mapper.fromInDto(requests);
        return mapper.toOutDto(service.create(entities));
    }

    @PutMapping("/{id}")
    @Operation(description = "Update a register by ID.")
    public D update(@PathVariable final Long id, @RequestBody @Valid final R request) throws BadRequestException {
        final T fromInDto = mapper.fromInDto(request);
        return mapper.toOutDto(service.update(id, fromInDto));
    }

    @DeleteMapping("/{id}")
    @Operation(description = "Delete a register by ID.")
    public ResponseEntity<Void> delete(@PathVariable final Long id) throws BadRequestException {
        service.delete(id);
        return ok().build();
    }

}
