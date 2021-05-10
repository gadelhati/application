package com.institutohidrografico.application.persistence.model;

import javax.persistence.Column;
import java.util.Date;

public abstract class Pessoa extends GenericEntity {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date birthdate;
}
