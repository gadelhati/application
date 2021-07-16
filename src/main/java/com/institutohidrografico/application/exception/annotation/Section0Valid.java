package com.institutohidrografico.application.exception.annotation;

import com.institutohidrografico.application.exception.validator.ValidatorSection0;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidatorSection0.class)
public @interface Section0Valid {
    public String message() default "{section.valid}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}