package com.example.Ihm.models;

public class produitRevenu {
    String mois;
    String annee;
    int revenue;

    public produitRevenu(String mois, String annee, int revenue) {
        this.mois = mois;
        this.annee = annee;
        this.revenue = revenue;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }
}
