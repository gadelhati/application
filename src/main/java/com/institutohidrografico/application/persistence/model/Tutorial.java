package com.institutohidrografico.application.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @since	19/06/2020
 * @version 1.0
 * @link	www.gadelha.eti.br
 **/

@Audited @AuditTable(value = "tutorial_auditoria")
@Entity @Table @Data @AllArgsConstructor @NoArgsConstructor
public class Tutorial extends GenericEntity {

    @Column
    private String title;
    @Column
    private String description;
    @Column
    private boolean published;
}