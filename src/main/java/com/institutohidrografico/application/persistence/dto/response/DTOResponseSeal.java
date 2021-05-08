package com.institutohidrografico.application.persistence.dto.response;

import com.institutohidrografico.application.persistence.model.support.Seal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DTOResponseSeal {

    private String number;

    public static DTOResponseSeal toDTO(Seal seal) {
        return new DTOResponseSeal(seal.getNumber());
    }
}