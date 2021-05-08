package com.institutohidrografico.application.persistence.repository;

import com.institutohidrografico.application.persistence.model.support.Called;
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
public interface RepositoryCalled extends JpaRepository<Called, UUID> {
    //QUERIES PERSONALIZADAS
    Optional<Called> findByNumber(String number);
    boolean existsByNumber(String number);
    List<Called> findByNumberContainingIgnoreCaseOrderByNumberAsc(String name);
}