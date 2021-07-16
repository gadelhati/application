package com.institutohidrografico.application.persistence.model.fm;

import com.institutohidrografico.application.persistence.model.GenericEntity;
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

@Audited @AuditTable(value = "audit_station")
@Entity @Table @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public abstract class Station extends GenericEntity {
//    https://www.ipma.pt/pt/enciclopedia/redes.observacao/meteo/index.jsp
//    https://mapas.inmet.gov.br/
//    https://www.agritempo.gov.br/agritempo/index.jsp
//    http://bancodedados.cptec.inpe.br/tabelaestacoes/faces/consulta.jsp
    private Country country; //flag
//    private State state;
//    private City city;
    private String name;
    private String wmo;
    private String icao;
    private double latitude;
    private double longitude;
    private double altitude;
    private Date since;
}