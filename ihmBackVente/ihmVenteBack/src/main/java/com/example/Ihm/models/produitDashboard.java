package com.example.Ihm.models;

public class produitDashboard {
    int idPro;
    String design;
    String nomFr;
    int idFr;
    byte[] imgPro;
    String label;
    int value;

    public produitDashboard(int idPro, String design, String nomFr, int idFr, byte[] imgPro) {
        this.idPro = idPro;
        this.design = design;
        this.nomFr = nomFr;
        this.idFr = idFr;
        this.imgPro = imgPro;
    }

    public produitDashboard(String label, int value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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

    public String getNomFr() {
        return nomFr;
    }

    public void setNomFr(String nomFr) {
        this.nomFr = nomFr;
    }

    public int getIdFr() {
        return idFr;
    }

    public void setIdFr(int idFr) {
        this.idFr = idFr;
    }

    public byte[] getImgPro() {
        return imgPro;
    }

    public void setImgPro(byte[] imgPro) {
        this.imgPro = imgPro;
    }
}
