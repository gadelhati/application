package com.institutohidrografico.application.persistence.model.fm.dto;

import com.institutohidrografico.application.exception.annotation.ValidDDDDDD;
import com.institutohidrografico.application.exception.annotation.ValidMiMiMjMj;
import com.institutohidrografico.application.persistence.model.fm.Synop;
import com.institutohidrografico.application.persistence.model.fm.section.Section0;
import com.institutohidrografico.application.persistence.model.fm.section.Section1;
import com.institutohidrografico.application.persistence.model.fm.section.Section2;
import com.institutohidrografico.application.persistence.model.fm.section.Section3;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DTOSynop {
    //Section0
    @NotNull @ValidMiMiMjMj
    private String MiMiMjMj;
    @ValidDDDDDD
    private String DDDDDDD;
    private String A1bwnbnbnb;
    @NotNull
    private String YYGGiw;
    @NotNull
    private String IIiii;
    private String _99LaLaLa;
    private String QcLoLoLoLo;
    private String MMMULaULo;
    private String h0h0h0h0im;
    //Section1
    private String iRixhVV;
    private String Nddff;
    private String _00fff;
    private String _1snTTT;
    private String _2snTdTdTd;
    private String _29UUU;
    private String _3PoPoPoPo;
    private String _4PPPP;
    private String _4a3hhh;
    private String _5appp;
    private String _6RRRtR;
    private String _7wwWlW2;
    private String _7wawaWa1Wa2;
    private String _8NhCLCMCH;
    private String _9GGgg;
    //Section2
    @NotNull
    private String _222Dsvs;
    @NotNull
    private String _0ssTwTwTw;
    @NotNull
    private String _1PwaPwaHwaHwa;
    @NotNull
    private String _2PwPwHwHw;
    @NotNull
    private String _3dw1dw1dw2dw2;
    @NotNull
    private String _4Pw1Pw1Hw1Hw1;
    @NotNull
    private String _5Pw2Pw2Hw2Hw2;
    private String _6IsEsEsRs;
    private String ICING;
    private String _70HwaHwaHwa;
    private String _8swTbTbTb;
    private String ciSibiDizi;
    //Section3
    private String _0;
    @NotNull
    private String _1snTxTxTx;
    @NotNull
    private String _2snTnTnTn;
    private String _3Ejjj;
    private String _4Esss;
    @NotNull
    private String _5j1j2j3j4;
    private String j5j6j7j8j9;
//    @NotNull
//    private String _6RRRtR;
    @NotNull
    private String _7R24RR24RR24RR24;
    @NotNull
    private String _8NsChshs;
    private String _9SPSPspsp;
    private List<String> _80000;
    //Section4
    //Section5
        //Groups to be developed nationally

//    @NotNull(message = "{number.not.null}") @NotBlank(message = "{number.not.blank}") @UniqueSealNumber
    private Section0 section0;
    private Section1 section1;
    private Section2 section2;
    private Section3 section3;

    public Synop toObject(){
        return new Synop(section0, section1, section2, section3);
    }
//    public static DTOSynop toDTO(Synop synop) {
//        return new DTOSynop(synop.getSection0(), synop.getSection1(), synop.getSection2(), synop.getSection3());
//    }
}