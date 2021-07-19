package com.institutohidrografico.application.persistence.model.fm;

import com.institutohidrografico.application.persistence.model.fm.section.enumeration.EnumVesselType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Audited @AuditTable(value = "audit_organization")
@Entity @Table @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public abstract class Organization extends Station {
    private Organization subordination;
    private String imo;
    private String navalCallsign;
    private String visualCallsign;
    private String telegraphicCallsign;
    private double latitude;
    private double longitude;
    private EnumVesselType type;
    private Date since;
}