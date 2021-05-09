package com.institutohidrografico.application.exception.annotation;

import com.institutohidrografico.application.exception.validator.UniqueSealNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueSealNumberValidator.class)
public @interface UniqueSealNumber {
    public String message() default "{unique.seal.number}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}