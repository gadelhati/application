package com.institutohidrografico.application.persistence.dto.response;

import com.institutohidrografico.application.persistence.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public class DTOResponseUser {

    private String username;
    private String password;

    public static DTOResponseUser toDTO(User user) {
        return new DTOResponseUser(user.getUsername(), user.getPassword());
    }
}