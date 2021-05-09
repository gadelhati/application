package com.institutohidrografico.application.controller;

import com.institutohidrografico.application.persistence.dto.request.DTORequestCalled;
import com.institutohidrografico.application.persistence.model.support.Called;
import com.institutohidrografico.application.service.ServiceCalled;
import com.institutohidrografico.application.service.ServiceSeal;
import com.institutohidrografico.application.service.ServiceUser;
import lombok.AllArgsConstructor;
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
@RequestMapping(value= "/calledMV")
@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ControllerCalledThymeleaf {

    private final ServiceCalled serviceCalled;
    private final ServiceUser serviceUser;
    private final ServiceSeal serviceSeal;

    @PostMapping
    public ModelAndView create(@Valid Called Called, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return add(Called);
        }
        serviceCalled.create(Called);
        return findAll();
    }
    @PostMapping("/createDTO")
    public ModelAndView create(@Valid DTORequestCalled Called, BindingResult bindingResult) {
        Called Called1 = serviceCalled.create(Called.toObject());
        if(bindingResult.hasErrors()) {
            return add(Called1);
        }
        return findAll();
    }
    @GetMapping
    public ModelAndView findAll() {
        return new ModelAndView("called").addObject("calleds", serviceCalled.retrieve());
    }
    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") UUID id) {
        return add(serviceCalled.retrieve(id));
    }
    @GetMapping("/add")
    public ModelAndView add(Called called) {
        ModelAndView modelAndView = new ModelAndView("/calledADD");
        modelAndView.addObject("called", called);
        modelAndView.addObject("entrances", serviceSeal.brokenFalse());
        modelAndView.addObject("exits", serviceSeal.brokenFalse());
        modelAndView.addObject("deliverymans", serviceUser.retrieve());
        modelAndView.addObject("receivers", serviceUser.retrieve());
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") @NotBlank UUID id) {
        if(serviceCalled.retrieve(id) != null) {
            serviceCalled.delete(id);
        }
        return findAll();
    }
}