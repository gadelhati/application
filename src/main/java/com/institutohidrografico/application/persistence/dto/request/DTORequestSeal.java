package com.institutohidrografico.application.persistence.dto.request;

import com.institutohidrografico.application.exception.annotation.UniqueSealNumber;
import com.institutohidrografico.application.persistence.model.support.Seal;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
public class DTORequestSeal {

    private UUID id;
    @NotNull(message = "{number.not.null}") @NotBlank(message = "{number.not.blank}") @UniqueSealNumber
    private String number;
    private String color;
    @NotNull
    private boolean broken;

    public Seal toObject(){
        return new Seal(id, number, color, broken);
    }
}