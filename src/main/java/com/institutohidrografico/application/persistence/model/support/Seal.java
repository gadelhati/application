package com.institutohidrografico.application.persistence.model.support;

import com.institutohidrografico.application.persistence.model.GenericEntity;
import com.institutohidrografico.application.persistence.model.GenericInterface;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	marcelo.gadelha@marinha.mil.br
 * @link	www.gadelha.eti.br
 **/

@Audited @AuditTable(value = "seal_auditoria")
@Entity @Table @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class Seal /*extends GenericEntity*/ implements Serializable, GenericInterface<Seal> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column
    private String number;
    @Column
    private String color;
    @Column
    private boolean broken;

    @Override
    public UUID retrieve(){
        return this.id;
    }

    @Override
    public Seal update(Seal source) {
        this.number = source.getNumber();
        this.color = source.getColor();
        this.broken = source.isBroken();
        return source;
    }

    @Override
    public Seal create() {
        Seal newInstance = new Seal();
        newInstance.update(this);
        return newInstance;
    }
}