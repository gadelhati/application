package com.institutohidrografico.application.persistence.model.fm.section;

import javax.persistence.Entity;

@Entity
public abstract class Section2 extends Section {
    //Maritime data for global exchange pertaining to a sea, or to a coastal station
    private String section2_222Dsvs;
    private String section2_0ssTwTwTw;
    private String section2_1PwaPwaHwaHwa;
    private String section2_2PwPwHwHw;
    private String section2_3dw1dw1dw2dw2;
    private String section2_4Pw1Pw1Hw1Hw1;
    private String section2_5Pw2Pw2Hw2Hw2;
    private String section2_6IsEsEsRs;
    private String section2_ICING;
    private String section2_70HwaHwaHwa;
    private String section2_8swTbTbTb;
    private String section2_ciSibiDizi;

    public Section2() {
        this.setSymbol("222");
    }
}