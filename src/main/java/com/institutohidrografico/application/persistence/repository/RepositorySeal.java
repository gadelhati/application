package com.institutohidrografico.application.persistence.repository;

import com.institutohidrografico.application.persistence.model.support.Seal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	marcelo.gadelha@marinha.mil.br
 * @link	www.gadelha.eti.br
 **/

@Repository
public interface RepositorySeal extends JpaRepository<Seal, UUID> {
    boolean existsByNumber(String number);
    List<Seal> findByBrokenFalse();
    List<Seal> findByNumberContainingIgnoreCaseOrderByNumberAsc(String number);
}