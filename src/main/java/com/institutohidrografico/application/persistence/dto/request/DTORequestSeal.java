package com.institutohidrografico.application.persistence.dto.request;

import com.institutohidrografico.application.exception.annotation.UniqueSealNumber;
import com.institutohidrografico.application.persistence.model.support.Seal;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	marcelo.gadelha@marinha.mil.br
 * @link	www.gadelha.eti.br
 **/

@Getter
public class DTORequestSeal {

    @NotNull(message = "{number.not.null}") @NotBlank(message = "{number.not.blank}") @UniqueSealNumber
    private String number;
    private String color;
    @NotNull
    private boolean broken;

    public Seal toObject(){
        return new Seal(number, color, broken);
    }
}