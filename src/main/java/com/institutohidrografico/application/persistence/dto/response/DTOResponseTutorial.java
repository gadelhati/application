package com.institutohidrografico.application.persistence.dto.response;

import com.institutohidrografico.application.persistence.model.Audit;
import com.institutohidrografico.application.persistence.model.Tutorial;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DTOResponseTutorial {

    private String title;
    private String description;
    private boolean published;

    public static DTOResponseTutorial toDTO(Tutorial title) {
        return new DTOResponseTutorial(title.getTitle(), title.getDescription(), title.isPublished());
    }
}