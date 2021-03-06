package com.institutohidrografico.application.persistence.model.ben10;

import com.institutohidrografico.application.persistence.model.Abiliity;
import com.institutohidrografico.application.persistence.model.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Entity @Table @Data @AllArgsConstructor @NoArgsConstructor
public class Alien extends GenericEntity {

    @Column //@UniqueTitleTutorial
    private String especie;
    @Column
    private String apelido;
    @Column
    private String corpo;
    @Column
    private boolean published;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "abiliity")
    private Abiliity abiliity;
}