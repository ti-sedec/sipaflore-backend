package br.com.sedec.sipaflore.config.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

import static br.com.sedec.sipaflore.util.Message.getMessage;
import static io.micrometer.common.util.StringUtils.isBlank;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.Character.getNumericValue;
import static java.util.Objects.isNull;
import static java.util.regex.Pattern.compile;
import static org.apache.commons.lang3.BooleanUtils.isFalse;

public class CPForCNPJValidator implements ConstraintValidator<CPForCNPJ, Object> {

    private static final Pattern CPF_PATTERN = compile("\\d{11}");
    private static final Pattern CNPJ_PATTERN = compile("\\d{14}");

    public boolean isValid(final Object value, final ConstraintValidatorContext context) {
        context.disableDefaultConstraintViolation();

        if (isNull(value) || isBlank(value.toString())) {
            return TRUE;
        }

        final String sanitized = value.toString().replaceAll("\\D", "");
        final AtomicBoolean isValid = new AtomicBoolean(FALSE);

        if (CPF_PATTERN.matcher(sanitized).matches()) {
            isValid.set(isValidCPF(sanitized));
        } else if (CNPJ_PATTERN.matcher(sanitized).matches()) {
            isValid.set(isValidCNPJ(sanitized));
        }

        if (isFalse(isValid.get())) {
            context.buildConstraintViolationWithTemplate(getMessage("error.invalid.cpf.cnpj") + "<field>"
                    + "error.cpf.cnpj.field")
                .addConstraintViolation();
        }

        return isValid.get();
    }

    private boolean isValidCPF(final String cpf) {
        if (cpf.chars().distinct().count() == 1) {
            return FALSE;
        }

        final int[] weights1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        final int[] weights2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        final int firstDigit = calculateDigit(cpf.substring(0, 9), weights1);
        final int secondDigit = calculateDigit(cpf.substring(0, 9) + firstDigit, weights2);

        return cpf.equals(cpf.substring(0, 9) + firstDigit + secondDigit);
    }

    private boolean isValidCNPJ(final String cnpj) {
        if (cnpj.chars().distinct().count() == 1) {
            return FALSE;
        }

        final int[] weights1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        final int[] weights2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        final int firstDigit = calculateDigit(cnpj.substring(0, 12), weights1);
        final int secondDigit = calculateDigit(cnpj.substring(0, 12) + firstDigit, weights2);

        return cnpj.equals(cnpj.substring(0, 12) + firstDigit + secondDigit);
    }

    private int calculateDigit(final String value, final int[] weights) {
        int sum = 0;

        for (int i = 0; i < value.length(); i++) {
            sum += getNumericValue(value.charAt(i)) * weights[i];
        }

        final int mod = sum % 11;
        return mod < 2 ? 0 : 11 - mod;
    }

}
