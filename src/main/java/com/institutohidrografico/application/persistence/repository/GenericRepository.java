package com.institutohidrografico.application.persistence.repository;

import com.institutohidrografico.application.persistence.model.GenericInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	marcelo.gadelha@marinha.mil.br
 * @link	www.gadelha.eti.br
 **/

@NoRepositoryBean
public interface GenericRepository<T extends GenericInterface<T>> extends JpaRepository<T, UUID> {
}