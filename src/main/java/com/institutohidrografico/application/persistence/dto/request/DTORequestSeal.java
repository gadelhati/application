package com.institutohidrografico.application.persistence.dto.request;

import com.institutohidrografico.application.persistence.model.support.Seal;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestSeal {

    @NotNull(message = "{number.not.null}") @NotBlank(message = "{number.not.blank}")
    private String number;

    public Seal toObject(){
        return new Seal(number);
    }
}