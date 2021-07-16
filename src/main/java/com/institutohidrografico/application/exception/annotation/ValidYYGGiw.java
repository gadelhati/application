package com.institutohidrografico.application.exception.annotation;

import com.institutohidrografico.application.exception.validator.ValidatorYYGGiw;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidatorYYGGiw.class)
public @interface ValidYYGGiw {
    public String message() default "{section.valid}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}