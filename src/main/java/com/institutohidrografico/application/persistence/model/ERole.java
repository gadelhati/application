package com.institutohidrografico.application.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum ERole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private final String description;
}