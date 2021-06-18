package com.institutohidrografico.application.persistence.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@Entity //@AllArgsConstructor
public class Book /*extends GenericEntity*/ implements Serializable, GenericInterface<Book> {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @NotNull
    private String title;
    private String author;
    private String name;
    private Integer chapter;
    private Integer pages;
    @Lob
    private String description;
    private Date releaseDate;

    @Override
    public UUID retrieve(){
        return this.id;
    }

    @Override
    public Book update(Book source) {
        this.title = source.getTitle();
        this.author = source.getAuthor();
        this.description = source.getDescription();
        this.releaseDate = source.getReleaseDate();
        return source;
    }

    @Override
    public Book create() {
        Book newInstance = new Book();
        newInstance.update(this);
        return newInstance;
    }
}