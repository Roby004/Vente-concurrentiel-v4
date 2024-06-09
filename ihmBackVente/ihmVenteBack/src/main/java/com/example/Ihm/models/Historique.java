package com.example.Ihm.models;

public class Historique {
    //Produit, Compagnie, Prix, Quantite,Date
    String Produit;
    String Compagnie;
    int Prix;
    int Quantite;
    String Date;
    byte[] Img;

    public Historique(String produit, String compagnie, int prix, int quantite, String date, byte[] img) {
        Produit = produit;
        Compagnie = compagnie;
        Prix = prix;
        Quantite = quantite;
        Date = date;
        Img = img;
    }

    public byte[] getImg() {
		return Img;
	}

	public void setImg(byte[] img) {
		Img = img;
	}

	public String getProduit() {
        return Produit;
    }

    public void setProduit(String produit) {
        Produit = produit;
    }

    public String getCompagnie() {
        return Compagnie;
    }

    public void setCompagnie(String compagnie) {
        Compagnie = compagnie;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int prix) {
        Prix = prix;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int quantite) {
        Quantite = quantite;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}

