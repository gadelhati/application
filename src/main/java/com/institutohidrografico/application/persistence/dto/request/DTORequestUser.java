package com.institutohidrografico.application.persistence.dto.request;

import com.institutohidrografico.application.persistence.model.User;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class DTORequestUser {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String name;

    public User toObject(){
        return new User(name);
    }
}