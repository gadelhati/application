package com.institutohidrografico.application.persistence.model.fm.section.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum EnumSurfaceStationType {
    ECP("Estação Climatológica Principal"),
    ECA("Estação Climatológica Auxiliar "),
    AT(" Estação Meteorológica Automática(AT) ou Plataforma de Coleta de Dados"),
    HIGH_SPEED_CRAFT("high speed craft"),
    TUGS_SPECIAL_CRAFT("tugs & special craft"),
    FISHING("fishing"),
    PLEASURE_CRAFT("pleasure craft"),
    NAVIGATION_AIDS("navigation aids"),
    UNSPECIFIED("unspecified ship");

    private final String type;
}