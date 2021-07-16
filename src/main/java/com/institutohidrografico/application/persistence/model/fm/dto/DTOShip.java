package com.institutohidrografico.application.persistence.model.fm.dto;

import com.institutohidrografico.application.exception.annotation.Section0Valid;
import com.institutohidrografico.application.persistence.model.fm.Ship;
import com.institutohidrografico.application.persistence.model.fm.section.Section0;
import com.institutohidrografico.application.persistence.model.fm.section.Section1;
import com.institutohidrografico.application.persistence.model.fm.section.Section2;
import com.institutohidrografico.application.persistence.model.fm.section.Section3;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DTOShip {
//    @NotNull(message = "{number.not.null}") @NotBlank(message = "{number.not.blank}") @UniqueSealNumber
    private Section0 section0;
    @Section0Valid
    private Section1 section1;
    private Section2 section2;
    private Section3 section3;

    public Ship toObject(){
        return new Ship(section0, section1, section2, section3);
    }
    public static DTOShip toDTO(Ship ship) {
        return new DTOShip(ship.getSection0(), ship.getSection1(), ship.getSection2(), ship.getSection3());
    }
}