package com.institutohidrografico.application.service;

import com.institutohidrografico.application.persistence.dto.request.DTORequestRole;
import com.institutohidrografico.application.persistence.dto.response.DTOResponseRole;
import com.institutohidrografico.application.persistence.model.Role;
import com.institutohidrografico.application.persistence.repository.RepositoryRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Service
public class ServiceRole {

    private final RepositoryRole repository;

    public ServiceRole(RepositoryRole repository) {
        this.repository = repository;
    }

    public DTOResponseRole create(DTORequestRole created){
//        Role role = MAPPER_ROLE.toObject(created);
        return DTOResponseRole.toDTO(repository.save(created.toObject()));
    }
    public Page<DTOResponseRole> retrieve(Pageable pageable){
        List<DTOResponseRole> list = new ArrayList<>();
        for(Role role: repository.findAll()) {
            list.add(DTOResponseRole.toDTO(role));
        }
        return new PageImpl<DTOResponseRole>(list, pageable, list.size());
    }
    public DTOResponseRole retrieve(UUID id){
        return DTOResponseRole.toDTO(repository.findById(id).get());
    }
    public Page<DTOResponseRole> retrieveSource(Pageable pageable, String source){
        final List<DTOResponseRole> list = new ArrayList<>();
        if (source == null) {
            for (Role role : repository.findAll()) {
                list.add(DTOResponseRole.toDTO(role));
            }
        } else {
            for (Role role : repository.findByNameContainingIgnoreCaseOrderByNameAsc(source)) {
                list.add(DTOResponseRole.toDTO(role));
            }
        }
        return new PageImpl<DTOResponseRole>(list, pageable, list.size());
    }
    public DTOResponseRole update(UUID id, DTORequestRole updated){
        Role role = repository.findById(id).get();
        role.setName(updated.getName());
        return DTOResponseRole.toDTO(repository.save(role));
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
    public void delete() {
        repository.deleteAll();
    };

    public boolean isNameValid(String value) {
        return repository.existsByName(value);
    }
}