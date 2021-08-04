package com.institutohidrografico.application.persistence.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;

@Audited @AuditTable(value = "shipsynop_auditoria")
@Entity @Table(name="shipsynop")//, schema="shipsynopweb")
@AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = false) @Data
public class ShipSynop extends GenericEntity {

    @Column(length = 128) //@Pattern(regexp = "[0-2][0-9]|30")
    private String observador;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataObservacao;
    @Column(length = 128)
    private String estacao;
    @Column(length = 128)
    private String iw;
    @Column(length = 128)
    private String iii;
    @Column(length = 128)
    private String ir;
    @Column(length = 128)
    private String ix;
    @Column(length = 128)
    private String h;
    @Column(length = 128)
    private String dd;
    @Column(length = 128)
    private String ff;
    @Column(length = 128)
    private String fixo00_1;
    @Column(length = 128)
    private String fff;
    @Column(length = 128)
    private String fixo1_1;
    @Column(length = 128)
    private String fixo2_1;
    @Column(length = 128)
    private String fixo3_1;
    @Column(length = 128)
    private String fixo4_1;
    @Column(length = 128)
    private String fixo5_1;
    @Column(length = 128)
    private String a;
    @Column(length = 128)
    private String ppp;
    @Column(length = 128)
    private String fixo6_1;
    @Column(length = 128)
    private String tr;
    @Column(length = 128)
    private String fixo7_1;
    @Column(length = 128)
    private String ww;
    @Column(length = 128)
    private String fixo8_1;
    @Column(length = 128)
    private String fixo9_1;
    @Column(length = 128)
    private String fixo222_2;
    @Column(length = 128)
    private String fixo0_2;
    @Column(length = 128)
    private String fixo1_2;
    @Column(length = 128)
    private String fixo2_2;
    @Column(length = 128)
    private String fixo3_2;
    @Column(length = 128)
    private String dw1dw1;
    @Column(length = 128)
    private String dw2dw2;
    @Column(length = 128)
    private String fixo4_2;
    @Column(length = 128)
    private String fixo5_2;
    @Column(length = 128)
    private String fixo6_2;
    @Column(length = 128)
    private String fixo70_2;
    @Column(length = 128)
    private String fixo8_2;
    @Column(length = 128)
    private String ci;
    @Column(length = 128)
    private String bi;
    @Column(length = 128)
    private String zi;
    @Column(length = 128)
    private String fixo_333;
    @Column(length = 128)
    private String fixo1_3;
    @Column(length = 128)
    private String fixo2_3;
    @Column(length = 128)
    private String fixo5_3;
    @Column(length = 128)
    private String ind89;
    @Column(length = 128)
    private String fixo555_5;
    @Column(length = 128) @JsonProperty("ichw")
    private String iChw;
    @Column(length = 128) @JsonProperty("icm")
    private String iCM;
    @Column(length = 128)
    private String cs;
    @Column(length = 128) @JsonProperty("icf")
    private String iCF;
    @Column(length = 128) @JsonProperty("icp")
    private String iCP;
    @Column(length = 128) @JsonProperty("icq")
    private String iCQ;
    @Column(length = 128) @JsonProperty("2snTdTdTdUUU")
    private String _2snTdTdTdUUU;
    @Column(length = 128) @JsonProperty("5Pw2Pw2Hw2Hw2")
    private String _5Pw2Pw2Hw2Hw2;
    @Column(length = 128) @JsonProperty("8NhClCmCh")
    private String _8NhClCmCh;
    @Column(length = 128)
    private String dddddd;
    @Column(length = 128) @JsonProperty("2PwPwHwHw")
    private String _2PwPwHwHw;
    @Column(length = 128) @JsonProperty("00fff")
    private String _00fff;
    @Column(length = 128) @JsonProperty("3PoPoPoPo")
    private String _3PoPoPoPo;
    @Column(length = 128) @JsonProperty("2snTnTnTn")
    private String _2snTnTnTn;
    @Column(length = 128)
    private String yyggiw;
    @Column(length = 128) @JsonProperty("1snTTT")
    private String _1snTTT;
    @Column(length = 128) @JsonProperty("5appp")
    private String _5appp;
    @Column(length = 128) @JsonProperty("6RRRtr")
    private String _6RRRtr;
    @Column(length = 128) @JsonProperty("222DsVs")
    private String _222DsVs;
    @Column(length = 128) @JsonProperty("4Pw1Pw1Hw1Hw1")
    private String _4Pw1Pw1Hw1Hw1;
    @Column(length = 128)
    private String irixhVV;
    @Column(length = 128)
    private String iiiii;
    @Column(length = 128) @JsonProperty("99LaLaLa")
    private String _99LaLaLa;
    @Column(length = 128)
    private String qcLoLoLoLo;
    @Column(length = 128) @JsonProperty("3dw1dw1dw2dw2")
    private String _3dw1dw1dw2dw2;
    @Column(length = 128) @JsonProperty("6IsEsEsRs")
    private String _6IsEsEsRs;
    @Column(length = 128)
    private String nddff;
    @Column(length = 128) @JsonProperty("4PPPP")
    private String _4PPPP;
    @Column(length = 128) @JsonProperty("1PwaPwaHwaHwa")
    private String _1PwaPwaHwaHwa;
    @Column(length = 128) @JsonProperty("70HwaHwaHwa")
    private String _70HwaHwaHwa;
    @Column(length = 128) @JsonProperty("7wwW1W2")
    private String _7wwW1W2;
    @Column(length = 128)
    private String ciSibiDizi;
    @Column(length = 128)
    private String ice;
    @Column(length = 128) @JsonProperty("1snTxTxTx")
    private String _1snTxTxTx;
    @Column(length = 128) @JsonProperty("0SsTwTwTw")
    private String _0SsTwTwTw;
    @Column(length = 128) @JsonProperty("8SwTbTbTb")
    private String _8SwTbTbTb;
    @Column(length = 128)
    private String yy;
    @Column(length = 128)
    private String fixo99;
    @Column(length = 128)
    private String laLaLa;
    @Column(length = 128)
    private String qc;
    @Column(length = 128)
    private String ii;
    @Column(length = 128)
    private String loLoLoLo;
    @Column(length = 128)
    private String vv;
    @Column(length = 128)
    private String aabbxx;
    @Column(length = 128)
    private String gg;
    @Column(length = 128)
    private String poPoPoPo;
    @Column(length = 128)
    private String ch;
    @Column(length = 128)
    private String tdTdTd_UUU;
    @Column(length = 128)
    private String n;
    @Column(length = 128)
    private String sn1_1;
    @Column(length = 128)
    private String ttt;
    @Column(length = 128)
    private String rrr;
    @Column(length = 128)
    private String pppp;
    @Column(length = 128)
    private String w1W2;
    @Column(length = 128)
    private String nh;
    @Column(length = 128)
    private String sn2_1;
    @Column(length = 128)
    private String cl;
    @Column(length = 128)
    private String cm;
    @Column(length = 128)
    private String hw1Hw1;
    @Column(length = 128)
    private String pw2Pw2;
    @Column(length = 128)
    private String hwHw;
    @Column(length = 128)
    private String ss;
    @Column(length = 128)
    private String pwaPwa;
    @Column(length = 128)
    private String pw1Pw1;
    @Column(length = 128)
    private String vs;
    @Column(length = 128) @JsonProperty("is")
    private String _is;
    @Column(length = 128)
    private String gggg;
    @Column(length = 128)
    private String ds;
    @Column(length = 128)
    private String twTwTw;
    @Column(length = 128)
    private String hwaHwa;
    @Column(length = 128)
    private String pwPw;
    @Column(length = 128)
    private String hw2Hw2;
    @Column(length = 128)
    private String esEs;
    @Column(length = 128)
    private String sw;
    @Column(length = 128)
    private String sn2_3;
    @Column(length = 128)
    private String di;
    @Column(length = 128)
    private String hwa2Hwa2Hwa2;
    @Column(length = 128)
    private String p24P24P24;
    @Column(length = 128)
    private String tnTnTn;
    @Column(length = 128) @JsonProperty("9GGgg")
    private String _9GGgg;
    @Column(length = 128)
    private String sn1_3;
    @Column(length = 128)
    private String si;
    @Column(length = 128)
    private String tbTbTb;
    @Column(length = 128)
    private String txTxTx;
    @Column(length = 128)
    private String rs;
    @Column
    private boolean ship;
    @Column
    private boolean synop;
    @Column(length = 128) @JsonProperty("ichwiCMCsiCFiCpiCQ")
    private String iChwiCMCsiCFiCpiCQ;
    @Column(length = 128) @JsonProperty("5ind89P24P24P24")
    private String _5ind89P24P24P24;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "file", nullable = true)
    private File file;
}
