package br.com.sedec.sipaflore.config.rsql;

import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_DATE_TIME;
import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Locale.ROOT;
import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toList;

public class RsqlSpecification<T> implements Specification<T> {

    private static final String NULL_STRING = "null";
    private final String property;
    private final ComparisonOperator operator;
    private final List<String> arguments;

    public RsqlSpecification(final String property,
                             final ComparisonOperator operator,
                             final List<String> arguments) {
        this.property = property;
        this.operator = operator;
        this.arguments = arguments;
    }

    @Override
    public Predicate toPredicate(@NotNull final Root<T> root, @NotNull final CriteriaQuery<?> query,
                                 @NotNull final CriteriaBuilder builder) {
        final List<Object> args = castArguments(root);
        final Object argument = args.get(0);
        final boolean isNullValidation = isNull(argument) || argument.toString().equals("null");

        switch (requireNonNull(RsqlSearchOperation.getSimpleOperator(operator))) {
            case EQUAL -> {
                if (isNullValidation) {
                    return builder.isNull(getExpression(root, property));
                } else if (argument instanceof String) {
                    return builder.like(builder.upper(getExpression(root, property)),
                        replaceCharacters(argument).toUpperCase(ROOT));
                } else {
                    return builder.equal(getExpression(root, property), argument);
                }
            }

            case NOT_EQUAL -> {
                if (isNullValidation) {
                    return builder.isNotNull(getExpression(root, property));
                } else if (argument instanceof String) {
                    return builder.notLike(builder.upper(getExpression(root, property)),
                        replaceCharacters(argument).toUpperCase(ROOT));
                } else {
                    return builder.notEqual(getExpression(root, property), argument);
                }
            }

            case GREATER_THAN -> {
                return builder.greaterThan(getExpression(root, property), argument.toString());
            }

            case GREATER_THAN_OR_EQUAL -> {
                return builder.greaterThanOrEqualTo(getExpression(root, property), argument.toString());
            }

            case LESS_THAN -> {
                return builder.lessThan(getExpression(root, property), argument.toString());
            }

            case LESS_THAN_OR_EQUAL -> {
                return builder.lessThanOrEqualTo(getExpression(root, property), argument.toString());
            }

            case IN -> {
                return getExpression(root, property).in(args);
            }

            case NOT_IN -> {
                return builder.not(getExpression(root, property).in(args));
            }

            default -> {
                return null;
            }
        }
    }

    private Expression<String> getExpression(Root<T> root, String fieldName) {
        final String[] propertySplit = fieldName.split("\\.");
        final AtomicReference<Path<String>> path = new AtomicReference<>();

        for (final String propertyMap : propertySplit) {
            if (isNull(path.get())) {
                path.set(root.get(propertyMap));
                continue;
            }

            path.set(path.get().get(propertyMap));
        }

        return isNull(path.get()) ? root.get(fieldName) : path.get();
    }

    private String replaceCharacters(final Object argument) {
        return argument.toString().replace('*', '%');
    }

    private List<Object> castArguments(final Root<T> root) {
        final Class<?> type = getExpression(root, property).getJavaType();

        return arguments.stream().map(arg -> {
            if (arg.equalsIgnoreCase(NULL_STRING)) {
                return null;
            } else if (type.equals(Integer.class)) {
                return Integer.parseInt(arg);
            } else if (type.equals(Long.class)) {
                return Long.parseLong(arg);
            } else if (type.isEnum()) {
                return Enum.valueOf((Class<? extends Enum>) type, arg);
            } else if (type.equals(Boolean.class)) {
                return Boolean.valueOf(arg);
            } else if (type.equals(BigDecimal.class)) {
                return BigDecimal.valueOf(Long.parseLong(arg));
            } else if (type.equals(LocalDateTime.class)) {
                return LocalDateTime.parse(arg, ISO_LOCAL_DATE_TIME);
            } else if (type.equals(LocalDate.class)) {
                return LocalDate.parse(arg, ISO_LOCAL_DATE);
            } else if (type.equals(LocalTime.class)) {
                return LocalTime.parse(arg, ISO_LOCAL_TIME);
            } else if (type.equals(Year.class)) {
                return Year.parse(arg, ofPattern("yyyy"));
            } else {
                return arg;
            }
        }).collect(toList());
    }

}
