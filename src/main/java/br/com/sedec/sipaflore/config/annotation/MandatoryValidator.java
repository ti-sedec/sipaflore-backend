package br.com.sedec.sipaflore.config.annotation;

import br.com.sedec.sipaflore.base.BaseEntityDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;
import java.util.Objects;

import static br.com.sedec.sipaflore.util.Message.getMessage;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

public class MandatoryValidator implements ConstraintValidator<Mandatory, Object> {

    private int min;

    private int max;

    private String field;

    private boolean necessary;

    @Override
    public void initialize(final Mandatory constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
        this.field = constraintAnnotation.field();
        this.necessary = constraintAnnotation.necessary();
    }

    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        if (necessary && isNull(value)) {
            return addErrorNotBlank(context);
        }

        if (value instanceof String) {
            final String valueString = value.toString();

            if (necessary && isBlank(valueString)) {
                return addErrorNotBlank(context);
            }

            if (valueString.length() < min || valueString.length() > max) {
                return addErrorRangeInvalid(context);
            }
        }

        if (value instanceof final Long valueLong && (valueLong < min || valueLong > max)) {
            return addErrorRangeInvalid(context);
        }

        if (value instanceof final Integer valueInteger && (valueInteger < min || valueInteger > max)) {
            return addErrorRangeInvalid(context);
        }

        if (value instanceof final Double valueDouble && (valueDouble < min || valueDouble > max)) {
            return addErrorRangeInvalid(context);
        }

        if (value instanceof final Float valueFloat && (valueFloat < min || valueFloat > max)) {
            return addErrorRangeInvalid(context);
        }

        if (value instanceof final BigDecimal valueBigDecimal
            && (valueBigDecimal.floatValue() < min || valueBigDecimal.floatValue() > max)) {
            return addErrorRangeInvalid(context);
        }

        if (value instanceof final BaseEntityDTO dto) {
            if (isNull(dto.getId())) {
                return addErrorNotBlank(context);
            }

            if (dto.getId() < 1 || dto.getId() > max) {
                return addErrorRangeInvalid(context);
            }
        }

        return TRUE;
    }

    private boolean addErrorNotBlank(final ConstraintValidatorContext context) {
        context.buildConstraintViolationWithTemplate(getMessage("error.not-blank") + "<field>" + field)
            .addConstraintViolation();

        return FALSE;
    }

    private boolean addErrorRangeInvalid(final ConstraintValidatorContext context) {
        final String msgError = Objects.equals(min, max) ? getMessage("error.insufficient-value", min) :
            getMessage("error.min-max-value", min, max);

        context.buildConstraintViolationWithTemplate(msgError + "<field>" + field)
            .addConstraintViolation();

        return FALSE;
    }

}
