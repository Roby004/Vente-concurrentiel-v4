package com.example.Ihm.models;

import java.sql.Blob;

public class Client {
    int idCli;
    String pseudo;
    String mdpCli;
    String mailCli;
    byte[] imgCli;
    String contact;
    String adresse;
    Boolean acces;
    String role;

    public Client(){

    }

    public Client(int idCli, String pseudo, String mdpCli, String mailCli, byte[] imgCli, String contact, String adresse, Boolean acces) {
        this.idCli = idCli;
        this.pseudo = pseudo;
        this.mdpCli = mdpCli;
        this.mailCli = mailCli;
        this.imgCli = imgCli;
        this.contact=contact;
        this.adresse=adresse;
        this.acces=acces;
    }

    public Client(String pseudo, String mdpCli, String mailCli, byte[] imgCli, String contact, String adresse, Boolean acces) {
        this.pseudo = pseudo;
        this.mdpCli = mdpCli;
        this.mailCli = mailCli;
        this.imgCli = imgCli;
        this.contact=contact;
        this.adresse=adresse;
        this.acces=acces;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Boolean getAcces() {
        return acces;
    }

    public void setAcces(Boolean acces) {
        this.acces = acces;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdpCli() {
        return mdpCli;
    }

    public void setMdpCli(String mdpCli) {
        this.mdpCli = mdpCli;
    }

    public String getMailCli() {
        return mailCli;
    }

    public void setMailCli(String mailCli) {
        this.mailCli = mailCli;
    }

    public byte[] getImgCli() {
        return imgCli;
    }

    public void setImgCli(byte[] imgCli) {
        this.imgCli = imgCli;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
