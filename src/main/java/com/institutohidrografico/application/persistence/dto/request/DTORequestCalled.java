package com.institutohidrografico.application.persistence.dto.request;

import com.institutohidrografico.application.persistence.model.User;
import com.institutohidrografico.application.persistence.model.support.Seal;
import com.institutohidrografico.application.persistence.model.support.Called;
import lombok.Getter;

import java.util.Date;

@Getter
public class DTORequestCalled {

    private Seal entrance;
    private Seal exit;
    private User deliveryman;
    private User receiver;
    private Date delivery;
    private Date receivement;
    private String number;
    private String host;

    public Called toObject(){
        return new Called(entrance, exit, deliveryman, receiver, delivery, receivement, number, host);
    }
}