package com.institutohidrografico.application.persistence.model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class PessoaFisica extends Pessoa {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Gender gender;
    @CPF
    private String cpf;
}
