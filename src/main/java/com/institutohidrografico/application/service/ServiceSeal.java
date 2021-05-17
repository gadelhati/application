package com.institutohidrografico.application.service;

import com.institutohidrografico.application.persistence.dto.request.DTORequestSeal;
import com.institutohidrografico.application.persistence.dto.response.DTOResponseSeal;
import com.institutohidrografico.application.persistence.model.support.Seal;
import com.institutohidrografico.application.persistence.repository.RepositorySeal;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	marcelo.gadelha@marinha.mil.br
 * @link	www.gadelha.eti.br
 **/

@Service @AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServiceSeal implements GenericDAO<DTORequestSeal, DTOResponseSeal, UUID> {

    private final RepositorySeal repositorySeal;

    @Override
    public DTOResponseSeal create(DTORequestSeal value) {
        return DTOResponseSeal.toDTO(repositorySeal.save(value.toObject()));
    }
    @Override
    public List<DTOResponseSeal> retrieve() {
        List<DTOResponseSeal> list = new ArrayList<>();
        for(Seal seal:repositorySeal.findAll()) {
            list.add(DTOResponseSeal.toDTO(seal));
        }
        return list;
    }
    @Override
    public DTOResponseSeal retrieve(UUID id) {
        if(repositorySeal.existsById(id)) {
            return DTOResponseSeal.toDTO(repositorySeal.findById(id).get());
        } else {
            return null;
        }
    }
    @Override
    public DTOResponseSeal update(DTORequestSeal value) {
        if(repositorySeal.existsById(value.toObject().getId())) {
            return DTOResponseSeal.toDTO(repositorySeal.save(value.toObject()));
        } else {
            return null;
        }
    }
    @Override
    public void delete() {
        repositorySeal.deleteAll();
    }
    @Override
    public void delete(UUID id) {
        if(repositorySeal.existsById(id)) {
            repositorySeal.deleteById(id);
        }
    }

    public List<Seal> brokenFalse() { return repositorySeal.findByBrokenFalse(); }
    public boolean isNumberValid(String value) {
        return repositorySeal.existsByNumber(value);
    }
    public List<DTOResponseSeal> retrieveByNumber(String value) {
        List<DTOResponseSeal> list = new ArrayList<>();
        for(Seal seal:repositorySeal.findByNumberContainingIgnoreCaseOrderByNumberAsc(value)) {
            list.add(DTOResponseSeal.toDTO(seal));
        }
        return list;
    }
}