package com.institutohidrografico.application.controller;

import com.institutohidrografico.application.persistence.dto.request.DTORequestSeal;
import com.institutohidrografico.application.persistence.dto.response.DTOResponseSeal;
import com.institutohidrografico.application.service.ServiceSeal;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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
public class ControllerSeal implements ControllerGeneric<DTORequestSeal, DTOResponseSeal, UUID> {

    public final ServiceSeal serviceSeal;

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public DTOResponseSeal create(@RequestBody @Valid DTORequestSeal dtoRequestSeal) {
        return serviceSeal.create(dtoRequestSeal);
    }

    @GetMapping @ResponseStatus(HttpStatus.FOUND)
    public List<DTOResponseSeal> retrieve() {
        return serviceSeal.retrieve();
    }

    @GetMapping("/{id}") @ResponseStatus(HttpStatus.FOUND) //@PreAuthorize("hasAnySeal('ROLE_ADMIN')")
    public DTOResponseSeal retrieve(@PathVariable("id") UUID id) {
        return serviceSeal.retrieve(id);
    }

    @GetMapping("/name/{name}") @ResponseStatus(HttpStatus.FOUND)
    public List<DTOResponseSeal> retrieveByName(@PathVariable("name") String name) {
        return serviceSeal.retrieveByNumber(name);
    }

    @PutMapping("/{id}") @ResponseStatus(HttpStatus.OK)
    public DTOResponseSeal update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestSeal dtoRequestSeal) {
        return serviceSeal.update(dtoRequestSeal);
    }

    @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id) {
        serviceSeal.delete(id);
    }

    @DeleteMapping @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete() {
        serviceSeal.delete();
    }
}