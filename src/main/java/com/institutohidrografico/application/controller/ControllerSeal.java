package com.institutohidrografico.application.controller;

import com.institutohidrografico.application.persistence.dto.request.DTORequestSeal;
import com.institutohidrografico.application.persistence.dto.response.DTOResponseSeal;
import com.institutohidrografico.application.persistence.model.support.Seal;
import com.institutohidrografico.application.service.ServiceSeal;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	marcelo.gadelha@marinha.mil.br
 * @link	www.gadelha.eti.br
 **/

@RestController
@RequestMapping(value= "/seal")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ControllerSeal {

    public final ServiceSeal serviceSeal;

    @PostMapping
    public ResponseEntity<DTOResponseSeal> create(@RequestBody @Valid DTORequestSeal dtoRequestSeal) {
        try {
            final Seal Seal = serviceSeal.create(dtoRequestSeal.toObject());
            return new ResponseEntity<>(DTOResponseSeal.toDTO(Seal), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping //@PreAuthorize("hasAnySeal('Seal_ADMIN')")
    public ResponseEntity<List<Seal>> retrieveAll(@RequestParam(required = false) String name) {
        try {
            final List<Seal> Seals = new ArrayList<>();
            if (name == null)
                serviceSeal.retrieve().forEach(Seals::add);
            else
                serviceSeal.numberContaining(name).forEach(Seals::add);
            if (Seals.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(Seals, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //    @GetMapping( value = "/seal/nome/{nome}" ) //@PreAuthorize("hasAnySeal('Seal_ADMIN')")
//    public ResponseEntity<Seal> retrieveByName(@PathVariable("nome") String Seal) {
//        Optional<Seal> objeto = service.retrieveOptionalByNome(Seal);
//        if (objeto.isPresent()) {
//            return new ResponseEntity<>(objeto.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @GetMapping("/{id}") //@PreAuthorize("hasAnySeal('ROLE_ADMIN')")
    public ResponseEntity<DTOResponseSeal> retrieve(@PathVariable("id") UUID id) {
        final Optional<Seal> Seal = serviceSeal.retrieveOptional(id);
        if (Seal.isPresent()) {
            return new ResponseEntity<>(DTOResponseSeal.toDTO(Seal.get()), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestSeal dtoRequestSeal) {
        Optional<Seal> busca = serviceSeal.retrieveOptional(id);
        if (busca.isPresent()) {
            busca = Optional.ofNullable(dtoRequestSeal.toObject());
            busca.get().setId(id);
            serviceSeal.create(busca.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") UUID id) {
        final Optional<Seal> tutorial = serviceSeal.retrieveOptional(id);
        if (tutorial.isPresent()) {
            serviceSeal.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAll() {
        try {
            serviceSeal.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}