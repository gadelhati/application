package com.institutohidrografico.application.persistence.model.fm.section.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum Enumiw {
    _0("0 - intensidade estimada em m/s"),
    _1("1 - intensidade medida por anemômetro em m/s"),
    _3("3 - intensidade estimada em nós"),
    _4("4 - intensidade medida por anemômetro em nós");

    private final String iw;
}