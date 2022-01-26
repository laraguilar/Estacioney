package com.example.estacioney;

public class Estacionamento {
    String idEstac;
    String nomEstac;
    String qtdVagas;
    String valFixo;
    String valAcresc;
    String vagasDisp;
    String logr;
    String cep;


    public Estacionamento(String idEstac, String nomEstac, String qtdVagas, String valFixo, String valAcresc, String vagasDisp) {
        this.idEstac = idEstac;
        this.nomEstac = nomEstac;
        this.qtdVagas = qtdVagas;
        this.valFixo = valFixo;
        this.valAcresc = valAcresc;
        this.vagasDisp = vagasDisp;
    }

    public Estacionamento(String idEstac, String nomEstac, String qtdVagas, String valFixo, String valAcresc) {
        this.idEstac = idEstac;
        this.nomEstac = nomEstac;
        this.qtdVagas = qtdVagas;
        this.valFixo = valFixo;
        this.valAcresc = valAcresc;
    }

    public Estacionamento(String idEstac, String nomEstac, String logr, String cep) {
        this.idEstac = idEstac;
        this.nomEstac = nomEstac;
        this.logr = logr;
        this.cep = cep;
    }

    public Estacionamento(String idEstac, String nomEstac) {
        this.idEstac = idEstac;
        this.nomEstac = nomEstac;
    }

    public String getIdEstac() {
        return idEstac;
    }

    public void setIdEstac(String idEstac) {
        this.idEstac = idEstac;
    }

    public String getNomEstac() {
        return nomEstac;
    }

    public void setNomEstac(String nomEstac) {
        this.nomEstac = nomEstac;
    }

    public String getLogr() {
        return logr;
    }

    public void setLogr(String logr) {
        this.logr = logr;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getQtdVagas() {
        return qtdVagas;
    }

    public void setQtdVagas(String qtdVagas) {
        this.qtdVagas = qtdVagas;
    }

    public String getValFixo() {
        return valFixo;
    }

    public void setValFixo(String valFixo) {
        this.valFixo = valFixo;
    }

    public String getValAcresc() {
        return valAcresc;
    }

    public void setValAcresc(String valAcresc) {
        this.valAcresc = valAcresc;
    }

    public String getVagasDisp() {
        return vagasDisp;
    }

    public void setVagasDisp(String vagasDisp) {
        this.vagasDisp = vagasDisp;
    }





}
