package com.institutohidrografico.application.user.persistence.dto.response;

import com.institutohidrografico.application.persistence.model.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DTOResponseUser {

    private String name;

    public static DTOResponseUser toDTO(User User) {
        return new DTOResponseUser(User.getName());
    }
}