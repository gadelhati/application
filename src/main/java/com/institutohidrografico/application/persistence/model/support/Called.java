package com.institutohidrografico.application.persistence.model.support;

import com.institutohidrografico.application.persistence.model.GenericEntity;
import com.institutohidrografico.application.persistence.model.GenericInterface;
import com.institutohidrografico.application.persistence.model.support.Seal;
import com.institutohidrografico.application.persistence.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	marcelo.gadelha@marinha.mil.br
 * @link	www.gadelha.eti.br
 **/

@Audited @AuditTable(value = "called_auditoria")
@Entity @Table @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class Called extends GenericEntity implements Serializable, GenericInterface<Called> {

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "entrance")
    private Seal entrance;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "exit")
    private Seal exit;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "deliveryman")
    private User deliveryman;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "receiver")
    private User receiver;
//    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime delivery;
//    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime receivement;
    @Column
    private String number;
    @Column
    private String host;

    @Override
    public Called create() {
        Called newInstance = new Called();
        newInstance.update(this);
        return newInstance;
    }
    @Override
    public UUID retrieve(){
        return this.getId();
    }
    @Override
    public Called update(Called source) {
        this.entrance = source.getEntrance();
        this.exit = source.getExit();
        this.deliveryman = source.getDeliveryman();
        this.receiver = source.getReceiver();
        this.delivery = source.getDelivery();
        this.receivement = source.getReceivement();
        this.number = source.getNumber();
        this.host = source.getHost();
        return source;
    }
}