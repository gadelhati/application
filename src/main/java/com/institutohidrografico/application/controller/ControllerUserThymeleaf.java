package com.institutohidrografico.application.controller;

import com.institutohidrografico.application.persistence.dto.request.DTORequestUser;
import com.institutohidrografico.application.persistence.model.User;
import com.institutohidrografico.application.service.ServiceUser;
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
@RequestMapping(value= "/userMV")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ControllerUserThymeleaf {

    private final ServiceUser serviceUser;

    @Autowired
    public ControllerUserThymeleaf(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @PostMapping
    public ModelAndView create(@Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return add(user);
        }
        serviceUser.create(user);
        return findAll();
    }
    @PostMapping("/createDTO")
    public ModelAndView create(@Valid DTORequestUser user, BindingResult bindingResult) {
        User user1 = serviceUser.create(user.toObject());
        if(bindingResult.hasErrors()) {
            return add(user1);
        }
        return findAll();
    }
    @GetMapping
    public ModelAndView findAll() {
        return new ModelAndView("user").addObject("users", serviceUser.retrieve());
    }
    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") UUID id) {
        return add(serviceUser.retrieve(id));
    }
    @GetMapping("/add")
    public ModelAndView add(User user) {
        return new ModelAndView("userADD").addObject("user", user);
    }
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") @NotBlank UUID id) {
        if(serviceUser.retrieve(id) != null) {
            serviceUser.delete(id);
        }
        return findAll();
    }
}