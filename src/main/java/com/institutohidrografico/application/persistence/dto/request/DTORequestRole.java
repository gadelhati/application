package com.institutohidrografico.application.persistence.dto.request;

import com.institutohidrografico.application.exception.annotation.UniqueRoleName;
import com.institutohidrografico.application.persistence.model.Role;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter
public class DTORequestRole {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueRoleName
    private String name;

    public Role toObject(){
        return new Role(name);
    }
}