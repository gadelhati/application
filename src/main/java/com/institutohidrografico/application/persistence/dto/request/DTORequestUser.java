package com.institutohidrografico.application.persistence.dto.request;

import com.institutohidrografico.application.persistence.model.User;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter
public class DTORequestUser {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}")
    private String username;
    @NotNull(message = "{password.not.null}") @NotBlank(message = "{password.not.blank}")
    private String password;

    public User toObject(){
        return new User(username, password);
    }
}