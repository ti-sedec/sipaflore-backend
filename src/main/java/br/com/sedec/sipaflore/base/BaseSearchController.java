package br.com.sedec.sipaflore.base;

import br.com.sedec.sipaflore.config.exception.BadRequestException;
import br.com.sedec.sipaflore.config.rsql.RsqlDoc;
import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Getter
@RequiredArgsConstructor
public abstract class BaseSearchController<R, T, D> {

    protected final IBaseService<T> service;
    protected final BaseMapper<R, T, D> mapper;

    @GetMapping("/{id}")
    @Operation(description = "Find a register by ID.")
    public D findById(@PathVariable final Long id) throws BadRequestException {
        return mapper.toOutDto(service.findById(id));
    }

    /**
     * @param pageable — > You must send pagination data (page, size, order and/or direction)
     * @param search   — > {@link RsqlDoc}
     * @return — > Returns a filtered list if you send the search parameter or all records if you don't
     */
    @GetMapping
    @Operation(description = "Search all paginated records with or without filter.")
    public Page<Object> findAll(final Pageable pageable, @RequestParam(value = "search", required = false) final String search) {
        return service.findAll(pageable, search).map(mapper::toOutDto);
    }

    @GetMapping("/list")
    @Operation(description = "Search all records in list format.")
    public List<D> findAll() {
        return mapper.toOutDto(service.findAll());
    }

}
