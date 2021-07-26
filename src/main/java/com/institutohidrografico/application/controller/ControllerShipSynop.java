package com.institutohidrografico.application.controller;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.institutohidrografico.application.persistence.dto.request.DTORequestFile;
import com.institutohidrografico.application.persistence.dto.request.DTORequestShipSynop;
import com.institutohidrografico.application.persistence.dto.response.DTOResponseShipSynop;
import com.institutohidrografico.application.persistence.model.File;
import com.institutohidrografico.application.persistence.model.ShipSynop;
import com.institutohidrografico.application.persistence.repository.RepositoryFile;
import com.institutohidrografico.application.persistence.repository.RepositoryShipSynop;
import com.institutohidrografico.application.service.ServiceFileStorage;
import com.institutohidrografico.application.service.ServiceFile;
import com.institutohidrografico.application.service.ServiceShipSynop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@RestController
@RequestMapping("/shipsynop")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerShipSynop {

    private final ServiceShipSynop service;
    private final ServiceFile serviceFile;
    @Autowired
    private ServiceFileStorage fileStorageService;

    public ControllerShipSynop(RepositoryShipSynop repository, RepositoryFile repositoryFile) {
        this.service = new ServiceShipSynop(repository) {};
        this.serviceFile = new ServiceFile(repositoryFile) {};
    }

    @PostMapping("") //@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity<DTOResponseShipSynop> create(@RequestBody @Valid DTORequestShipSynop created){
        try {
            return new ResponseEntity<>(service.create(created), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("")
    public ResponseEntity<Page<DTOResponseShipSynop>> retrieve(Pageable pageable){
        return new ResponseEntity<>(service.retrieve(pageable), HttpStatus.FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DTOResponseShipSynop> retrieve(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(service.retrieve(id), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/source")
    public ResponseEntity<Page<DTOResponseShipSynop>> retrieveSource(Pageable pageable, @RequestParam(required = false) String q){
        try {
            return new ResponseEntity<>(service.retrieveSource(pageable, q), HttpStatus.FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<DTOResponseShipSynop> update(@PathVariable("id") UUID id, @RequestBody @Valid DTORequestShipSynop updated){
        try {
            return new ResponseEntity<>(service.update(id, updated), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable UUID id){
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("")
    public ResponseEntity<HttpStatus> delete(){
        try {
            service.delete();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/upload")
    public File upload(@RequestParam (value="file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);
        interpret(fileName, file.getContentType(), file.getSize());
        return new File(fileName, file.getContentType(), file.getSize());
    }
    public void interpret(String fileName, String fileType, Long fileSize) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(df);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        try {
            List<DTORequestShipSynop> shipSynopWeb = mapper.readerForListOf(ShipSynop.class).readValue(new java.io.File("./uploads/" + fileName));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            DTORequestFile dtoRequestFile = new DTORequestFile(fileName, fileType, fileSize);
            serviceFile.create(dtoRequestFile);
            for( DTORequestShipSynop shipSynop : shipSynopWeb ) {
                List<DTOResponseShipSynop> busca = service.retrieveByEstacao(shipSynop.getEstacao());
                boolean controle = true;
                for (DTOResponseShipSynop ss2: busca) {
                    if (shipSynop.getDataObservacao() != null && ss2.getDataObservacao() != null){
                        if (simpleDateFormat.format(shipSynop.getDataObservacao()).equals(simpleDateFormat.format(ss2.getDataObservacao())) && shipSynop.getGg().equals(ss2.getGg())) {
                            controle = false;
                        }
                    }
                }
                if (controle){
                    shipSynop.setFile(dtoRequestFile.toObject());
                    service.create(shipSynop);
                }
            }
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}