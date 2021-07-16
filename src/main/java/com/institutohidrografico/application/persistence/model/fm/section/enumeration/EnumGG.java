package com.institutohidrografico.application.persistence.model.fm.section.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum EnumGG {
    //HMG - Hora Média de Greenwich
    _00("00"),
    _03("03"),
    _06("06"),
    _09("09"),
    _12("12"),
    _15("15"),
    _18("18"),
    _21("21");

    private final String GG;
}