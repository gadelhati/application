package com.institutohidrografico.application.persistence.model.fm.section;

import javax.persistence.Entity;

@Entity
public abstract class Section0 extends Section {
    //"Data for reporting identification (type, ship’s call sign/buoy identifier, date, time, location) and units of wind speed used."
    private String section0_MiMiMjMj;
    private String section0_DDDDDDD;
    private String section0_A1bwnbnbnb;
    private String section0_YYGGiw;
    private String section0_IIiii;
    private String section0_99LaLaLa;
    private String section0_QcLoLoLoLo;
    private String section0_MMMULaULo;
    private String section0_h0h0h0h0im;

    public Section0() {
        this.setSymbol("-");
    }
}