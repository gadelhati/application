package com.institutohidrografico.application.persistence.dto.request;

import com.institutohidrografico.application.persistence.model.User;
import com.institutohidrografico.application.persistence.model.support.Called;
import com.institutohidrografico.application.persistence.model.support.Seal;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter
public class DTORequestCalled {

    private Seal entrance;
    private Seal exit;
    private User deliveryman;
    private User receiver;
    private LocalDateTime delivery;
    private LocalDateTime receivement;
    private String number;
    private String host;

    public Called toObject(){
        return new Called(entrance, exit, deliveryman, receiver, delivery, receivement, number, host);
    }
}