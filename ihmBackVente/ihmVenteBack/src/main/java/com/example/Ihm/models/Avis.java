package com.example.Ihm.models;

public class Avis {
    int idCli;
    int idPro;
    String commentaire;
    double vote;
    String dateAvis;

    public Avis(){

    }
    public Avis(int idCli, int idPro, String commentaire, double vote, String dateAvis) {
        this.idCli = idCli;
        this.idPro = idPro;
        this.commentaire = commentaire;
        this.vote = vote;
        this.dateAvis = dateAvis;
    }

    public Avis(int idPro, String commentaire, double vote, String dateAvis) {
        this.idPro = idPro;
        this.commentaire = commentaire;
        this.vote = vote;
        this.dateAvis = dateAvis;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
    }

    public int getIdPro() {
        return idPro;
    }

    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public double getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public String getDateAvis() {
        return dateAvis;
    }

    public void setDateAvis(String dateAvis) {
        this.dateAvis = dateAvis;
    }
}
