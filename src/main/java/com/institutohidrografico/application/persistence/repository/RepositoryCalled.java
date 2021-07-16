package com.institutohidrografico.application.persistence.repository;

import com.institutohidrografico.application.persistence.model.support.Called;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public interface RepositoryCalled extends JpaRepository<Called, UUID> {
    List<Called> findByNumberContainingIgnoreCaseOrderByNumberAsc(String name);
    boolean existsByNumber(String value);
}