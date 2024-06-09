package com.example.Ihm.DB;

import com.example.Ihm.models.Fournisseur;
import com.example.Ihm.models.ProduitAccueil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitAccueilDB {
     public List<ProduitAccueil> selectProduitAccueil() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        String sql="SELECT  p.idPro,p.idFr, p.design,p.descri,p.prix,p.categorie,p.nbClic,p.imgPro,p.qte,COUNT(a.commentaire) AS avis, ROUND(AVG(CASE WHEN a.vote > 0 THEN a.vote END) * 2) / 2 AS votes, p.dateAjout as date FROM produit p LEFT JOIN avis a ON p.idPro = a.idPro WHERE p.qte > 0 GROUP BY p.idPro";
        try( PreparedStatement statement= connection.prepareStatement(sql)){


            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                int idPro= resultSet.getInt("idPro");
                int idFr= resultSet.getInt("idFr");
                String design=resultSet.getString("design");
                String descri=resultSet.getString("descri");
                int prix=resultSet.getInt("prix");
                String categorie=resultSet.getString("categorie");
                int nbClic=resultSet.getInt("nbClic");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int qte=resultSet.getInt("qte");
                String avis=resultSet.getString("avis");
                double vote=resultSet.getDouble("votes");
                String date=resultSet.getString("date");
                produitAccueils.add(new ProduitAccueil(idPro,idFr,design,descri,prix,categorie,nbClic,imgPro,qte,avis,vote,date));
            }
            resultSet.close();
            statement.close();
        }

        return produitAccueils;
    }
    public List<ProduitAccueil> selectProduitAccueilRecent() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        String sql="SELECT  p.idPro,p.idFr, p.design,p.descri,p.prix,p.categorie,p.nbClic,p.imgPro,p.qte,COUNT(a.commentaire) AS avis, ROUND(AVG(CASE WHEN a.vote > 0 THEN a.vote END) * 2) / 2 AS votes, p.dateAjout as date FROM produit p LEFT JOIN avis a ON p.idPro = a.idPro WHERE p.qte > 0 GROUP BY p.idPro ORDER BY p.idPro DESC";
        try( PreparedStatement statement= connection.prepareStatement(sql)){


            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                int idPro= resultSet.getInt("idPro");
                int idFr= resultSet.getInt("idFr");
                String design=resultSet.getString("design");
                String descri=resultSet.getString("descri");
                int prix=resultSet.getInt("prix");
                String categorie=resultSet.getString("categorie");
                int nbClic=resultSet.getInt("nbClic");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int qte=resultSet.getInt("qte");
                String avis=resultSet.getString("avis");
                double vote=resultSet.getDouble("votes");
                String date=resultSet.getString("date");
                produitAccueils.add(new ProduitAccueil(idPro,idFr,design,descri,prix,categorie,nbClic,imgPro,qte,avis,vote,date));
            }
            resultSet.close();
            statement.close();
        }

        return produitAccueils;
    }

    public List<ProduitAccueil> selectProduitAccueilAsc() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        String sql="SELECT  p.idPro,p.idFr, p.design,p.descri,p.prix,p.categorie,p.nbClic,p.imgPro,p.qte,COUNT(a.commentaire) AS avis, ROUND(AVG(CASE WHEN a.vote > 0 THEN a.vote END) * 2) / 2 AS votes, p.dateAjout as date FROM produit p LEFT JOIN avis a ON p.idPro = a.idPro WHERE p.qte > 0 GROUP BY p.idPro ORDER BY p.design ASC";
        try( PreparedStatement statement= connection.prepareStatement(sql)){


            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                int idPro= resultSet.getInt("idPro");
                int idFr= resultSet.getInt("idFr");
                String design=resultSet.getString("design");
                String descri=resultSet.getString("descri");
                int prix=resultSet.getInt("prix");
                String categorie=resultSet.getString("categorie");
                int nbClic=resultSet.getInt("nbClic");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int qte=resultSet.getInt("qte");
                String avis=resultSet.getString("avis");
                double vote=resultSet.getDouble("votes");
                String date=resultSet.getString("date");
                produitAccueils.add(new ProduitAccueil(idPro,idFr,design,descri,prix,categorie,nbClic,imgPro,qte,avis,vote,date));
            }
            resultSet.close();
            statement.close();
        }

        return produitAccueils;
    }
    public List<ProduitAccueil> selectProduitAccueilDesc() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        String sql="SELECT  p.idPro,p.idFr, p.design,p.descri,p.prix,p.categorie,p.nbClic,p.imgPro,p.qte,COUNT(a.commentaire) AS avis, ROUND(AVG(CASE WHEN a.vote > 0 THEN a.vote END) * 2) / 2 AS votes, p.dateAjout as date FROM produit p LEFT JOIN avis a ON p.idPro = a.idPro WHERE p.qte > 0 GROUP BY p.idPro ORDER BY p.design DESC";
        try( PreparedStatement statement= connection.prepareStatement(sql)){


            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                int idPro= resultSet.getInt("idPro");
                int idFr= resultSet.getInt("idFr");
                String design=resultSet.getString("design");
                String descri=resultSet.getString("descri");
                int prix=resultSet.getInt("prix");
                String categorie=resultSet.getString("categorie");
                int nbClic=resultSet.getInt("nbClic");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int qte=resultSet.getInt("qte");
                String avis=resultSet.getString("avis");
                double vote=resultSet.getDouble("votes");
                String date=resultSet.getString("date");
                produitAccueils.add(new ProduitAccueil(idPro,idFr,design,descri,prix,categorie,nbClic,imgPro,qte,avis,vote,date));
            }
            resultSet.close();
            statement.close();
        }

        return produitAccueils;
    }
    //SELECT p.idPro, p.idFr, p.design, p.descri, p.prix, p.categorie, p.nbClic, p.imgPro, p.qte, a.commentaire AS avis, SUM(a.vote) as totalVotes, p.dateAjout as date FROM produit p LEFT JOIN avis a ON p.idPro = a.idPro GROUP BY p.idPro, p.idFr, p.design, p.descri, p.prix, p.categorie, p.nbClic, p.imgPro, p.qte, a.commentaire, p.dateAjout ORDER BY totalVotes DESC
    public List<ProduitAccueil> selectProduitAccueilPlusAime() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        String sql="SELECT p.idPro, p.idFr, p.design, p.descri, p.prix, p.categorie, p.nbClic, p.imgPro, p.qte, COUNT(a.commentaire) AS avis, SUM(ROUND(AVG(CASE WHEN a.vote > 0 THEN a.vote END) * 2) / 2 AS votes) as totalVotes, p.dateAjout as date FROM produit p LEFT JOIN avis a ON p.idPro = a.idPro WHERE p.qte > 0 GROUP BY p.idPro, p.idFr, p.design, p.descri, p.prix, p.categorie, p.nbClic, p.imgPro, p.qte, a.commentaire, p.dateAjout ORDER BY totalVotes DESC";
        try( PreparedStatement statement= connection.prepareStatement(sql)){

            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                int idPro= resultSet.getInt("idPro");
                int idFr= resultSet.getInt("idFr");
                String design=resultSet.getString("design");
                String descri=resultSet.getString("descri");
                int prix=resultSet.getInt("prix");
                String categorie=resultSet.getString("categorie");
                int nbClic=resultSet.getInt("nbClic");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int qte=resultSet.getInt("qte");
                String avis=resultSet.getString("avis");
                double vote=resultSet.getDouble("TotalVotes");
                String date=resultSet.getString("date");
                produitAccueils.add(new ProduitAccueil(idPro,idFr,design,descri,prix,categorie,nbClic,imgPro,qte,avis,vote,date));
            }
            resultSet.close();
            statement.close();
        }
        return produitAccueils;
    }

    public List<ProduitAccueil> selectProduitAccueilPlusVisite() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        String sql="SELECT  p.idPro,p.idFr, p.design,p.descri,p.prix,p.categorie, SUM(p.nbClic) as TotalNbClic ,p.imgPro,p.qte,COUNT(a.commentaire) AS avis, ROUND(AVG(CASE WHEN a.vote > 0 THEN a.vote END) * 2) / 2 AS votes, p.dateAjout as date FROM produit p LEFT JOIN avis a ON p.idPro = a.idPro WHERE p.qte > 0 GROUP BY p.idPro, p.idFr, p.design, p.descri, p.prix, p.categorie, p.imgPro, p.qte, a.commentaire,a.vote, p.dateAjout ORDER BY totalNbClic DESC";
        try( PreparedStatement statement= connection.prepareStatement(sql)){

            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                int idPro= resultSet.getInt("idPro");
                int idFr= resultSet.getInt("idFr");
                String design=resultSet.getString("design");
                String descri=resultSet.getString("descri");
                int prix=resultSet.getInt("prix");
                String categorie=resultSet.getString("categorie");
                int nbClic=resultSet.getInt("TotalNbClic");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int qte=resultSet.getInt("qte");
                String avis=resultSet.getString("avis");
                double vote=resultSet.getDouble("votes");
                String date=resultSet.getString("date");
                produitAccueils.add(new ProduitAccueil(idPro,idFr,design,descri,prix,categorie,nbClic,imgPro,qte,avis,vote,date));
            }
            resultSet.close();
            statement.close();
        }
        return produitAccueils;
    }

    public List<ProduitAccueil> selectProduitAccueilPlusAChete() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        String sql="SELECT p.idPro, p.idFr, p.design, p.descri, p.prix, p.categorie, p.nbClic, p.imgPro, p.qte,COUNT(a.commentaire) AS avis, ROUND(AVG(CASE WHEN a.vote > 0 THEN a.vote END) * 2) / 2 AS votes, p.dateAjout AS date, SUM(ac.qteAchat) AS totalAchat FROM produit p LEFT JOIN avis a ON p.idPro = a.idPro LEFT JOIN achat ac ON p.idPro = ac.idPro WHERE p.qte > 0 GROUP BY p.idPro, p.idFr, p.design, p.descri, p.prix, p.categorie, p.nbClic, p.imgPro, p.qte, a.commentaire, a.vote, p.dateAjout ORDER BY totalAchat DESC";
        try( PreparedStatement statement= connection.prepareStatement(sql)){

            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                int idPro= resultSet.getInt("idPro");
                int idFr= resultSet.getInt("idFr");
                String design=resultSet.getString("design");
                String descri=resultSet.getString("descri");
                int prix=resultSet.getInt("prix");
                String categorie=resultSet.getString("categorie");
                int nbClic=resultSet.getInt("nbClic");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int qte=resultSet.getInt("qte");
                String avis=resultSet.getString("avis");
                double vote=resultSet.getDouble("votes");
                String date=resultSet.getString("date");
                produitAccueils.add(new ProduitAccueil(idPro,idFr,design,descri,prix,categorie,nbClic,imgPro,qte,avis,vote,date));
            }
            resultSet.close();
            statement.close();
        }
        return produitAccueils;
    }
    public List<ProduitAccueil> selectProduitRecherche(String recherche) throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        String sql="SELECT p.idPro, p.idFr, p.design, p.descri,  p.prix, p.categorie,p.nbClic,p.imgPro,p.qte, COUNT(a.commentaire) AS avis, ROUND(AVG(CASE WHEN a.vote > 0 THEN a.vote END) * 2) / 2 AS votes,    p.dateAjout as date FROM     produit p LEFT JOIN  avis a ON p.idPro=a.idPro WHERE p.qte > 0 AND p.design LIKE ? ORDER BY p.idPro DESC";
        try( PreparedStatement statement= connection.prepareStatement(sql)){

            statement.setString(1, "%" + recherche + "%");
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                int idPro= resultSet.getInt("idPro");
                int idFr= resultSet.getInt("idFr");
                String design=resultSet.getString("design");
                String descri=resultSet.getString("descri");
                int prix=resultSet.getInt("prix");
                String categorie=resultSet.getString("categorie");
                int nbClic=resultSet.getInt("nbClic");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int qte=resultSet.getInt("qte");
                String avis=resultSet.getString("avis");
                double vote=resultSet.getDouble("votes");
                String date=resultSet.getString("date");
                produitAccueils.add(new ProduitAccueil(idPro,idFr,design,descri,prix,categorie,nbClic,imgPro,qte,avis,vote,date));
            }
            resultSet.close();
            statement.close();
        }

        return produitAccueils;
    }
}
