package com.institutohidrografico.application.controller;

import com.institutohidrografico.application.persistence.dto.request.DTORequestSeal;
import com.institutohidrografico.application.persistence.model.support.Seal;
import com.institutohidrografico.application.service.ServiceSeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @since	18/06/2020
 * @version	3.0
 * @link	www.gadelha.eti.br
 **/

@RestController
@RequestMapping(value= "/sealMV")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerSealThymeleaf {

    private final ServiceSeal serviceSeal;

    @Autowired
    public ControllerSealThymeleaf(ServiceSeal serviceSeal) {
        this.serviceSeal = serviceSeal;
    }

    @PostMapping
    public ModelAndView create(@Valid Seal seal, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return add(seal);
        }
        serviceSeal.create(seal);
        return findAll();
    }
    @PostMapping("/createDTO")
    public ModelAndView create(@Valid DTORequestSeal seal, BindingResult bindingResult) {
        Seal seal1 = serviceSeal.create(seal.toObject());
        if(bindingResult.hasErrors()) {
            return add(seal1);
        }
        return findAll();
    }
    @GetMapping
    public ModelAndView findAll() {
        return new ModelAndView("seal").addObject("seals", serviceSeal.retrieve());
    }
    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") UUID id) {
        return add(serviceSeal.retrieve(id));
    }
    @GetMapping("/add")
    public ModelAndView add(Seal seal) {
        return new ModelAndView("sealADD").addObject("seal", seal);
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") @NotBlank UUID id) {
        if(serviceSeal.retrieve(id) != null) {
            serviceSeal.delete(id);
        }
        return findAll();
    }
}