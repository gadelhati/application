package com.institutohidrografico.application.persistence.dto.response;

import com.institutohidrografico.application.persistence.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DTOResponseUser {

    private String username;
    private String password;

    public static DTOResponseUser toDTO(User user) {
        return new DTOResponseUser(user.getUsername(), user.getPassword());
    }
}