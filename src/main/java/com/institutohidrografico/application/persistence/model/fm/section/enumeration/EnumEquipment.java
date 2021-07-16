package com.institutohidrografico.application.persistence.model.fm.section.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum EnumEquipment {
    ANEMOGRAFO("Anemógrafo"),
    ANEMOMETRO("Anemômetro"),
    BAROGRAFO("Barógrafo"),
    BAROMETRO("Barômetro"),
    CATAVENTO("Catavento"),
    EVAPORIMETRO_DE_PINCHE("Evaporímetro de Piche"),
    HELIOGRAFO("Heliógrafo"),
    HIDROGRAFO("Hidrógrafo"),
    PLUVIOGRAFO("Pluviógrafo"),
    PLUVIOMETRO("Pluviômetro"),
    PSICROMETRO("Psicrômetro"),
    TERMOGRAFO("Termógrafo"),
    TERMOHIGROGRAFO("Termohigrógrafo"),
    TERMOMETRO_DE_MAXIMA("Termômetro_de_máxima"),
    TERMOMETRO_DE_MINIMA("Termômetro de mínima"),
    TERMOMETRO_DE_SOLO("Termômetros de solo");

    private final String name;
}
