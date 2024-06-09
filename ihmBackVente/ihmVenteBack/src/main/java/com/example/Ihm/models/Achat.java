package com.example.Ihm.models;

public class Achat {
    int idCli;
    int idFr;
    int idPro;
    int qteAchat;
    String dateAchat;

    public Achat(){

    }

    public Achat(int idCli, int idFr, int idPro, int qteAchat, String dateAchat) {
        this.idCli = idCli;
        this.idFr = idFr;
        this.idPro = idPro;
        this.qteAchat = qteAchat;
        this.dateAchat = dateAchat;
    }

    public Achat(int idFr, int idPro, int qteAchat, String dateAchat) {
        this.idFr = idFr;
        this.idPro = idPro;
        this.qteAchat = qteAchat;
        this.dateAchat = dateAchat;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public int getIdFr() {
        return idFr;
    }

    public void setIdFr(int idFr) {
        this.idFr = idFr;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public int getQteAchat() {
        return qteAchat;
    }

    public void setQteAchat(int qteAchat) {
        this.qteAchat = qteAchat;
    }

    public String getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(String dateAchat) {
        this.dateAchat = dateAchat;
    }
}
