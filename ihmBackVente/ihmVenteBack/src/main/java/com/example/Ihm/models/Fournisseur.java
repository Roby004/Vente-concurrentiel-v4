package com.example.Ihm.models;

import java.sql.Blob;

public class Fournisseur {
    int idFr;
    String nomFr;
    String mdpFr;
    String mailFr;
    byte[] imgFr;
    String contactFr;
    String adresseFr;
    Boolean accesFr;
    String roleFr;
    public Fournisseur(){

    }

    public Fournisseur(int idFr, String nomFr, String mdpFr, String mailFr, byte[] imgFr, String contactFr, String adresseFr, Boolean accesFr) {
        this.idFr = idFr;
        this.nomFr = nomFr;
        this.mdpFr = mdpFr;
        this.mailFr = mailFr;
        this.imgFr = imgFr;
        this.contactFr=contactFr;
        this.adresseFr=adresseFr;
        this.accesFr=accesFr;
    }

    public Fournisseur(String nomFr, String mdpFr, String mailFr, byte[] imgFr, String contactFr, String adresseFr, Boolean accesFr) {
        this.nomFr = nomFr;
        this.mdpFr = mdpFr;
        this.mailFr = mailFr;
        this.imgFr = imgFr;
        this.contactFr=contactFr;
        this.adresseFr=adresseFr;
        this.accesFr=accesFr;
    }

    public String getContactFr() {
        return contactFr;
    }

    public void setContactFr(String contactFr) {
        this.contactFr = contactFr;
    }

    public String getAdresseFr() {
        return adresseFr;
    }

    public void setAdresseFr(String adresseFr) {
        this.adresseFr = adresseFr;
    }

    public Boolean getAccesFr() {
        return accesFr;
    }

    public void setAccesFr(Boolean accesFr) {
        this.accesFr = accesFr;
    }

    public int getIdFr() {
        return idFr;
    }

    public void setIdFr(int idFr) {
        this.idFr = idFr;
    }

    public String getNomFr() {
        return nomFr;
    }

    public void setNomFr(String nomFr) {
        this.nomFr = nomFr;
    }

    public String getMdpFr() {
        return mdpFr;
    }

    public void setMdpFr(String mdpFr) {
        this.mdpFr = mdpFr;
    }

    public String getMailFr() {
        return mailFr;
    }

    public void setMailFr(String mailFr) {
        this.mailFr = mailFr;
    }

    public byte[] getImgFr() {
        return imgFr;
    }

    public void setImgFr(byte[] imgFr) {
        this.imgFr = imgFr;
    }

    public String getRoleFr() {
        return roleFr;
    }

    public void setRoleFr(String roleFr) {
        this.roleFr = roleFr;
    }
}
