package com.institutohidrografico.application.controller;

import com.institutohidrografico.application.persistence.model.support.Seal;
import com.institutohidrografico.application.persistence.repository.SealRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seal2")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SealController extends GenericController<Seal> {

    public SealController(SealRepository sealRepository) {
        super(sealRepository);
    }
}