package com.institutohidrografico.application.support.called.controller;

import com.institutohidrografico.application.persistence.dto.request.DTORequestCalled;
import com.institutohidrografico.application.persistence.dto.response.DTOResponseCalled;
import com.institutohidrografico.application.persistence.model.support.Called;
import com.institutohidrografico.application.service.ServiceCalled;
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
@RequestMapping(value= "/called")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ControllerCalled {

    public final ServiceCalled serviceCalled;

    @PostMapping
    public ResponseEntity<DTOResponseCalled> create(@RequestBody @Valid DTORequestCalled dtoRequestCalled) {
        try {
            final Called called = serviceCalled.create(dtoRequestCalled.toObject());
            return new ResponseEntity<>(DTOResponseCalled.toDTO(called), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping //@PreAuthorize("hasAnyCalled('ROLE_ADMIN')")
    public ResponseEntity<List<Called>> retrieveAll(@RequestParam(required = false) String number) {
        try {
            final List<Called> calleds = new ArrayList<>();
            if (number == null)
                serviceCalled.retrieve().forEach(calleds::add);
            else
                serviceCalled.numberContaining(number).forEach(calleds::add);
            if (calleds.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(calleds, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //    @GetMapping( value = "/called/nome/{nome}" ) //@PreAuthorize("hasAnyCalled('ROLE_ADMIN')")
//    public ResponseEntity<Called> retrieveByName(@PathVariable("nome") String Called) {
//        Optional<Called> objeto = service.retrieveOptionalByNome(Called);
//        if (objeto.isPresent()) {
//            return new ResponseEntity<>(objeto.get(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @GetMapping("/{id}") //@PreAuthorize("hasAnyCalled('Called_ADMIN')")
    public ResponseEntity<DTOResponseCalled> retrieve(@PathVariable("id") UUID id) {
        final Optional<Called> called = serviceCalled.retrieveOptional(id);
        if (called.isPresent()) {
            return new ResponseEntity<>(DTOResponseCalled.toDTO(called.get()), HttpStatus.FOUND);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//    @PutMapping("/called/{id}")
//    public ResponseEntity<HttpStatus> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestCalled dtoRequestCalled) {
//        Optional<Called> busca = serviceCalled.retrieveOptional(id);
//        if (busca.isPresent()) {
//            busca = Optional.ofNullable(dtoRequestCalled.toObject());
//            busca.get().setId(id);
//            serviceCalled.create(busca.get());
//            return new ResponseEntity<>(HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") UUID id) {
        final Optional<Called> tutorial = serviceCalled.retrieveOptional(id);
        if (tutorial.isPresent()) {
            serviceCalled.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAll() {
        try {
            serviceCalled.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}