package com.institutohidrografico.application.exception.validator;

import com.institutohidrografico.application.exception.annotation.UniqueClasseName;
import com.institutohidrografico.application.service.ServiceClasse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public class UniqueClasseNameValidator implements ConstraintValidator<UniqueClasseName, String> {

    @Autowired
    private ServiceClasse serviceClasse;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !serviceClasse.isNameValid(value);
    }
}