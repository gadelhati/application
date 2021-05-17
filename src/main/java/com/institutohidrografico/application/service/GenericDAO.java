package com.institutohidrografico.application.service;

import com.institutohidrografico.application.persistence.dto.response.DTOResponseSeal;

import java.util.List;
import java.util.Optional;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @since	22/07/2019
 * @version	1.0
 * @link	www.gadelha.eti.br
 **/

public interface GenericDAO<Q,P,K> {
    public abstract P create(Q objeto);
    public abstract List<P> retrieve();
    public abstract P retrieve(K id);
//    public abstract Optional<P> retrieveOptional(K id);
    public abstract P update(Q objeto);
    public abstract void delete(K id);
    public abstract void delete();
}