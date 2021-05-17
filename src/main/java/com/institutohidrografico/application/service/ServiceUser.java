package com.institutohidrografico.application.service;

import com.institutohidrografico.application.persistence.dto.response.DTOResponseSeal;
import com.institutohidrografico.application.persistence.model.User;
import com.institutohidrografico.application.persistence.repository.RepositoryUser;
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
public class ServiceUser {

    private final RepositoryUser repositoryUser;

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
    public void delete() {
        repositoryUser.deleteAll();
    }

    public List<User> userNameContaining(String name) { return repositoryUser.findByUsernameContainingIgnoreCaseOrderByUsernameAsc(name); }
    public Optional<User> retrieveOptional(UUID id) { return repositoryUser.findById(id); }
    public Optional<User> retrieveOptionalByUserName(String User) { return repositoryUser.findByUsername(User); }
    public boolean isUserNameValid(String value) {
        return repositoryUser.existsByUsername(value);
    }
}