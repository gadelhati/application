package com.institutohidrografico.application.exception.annotation;

import com.institutohidrografico.application.exception.validator.UniqueClasseNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueClasseNameValidator.class)
public @interface UniqueClasseName {
    public String message() default "{unique}";
    public Class<?>[] groups() default { };
    public Class<? extends Payload>[] payload() default{ };
}