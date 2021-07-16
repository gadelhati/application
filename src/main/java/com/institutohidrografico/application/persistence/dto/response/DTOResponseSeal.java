package com.institutohidrografico.application.persistence.dto.response;

import com.institutohidrografico.application.persistence.model.support.Seal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponseSeal {

    private String number;
    private String color;
    private boolean broken;

    public static DTOResponseSeal toDTO(Seal seal) {
        return new DTOResponseSeal(seal.getNumber(), seal.getColor(), seal.isBroken());
    }
}