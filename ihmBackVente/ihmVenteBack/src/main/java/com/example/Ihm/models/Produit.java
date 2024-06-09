package com.example.Ihm.models;

import java.sql.Blob;

public class Produit {
    int idPro;
    String design;
    int prix;
    String descri;
    int qte;
    String categorie;
    int nbClic;
    //Blob imgPro;
    byte[] imgPro;

    int idFr;

    String dateAjout;

    public Produit(){

    }

    public Produit(int idPro, String design, int prix, String descri, int qte, String categorie, int nbClic, byte[] imgPro, int idFr, String dateAjout) {
        this.idPro = idPro;
        this.design = design;
        this.prix = prix;
        this.descri = descri;
        this.qte = qte;
        this.categorie = categorie;
        this.nbClic = nbClic;
        this.imgPro = imgPro;
        this.dateAjout=dateAjout;
        this.idFr=idFr;
    }

    public Produit(String design, int prix, String descri, int qte, String categorie, int nbClic, byte[] imgPro, int idFr, String dateAjout) {
        this.design = design;
        this.prix = prix;
        this.descri = descri;
        this.qte = qte;
        this.categorie = categorie;
        this.nbClic = nbClic;
        this.imgPro = imgPro;
        this.dateAjout=dateAjout;
        this.idFr=idFr;
    }

    public int getIdFr() {
        return idFr;
    }

    public void setIdFr(int idFr) {
        this.idFr = idFr;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(String dateAjout) {
        this.dateAjout = dateAjout;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getNbClic() {
        return nbClic;
    }

    public void setNbClic(int nbClic) {
        this.nbClic = nbClic;
    }

    public byte[] getImgPro() {
        return imgPro;
    }

    public void setImgPro(byte[] imgPro) {
        this.imgPro = imgPro;
    }
}
