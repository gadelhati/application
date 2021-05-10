package com.institutohidrografico.application.service;

import com.institutohidrografico.application.service.GenericDAO;
import com.institutohidrografico.application.persistence.model.support.Seal;
import com.institutohidrografico.application.persistence.repository.RepositorySeal;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	marcelo.gadelha@marinha.mil.br
 * @link	www.gadelha.eti.br
 **/

@Service @AllArgsConstructor(onConstructor = @__(@Autowired))
public class ServiceSeal implements GenericDAO<Seal, UUID> {

    private final RepositorySeal repositorySeal;

    public Seal create(Seal objeto) {  return repositorySeal.save(objeto);}
    public List<Seal> retrieve() {
//        if (serviceUser.getCurrentUser().getSeal().getNome().equalsIgnoreCase("Seal_ADMIN")) {
        return repositorySeal.findAll();
//        }else {
//            return repositorio.findByNomeNotContains("Seal_ADMIN");
//        }

    }
    public Seal update(Seal objeto) {   return repositorySeal.save(objeto);}
    public Seal retrieve(UUID id) {   return repositorySeal.getOne(id);}
    public void delete(UUID id) {  repositorySeal.deleteById(id);}
    public void deleteAll() {
        repositorySeal.deleteAll();
    }

    public List<Seal> numberContaining(String name) { return repositorySeal.findByNumberContainingIgnoreCaseOrderByNumberAsc(name); }
    public Optional<Seal> retrieveOptional(UUID id) { return repositorySeal.findById(id); }
    public Optional<Seal> retrieveOptionalByNumber(String Seal) { return repositorySeal.findByNumber(Seal); }
    public boolean isNumberValid(String value) {
        return repositorySeal.existsByNumber(value);
    }
    public List<Seal> brokenFalse() { return repositorySeal.findByBrokenFalse(); }
}