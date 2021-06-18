package com.institutohidrografico.application.persistence.model;

import java.util.List;
import java.util.UUID;

public interface GenericInterface<T> {

    public abstract T create();
//    public abstract List<T> retrieve();
    public abstract UUID retrieve();
    public abstract T update(T source);
//    public abstract void delete(T source);
//    public abstract void delete();
}