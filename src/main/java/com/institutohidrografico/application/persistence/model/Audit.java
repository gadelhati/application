package com.institutohidrografico.application.persistence.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Embeddable;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import java.time.LocalDateTime;

@Data
@Embeddable
public class Audit {
//    @CreatedBy @LastModifiedBy
//    private User user;
    @CreationTimestamp
    private LocalDateTime createAt;
    @UpdateTimestamp
    private LocalDateTime updateAt;
    @PrePersist
    public void preCreate() { createAt = LocalDateTime.now();}
    @PostUpdate
    public void postUpdate() { updateAt = LocalDateTime.now();}
    @PreRemove
    public void preRemove() { }
}