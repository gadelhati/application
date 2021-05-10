package com.institutohidrografico.application.persistence.model;

import org.hibernate.validator.constraints.br.CNPJ;

public class PessoaJuridica extends Pessoa {
    @CNPJ
    private String cnpj;
}
