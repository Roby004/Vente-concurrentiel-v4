package com.example.Ihm.models;

public class AchatDashboard {
    byte[] imgCli;
    byte[] imgFr;
    byte[] imgPro;
    int qteAchat;
    String dateAchat;

    public AchatDashboard(){

    }

    public AchatDashboard(byte[] imgCli, byte[] imgFr, byte[] imgPro, int qteAchat, String dateAchat) {
        this.imgCli = imgCli;
        this.imgFr = imgFr;
        this.imgPro = imgPro;
        this.qteAchat = qteAchat;
        this.dateAchat = dateAchat;
    }

    public AchatDashboard(byte[] imgFr, byte[] imgPro, int qteAchat, String dateAchat) {
        this.imgFr = imgFr;
        this.imgPro = imgPro;
        this.qteAchat = qteAchat;
        this.dateAchat = dateAchat;
    }

    public byte[] getimgCli() {
        return imgCli;
    }

    public void setimgCli(byte[] imgCli) {
        this.imgCli = imgCli;
    }

    public byte[]  getimgFr() {
        return imgFr;
    }

    public void setimgFr(byte[] imgFr) {
        this.imgFr = imgFr;
    }

    public byte[]  getimgPro() {
        return imgPro;
    }

    public void setimgPro(byte[] imgPro) {
        this.imgPro = imgPro;
    }

    public int getqteAchat() {
        return qteAchat;
    }

    public void setqteAchat(int qteAchat) {
        this.qteAchat = qteAchat;
    }

    public String getdateAchat() {
        return dateAchat;
    }

    public void setdateAchat(String dateAchat) {
        this.dateAchat = dateAchat;
    }
}

