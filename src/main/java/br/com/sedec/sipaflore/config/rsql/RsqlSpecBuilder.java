package br.com.sedec.sipaflore.config.rsql;

import cz.jirutka.rsql.parser.ast.ComparisonNode;
import cz.jirutka.rsql.parser.ast.LogicalNode;
import cz.jirutka.rsql.parser.ast.Node;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Objects;

import static cz.jirutka.rsql.parser.ast.LogicalOperator.AND;
import static cz.jirutka.rsql.parser.ast.LogicalOperator.OR;
import static org.springframework.data.jpa.domain.Specification.where;

public class RsqlSpecBuilder<T> {

    public Specification<T> createSpecification(final Node node) {
        if (node instanceof final LogicalNode logicalNode) {
            return this.createSpecification(logicalNode);
        }

        if (node instanceof final ComparisonNode comparisonNode) {
            return this.createSpecification(comparisonNode);
        }

        return null;
    }

    public Specification<T> createSpecification(final LogicalNode logicalNode) {
        final List<Specification<T>> specs = logicalNode.getChildren()
            .stream()
            .map(this::createSpecification)
            .filter(Objects::nonNull)
            .toList();

        Specification<T> result = specs.get(0);

        if (AND.equals(logicalNode.getOperator())) {

            for (int index = 1; index < specs.size(); index++) {
                result = where(result).and(specs.get(index));
            }

        } else if (OR.equals(logicalNode.getOperator())) {

            for (int index = 1; index < specs.size(); index++) {
                result = where(result).or(specs.get(index));
            }

        }

        return result;
    }

    public Specification<T> createSpecification(final ComparisonNode comparisonNode) {
        return where(
            new RsqlSpecification<>(
                comparisonNode.getSelector(),
                comparisonNode.getOperator(),
                comparisonNode.getArguments()
            )
        );
    }

}
