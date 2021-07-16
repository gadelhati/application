package com.institutohidrografico.application.persistence.dto.request;

import com.institutohidrografico.application.exception.annotation.UniqueClasseName;
import com.institutohidrografico.application.persistence.model.Classe;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTORequestClasse {

    @NotNull(message = "{name.not.null}") @NotBlank(message = "{name.not.blank}") @UniqueClasseName
    private String name;
    private String name2;

    public Classe toObject(){
        return new Classe(name, name2);
    }
}