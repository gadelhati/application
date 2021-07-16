package com.institutohidrografico.application.exception.validator;

import com.institutohidrografico.application.exception.annotation.ValidDDDDDD;
import com.institutohidrografico.application.service.ServiceRole;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public class ValidatorDDDDDD implements ConstraintValidator<ValidDDDDDD, String> {

    @Autowired
    private ServiceRole serviceRole;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !serviceRole.isNameValid(value);
    }
}