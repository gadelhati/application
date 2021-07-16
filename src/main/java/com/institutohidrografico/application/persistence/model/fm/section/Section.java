package com.institutohidrografico.application.persistence.model.fm.section;

import com.institutohidrografico.application.persistence.model.GenericEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public abstract class Section extends GenericEntity {
    private String symbol;
}