package com.institutohidrografico.application.persistence.dto.request;

import com.institutohidrografico.application.exception.annotation.UniqueTitleTutorial;
import com.institutohidrografico.application.persistence.model.Tutorial;
import lombok.Getter;

import javax.persistence.Column;

@Getter
public class DTORequestTutorial {

    @Column @UniqueTitleTutorial
    private String title;
    @Column
    private String description;
    @Column
    private boolean published;
//    @Column
//    private Audit audit;

    public Tutorial toObject(){
        return new Tutorial(title, description, published);
    }
}