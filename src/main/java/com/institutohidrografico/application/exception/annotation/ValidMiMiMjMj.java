package com.institutohidrografico.application.exception.annotation;

import com.institutohidrografico.application.exception.validator.ValidatorMiMiMjMj;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidatorMiMiMjMj.class)
public @interface ValidMiMiMjMj {
    public String message() default "{section.valid}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}