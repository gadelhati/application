package com.institutohidrografico.application.persistence.dto.response;

import com.institutohidrografico.application.persistence.model.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DTOResponseRole {

    private String name;

    public static DTOResponseRole toDTO(Role role) {
        return new DTOResponseRole(role.getName());
    }
}