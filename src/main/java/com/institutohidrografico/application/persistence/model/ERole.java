package com.institutohidrografico.application.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter @AllArgsConstructor
public enum ERole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private final String description;
}