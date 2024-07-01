package br.com.sedec.sipaflore.config.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MandatoryValidator.class)
@Documented
public @interface Mandatory {

    String message() default "error.not-blank-default";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String field();

    int max() default MAX_VALUE;

    int min() default 0;

    boolean necessary() default true;

}
