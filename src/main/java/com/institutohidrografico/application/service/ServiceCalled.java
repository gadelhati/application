package com.institutohidrografico.application.service;

import com.institutohidrografico.application.persistence.dto.response.DTOResponseSeal;
import com.institutohidrografico.application.persistence.model.support.Called;
import com.institutohidrografico.application.persistence.repository.RepositoryCalled;
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
public class ServiceCalled {

    private final RepositoryCalled repositoryCalled;

    public Called create(Called objeto) {  return repositoryCalled.save(objeto);}
    public List<Called> retrieve() {
//        if (serviceUser.getCurrentUser().getService().getNome().equalsIgnoreCase("Service_ADMIN")) {
        return repositoryCalled.findAll();
//        }else {
//            return repositorio.findByNomeNotContains("Service_ADMIN");
//        }

    }
    public Called update(Called objeto) {   return repositoryCalled.save(objeto);}
    public Called retrieve(UUID id) {   return repositoryCalled.getOne(id);}
    public void delete(UUID id) {  repositoryCalled.deleteById(id);}
    public void delete() {
        repositoryCalled.deleteAll();
    }

    public List<Called> numberContaining(String name) { return repositoryCalled.findByNumberContainingIgnoreCaseOrderByNumberAsc(name); }
    public Optional<Called> retrieveOptional(UUID id) { return repositoryCalled.findById(id); }
    public Optional<Called> retrieveOptionalByNumber(String number) { return repositoryCalled.findByNumber(number); }
    public boolean isNameValid(String value) {
        return repositoryCalled.existsByNumber(value);
    }
}