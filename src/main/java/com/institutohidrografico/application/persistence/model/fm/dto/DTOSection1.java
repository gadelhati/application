package com.institutohidrografico.application.persistence.model.fm.dto;

import javax.validation.constraints.Pattern;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

public class DTOSection1 {
    //iRixhVV
    @Pattern(regexp = "1|3|4", message = "{iR.not.valid}")
    private String section0_iR;
    @Pattern(regexp = "[1-7]", message = "{ix.not.valid}")
    private String section0_ix;
    @Pattern(regexp = "[0-9]|\\/", message = "{.not.valid}")
    private String section0_h;
    @Pattern(regexp = "9[0-9]", message = "{.not.valid}")
    private String section0_VV;
    //Nddff ou 00fff
    @Pattern(regexp = "[0-9]|\\/", message = "{N.not.valid}")
    private String section0_N;
    @Pattern(regexp = "[0-2][0-9]|3[0-6]|99", message = "{dd.not.valid}")
    private String section0_dd;
    @Pattern(regexp = "[0-9][0-9]", message = "{ff.not.valid}")
    private String section0_ff;
    @Pattern(regexp = "[1-9][0-9][0-9]", message = "{fff.not.valid}")
    private String section0_fff;
    //1snTTT
    @Pattern(regexp = "[0-1]", message = "{1sn.not.valid}")
    private String section0_1sn;
    @Pattern(regexp = "[[0-4][0-9][0-9]|500]", message = "{TTT.not.valid}")
    private String section0_TTT;
    //2snTdTdTd ou 29UUU
    @Pattern(regexp = "0|1|9", message = "{2sn.not.valid}")
    private String section0_2sn;
    @Pattern(regexp = "[0-4][0-9][0-9]|500", message = "{TdTdTd.not.valid}")
    private String section0_TdTdTd;



    @Pattern(regexp = "", message = "{.not.valid}")
    private String section0_;
}