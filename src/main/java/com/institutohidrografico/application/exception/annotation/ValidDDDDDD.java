package com.institutohidrografico.application.exception.annotation;

import com.institutohidrografico.application.exception.validator.ValidatorDDDDDD;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidatorDDDDDD.class)
public @interface ValidDDDDDD {
    public String message() default "{DDDDDD.valid}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}