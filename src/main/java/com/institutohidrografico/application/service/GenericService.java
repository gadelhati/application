package com.institutohidrografico.application.service;

import com.institutohidrografico.application.persistence.model.GenericInterface;
import com.institutohidrografico.application.persistence.repository.GenericRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

public abstract class GenericService<T extends GenericInterface<T>> {

    private final GenericRepository<T> repository;

    public GenericService(GenericRepository<T> repository) {
        this.repository = repository;
    }

    public Page<T> getPage(Pageable pageable){
        return repository.findAll(pageable);
    }

    public T get(UUID id){
//        Optional<T> optional = repository.findById(id);
//        if(optional.isPresent()) {
//            return optional.get();
//        } else {
//            return null;
//        }
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("?"));
    }

    @Transactional
    public T update(T updated){
        T dbDomain = get(updated.retrieve());
        dbDomain.update(updated);
        return repository.save(dbDomain);
    }

    @Transactional
    public T create(T newDomain){
        T dbDomain = newDomain.create();
        return repository.save(dbDomain);
    }

    @Transactional
    public void delete(UUID id){
        get(id);
        repository.deleteById(id);
    }

    @Transactional
    public void delete() {
        repository.deleteAll();
    };
}