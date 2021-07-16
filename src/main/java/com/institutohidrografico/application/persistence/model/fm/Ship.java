package com.institutohidrografico.application.persistence.model.fm;

import com.institutohidrografico.application.persistence.model.GenericEntity;
import com.institutohidrografico.application.persistence.model.fm.section.Section0;
import com.institutohidrografico.application.persistence.model.fm.section.Section1;
import com.institutohidrografico.application.persistence.model.fm.section.Section2;
import com.institutohidrografico.application.persistence.model.fm.section.Section3;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

//@Audited @AuditTable(value = "audit_ship")
@Entity @Table @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class Ship extends GenericEntity {
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "section0")
    private Section0 section0;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "section1")
    private Section1 section1;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "section2")
    private Section2 section2;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "section3")
    private Section3 section3;
}