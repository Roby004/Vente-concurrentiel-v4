package com.example.Ihm.models;

public class ProduitAccueil {
    private int idPro;
    private int idFr;
    private String design;
    private String descri;
    private int prix;
    private String categorie;
    private int nbClic;
    private byte[] imgPro;
    private int qte;
    private String avis;  // Ici je suppose qu'on va récupérer un commentaire d'exemple
    private double vote;
    private String date;

    public ProduitAccueil(int idPro, int idFr, String design, String descri, int prix, String categorie, int nbClic, byte[] imgPro, int qte, String avis, double vote, String date) {
        this.idPro = idPro;
        this.idFr = idFr;
        this.design = design;
        this.descri = descri;
        this.prix = prix;
        this.categorie = categorie;
        this.nbClic = nbClic;
        this.imgPro = imgPro;
        this.qte = qte;
        this.avis = avis;
        this.vote = vote;
        this.date = date;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public int getIdFr() {
        return idFr;
    }

    public void setIdFr(int idFr) {
        this.idFr = idFr;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
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

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    public double getVote() {
        return vote;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }

    public String getdate() {
        return date;
    }

    public void setdate(String date) {
        this.date = date;
    }
}
