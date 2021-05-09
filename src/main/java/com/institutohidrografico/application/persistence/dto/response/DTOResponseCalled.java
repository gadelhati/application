package com.institutohidrografico.application.persistence.dto.response;

import com.institutohidrografico.application.persistence.model.support.Called;
import com.institutohidrografico.application.persistence.model.support.Seal;
import com.institutohidrografico.application.persistence.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter @AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DTOResponseCalled {

    private Seal entrance;
    private Seal exit;
    private User deliveryman;
    private User receiver;
    private LocalDateTime delivery;
    private LocalDateTime receivement;
    private String number;
    private String host;

    public static DTOResponseCalled toDTO(Called called) {
        return new DTOResponseCalled(called.getEntrance(), called.getExit(), called.getDeliveryman(), called.getReceiver(), called.getDelivery(), called.getReceivement(), called.getNumber(), called.getHost());
    }
}