package com.institutohidrografico.application.persistence.model.fm.section.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum EnumVesselType {
    CARGA("cargo"),
    TANKERS("tankers"),
    PASSAGER_VESSEL("passager vessel"),
    HIGH_SPEED_CRAFT("high speed craft"),
    TUGS_SPECIAL_CRAFT("tugs & special craft"),
    FISHING("fishing"),
    PLEASURE_CRAFT("pleasure craft"),
    NAVIGATION_AIDS("navigation aids"),
    UNSPECIFIED("unspecified ship");

    private final String type;
}