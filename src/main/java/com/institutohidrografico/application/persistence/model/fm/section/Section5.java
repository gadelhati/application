package com.institutohidrografico.application.persistence.model.fm.section;

import javax.persistence.Entity;

@Entity
public abstract class Section5 extends Section {
    //Data for national use
    //Groups to be developed nationally

    public Section5() {
        this.setSymbol("555");
    }
}