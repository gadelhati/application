package com.institutohidrografico.application.persistence.dto.response;

import com.institutohidrografico.application.persistence.model.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponseRole {

    private String name;

    public static DTOResponseRole toDTO(Role role) {
        return new DTOResponseRole(role.getName());
    }
}