package com.institutohidrografico.application.persistence.repository;

import com.institutohidrografico.application.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	marcelo.gadelha@marinha.mil.br
 * @link	www.gadelha.eti.br
 **/

@Repository
public interface RepositoryUser extends JpaRepository<User, UUID> {
    //QUERIES PERSONALIZADAS
    Optional<User> findByUsername(String name);
    boolean existsByUsername(String name);
    List<User> findByUsernameContainingIgnoreCaseOrderByUsernameAsc(String name);
}