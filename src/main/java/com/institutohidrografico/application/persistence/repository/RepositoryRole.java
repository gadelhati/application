package com.institutohidrografico.application.persistence.repository;

import com.institutohidrografico.application.persistence.model.Role;
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
public interface RepositoryRole extends JpaRepository<Role, UUID> {
    //QUERIES PERSONALIZADAS
    Optional<Role> findByName(String name);
    boolean existsByName(String name);
    List<Role> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
}