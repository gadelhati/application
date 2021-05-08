package com.institutohidrografico.application.service;

import com.institutohidrografico.application.service.GenericDAO;
import com.institutohidrografico.application.persistence.model.User;
import com.institutohidrografico.application.persistence.repository.RepositoryUser;
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

@Service
public class ServiceUser implements GenericDAO<User, UUID> {

    @Autowired
    private RepositoryUser repositoryUser;

    public User create(User objeto) {  return repositoryUser.save(objeto);}
    public List<User> retrieve() {
//        if (serviceUser.getCurrentUser().getUser().getNome().equalsIgnoreCase("User_ADMIN")) {
        return repositoryUser.findAll();
//        }else {
//            return repositorio.findByNomeNotContains("User_ADMIN");
//        }

    }
    public User update(User objeto) {   return repositoryUser.save(objeto);}
    public User retrieve(UUID id) {   return repositoryUser.getOne(id);}
    public void delete(UUID id) {  repositoryUser.deleteById(id);}
    public void deleteAll() {
        repositoryUser.deleteAll();
    }

    public List<User> nameContaining(String name) { return repositoryUser.findByNameContainingIgnoreCaseOrderByNameAsc(name); }
    public Optional<User> retrieveOptional(UUID id) { return repositoryUser.findById(id); }
    public Optional<User> retrieveOptionalByNome(String User) { return repositoryUser.findByName(User); }
    public boolean isNameValid(String value) {
        return repositoryUser.existsByName(value);
    }
}