package com.institutohidrografico.application.persistence.model.fm.section;

import javax.persistence.Entity;

@Entity
public abstract class Section4 extends Section {
    //Data for national use for clouds with base below station level, included by national decision
    private String section4_NCHHCt;

    public Section4() {
        this.setSymbol("444");
    }
}