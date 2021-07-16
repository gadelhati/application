package com.institutohidrografico.application.exception.validator;

import com.institutohidrografico.application.exception.annotation.ValidMiMiMjMj;
import com.institutohidrografico.application.service.ServiceRole;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public class ValidatorMiMiMjMj implements ConstraintValidator<ValidMiMiMjMj, String> {

    @Autowired
    private ServiceRole serviceRole;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value == "AAXX" || value == "BBXX";
    }
}