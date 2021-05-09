package com.institutohidrografico.application.exception.validator;

import com.institutohidrografico.application.exception.annotation.UniqueSealNumber;
import com.institutohidrografico.application.service.ServiceSeal;
import com.institutohidrografico.application.service.ServiceTutorial;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueSealNumberValidator implements ConstraintValidator<UniqueSealNumber, String> {

    @Autowired
    private ServiceSeal serviceSeal;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !serviceSeal.isNumberValid(value);
    }
}