package com.institutohidrografico.application.persistence.model.akumanomi;

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
public class Akumanomi extends GenericEntity {

    @Column //@UniqueTitleTutorial
    private String especie;
    @Column
    private AkumanomiClasse classe;
    @Column
    private float preco;
    @Column
    private boolean artificial;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "abiliity")
    private Abiliity abiliity;
}