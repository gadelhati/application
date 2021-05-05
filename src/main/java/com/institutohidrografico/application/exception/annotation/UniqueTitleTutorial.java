package com.institutohidrografico.application.exception.annotation;

import com.institutohidrografico.application.exception.validator.UniqueTitleTutorialValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueTitleTutorialValidator.class)
public @interface UniqueTitleTutorial {
    public String message() default "{unique}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}