package com.institutohidrografico.application.controller;

import com.institutohidrografico.application.persistence.model.support.Called;
import com.institutohidrografico.application.persistence.repository.CalledRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/called2")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CalledController extends GenericController<Called> {

    public CalledController(CalledRepository calledRepository) {
        super(calledRepository);
    }
}