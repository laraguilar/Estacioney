package com.example.estacioney;

public class Estacionamento {

    String idEstac;
    String nomEstac;
    String logr;
    String cep;



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








}
