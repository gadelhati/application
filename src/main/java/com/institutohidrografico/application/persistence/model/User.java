package com.institutohidrografico.application.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Audited @AuditTable(value = "user_auditoria")
@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class User extends GenericEntity {
    private String username;
    private String password;
}
