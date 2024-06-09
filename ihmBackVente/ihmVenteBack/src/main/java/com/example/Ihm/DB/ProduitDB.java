package com.example.Ihm.DB;

import com.example.Ihm.models.Client;
import com.example.Ihm.models.Fournisseur;
import com.example.Ihm.models.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDB {
	
	public int nbParProduit(int idPro) throws SQLException {
		int nb = 0;

        Connection connection = ConnectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement("SELECT qte AS nbProduit FROM produit WHERE idPro = ?")){
        	statement.setInt(1, idPro);
            try(ResultSet resultSet = statement.executeQuery()) {
            	if (resultSet.next()) {
            		nb = resultSet.getInt("nbProduit");
            	}
            }
        }catch (SQLException e) {
            System.out.println("Error retrieving produit count"+ e);
        }
        return nb;
	}
	
    //select
    public List<Produit> selectProduit() throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try(PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit")){
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                int idPro= resultSet.getInt("idPro");
                String design=resultSet.getString("design");
                int prix= resultSet.getInt("prix");
                String descri=resultSet.getString("descri");
                int qte= resultSet.getInt("qte");
                String categorie=resultSet.getString("categorie");
                int nbClic= resultSet.getInt("nbClic");
                //Blob imgPro=resultSet.getBlob("imgPro");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int idFr= resultSet.getInt("idFr");
                String dateAjout=resultSet.getString("dateAjout");
                produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
            }
            resultSet.close();
            statement.close();
        }
        catch (Exception e){
            System.out.println(e);
        }


        return produits;
    }
    public List<Produit> selectUnProduit(int idProduit) throws SQLException {
        List<Produit> produits = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM produit WHERE idPro = ?");
            ) {

            statement.setInt(1, idProduit);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("idPro");
                String designation = resultSet.getString("design");
                int prix = resultSet.getInt("prix");
                String description = resultSet.getString("descri");
                int quantite = resultSet.getInt("qte");
                String categorie = resultSet.getString("categorie");
                int nbClic = resultSet.getInt("nbClic");
                //Blob imgPro=resultSet.getBlob("imgPro");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int idFournisseur = resultSet.getInt("idFr");
                String dateAjout = resultSet.getString("dateAjout");

                produits.add(new Produit(id, designation, prix, description, quantite, categorie, nbClic, imgPro, idFournisseur, dateAjout));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return produits;
    }

    public List<Produit> selectProduitIdAsc() throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit ORDER by idPro ASC");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idPro= resultSet.getInt("idPro");
            String design=resultSet.getString("design");
            int prix= resultSet.getInt("prix");
            String descri=resultSet.getString("descri");
            int qte= resultSet.getInt("qte");
            String categorie=resultSet.getString("categorie");
            int nbClic= resultSet.getInt("nbClic");
            //Blob imgPro=resultSet.getBlob("imgPro");
            byte[] imgPro=resultSet.getBytes("imgPro");
            int idFr= resultSet.getInt("idFr");
            String dateAjout=resultSet.getString("dateAjout");
            produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
        }
        resultSet.close();
        statement.close();
        return produits;
    }
    public List<Produit> selectProduitIdDesc() throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit ORDER by idPro DESC");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idPro= resultSet.getInt("idPro");
            String design=resultSet.getString("design");
            int prix= resultSet.getInt("prix");
            String descri=resultSet.getString("descri");
            int qte= resultSet.getInt("qte");
            String categorie=resultSet.getString("categorie");
            int nbClic= resultSet.getInt("nbClic");
            //Blob imgPro=resultSet.getBlob("imgPro");
            byte[] imgPro=resultSet.getBytes("imgPro");
            int idFr= resultSet.getInt("idFr");
            String dateAjout=resultSet.getString("dateAjout");
            produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
        }
        resultSet.close();
        statement.close();
        return produits;
    }
    public List<Produit> selectProduitDesignDesc() throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit ORDER by design DESC");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idPro= resultSet.getInt("idPro");
            String design=resultSet.getString("design");
            int prix= resultSet.getInt("prix");
            String descri=resultSet.getString("descri");
            int qte= resultSet.getInt("qte");
            String categorie=resultSet.getString("categorie");
            int nbClic= resultSet.getInt("nbClic");
            //Blob imgPro=resultSet.getBlob("imgPro");
            byte[] imgPro=resultSet.getBytes("imgPro");
            int idFr= resultSet.getInt("idFr");
            String dateAjout=resultSet.getString("dateAjout");
            produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
        }
        resultSet.close();
        statement.close();
        return produits;
    }
    public List<Produit> selectProduitDesignAsc() throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit ORDER by design ASC");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idPro= resultSet.getInt("idPro");
            String design=resultSet.getString("design");
            int prix= resultSet.getInt("prix");
            String descri=resultSet.getString("descri");
            int qte= resultSet.getInt("qte");
            String categorie=resultSet.getString("categorie");
            int nbClic= resultSet.getInt("nbClic");
            //Blob imgPro=resultSet.getBlob("imgPro");
            byte[] imgPro=resultSet.getBytes("imgPro");
            int idFr= resultSet.getInt("idFr");
            String dateAjout=resultSet.getString("dateAjout");
            produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
        }
        resultSet.close();
        statement.close();
        return produits;
    }
    public List<Produit> selectProduitPrixDesc() throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit ORDER by prix DESC");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idPro= resultSet.getInt("idPro");
            String design=resultSet.getString("design");
            int prix= resultSet.getInt("prix");
            String descri=resultSet.getString("descri");
            int qte= resultSet.getInt("qte");
            String categorie=resultSet.getString("categorie");
            int nbClic= resultSet.getInt("nbClic");
            //Blob imgPro=resultSet.getBlob("imgPro");
            byte[] imgPro=resultSet.getBytes("imgPro");
            int idFr= resultSet.getInt("idFr");
            String dateAjout=resultSet.getString("dateAjout");
            produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
        }
        resultSet.close();
        statement.close();
        return produits;
    }
    public List<Produit> selectProduitPrixAsc() throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit ORDER by prix ASC");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idPro= resultSet.getInt("idPro");
            String design=resultSet.getString("design");
            int prix= resultSet.getInt("prix");
            String descri=resultSet.getString("descri");
            int qte= resultSet.getInt("qte");
            String categorie=resultSet.getString("categorie");
            int nbClic= resultSet.getInt("nbClic");
           // Blob imgPro=resultSet.getBlob("imgPro");
            byte[] imgPro=resultSet.getBytes("imgPro");
            int idFr= resultSet.getInt("idFr");
            String dateAjout=resultSet.getString("dateAjout");
            produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
        }
        resultSet.close();
        statement.close();
        return produits;
    }

    //liste produiit achete par client
    public List<Produit> getProduitsAchetésParClient(int idCli) throws SQLException {
        List<Produit> produitsAchetés = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM produit INNER JOIN achat ON produit.idPro = achat.idPro WHERE achat.idCli = ?");
             ) {
            statement.setInt(1, idCli);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idPro= resultSet.getInt("idPro");
                String design=resultSet.getString("design");
                int prix= resultSet.getInt("prix");
                String descri=resultSet.getString("descri");
                int qte= resultSet.getInt("qte");
                String categorie=resultSet.getString("categorie");
                int nbClic= resultSet.getInt("nbClic");
                //Blob imgPro=resultSet.getBlob("imgPro");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int idFr= resultSet.getInt("idFr");
                String dateAjout=resultSet.getString("dateAjout");
                produitsAchetés.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return produitsAchetés;
    }


    //liste produit achete par client par mois
    public List<Produit> getProduitsAchetésParClientMois(int idCli, String mois) throws SQLException {
        List<Produit> produitsAchetés = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM produit INNER JOIN achat ON produit.idPro = achat.idPro WHERE achat.idCli = ? AND MONTH(achat.dateAchat)=?");
             ResultSet resultSet = statement.executeQuery()) {

            statement.setInt(1, idCli);
            statement.setString(2, mois);

            while (resultSet.next()) {
                int idPro= resultSet.getInt("idPro");
                String design=resultSet.getString("design");
                int prix= resultSet.getInt("prix");
                String descri=resultSet.getString("descri");
                int qte= resultSet.getInt("qte");
                String categorie=resultSet.getString("categorie");
                int nbClic= resultSet.getInt("nbClic");
               // Blob imgPro=resultSet.getBlob("imgPro");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int idFr= resultSet.getInt("idFr");
                String dateAjout=resultSet.getString("dateAjout");
                produitsAchetés.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return produitsAchetés;
    }
    //liste produit achete par client par annee
    public List<Produit> getProduitsAchetésParClientAnnee(int idCli, String annee) throws SQLException {
        List<Produit> produitsAchetés = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM produit INNER JOIN achat ON produit.idPro = achat.idPro WHERE achat.idCli = ? AND YEAR(achat.dateAchat)=?");
             ResultSet resultSet = statement.executeQuery()) {

            statement.setInt(1, idCli);
            statement.setString(2, annee);

            while (resultSet.next()) {
                int idPro= resultSet.getInt("idPro");
                String design=resultSet.getString("design");
                int prix= resultSet.getInt("prix");
                String descri=resultSet.getString("descri");
                int qte= resultSet.getInt("qte");
                String categorie=resultSet.getString("categorie");
                int nbClic= resultSet.getInt("nbClic");
                //Blob imgPro=resultSet.getBlob("imgPro");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int idFr= resultSet.getInt("idFr");
                String dateAjout=resultSet.getString("dateAjout");
                produitsAchetés.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return produitsAchetés;
    }
    //liste produits achete par client par mois et annne
    public List<Produit> getProduitsAchetésParClientMoisAnne(int idCli, String mois, String annee) throws SQLException {
        List<Produit> produitsAchetés = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM produit INNER JOIN achat ON produit.idPro = achat.idPro WHERE achat.idCli = ? AND MONTH(achat.dateAchat)=? AND YEAR(achat.dateAchat)=?");
             ResultSet resultSet = statement.executeQuery()) {

            statement.setInt(1, idCli);
            statement.setString(2, mois);
            statement.setString(3, annee);

            while (resultSet.next()) {
                int idPro= resultSet.getInt("idPro");
                String design=resultSet.getString("design");
                int prix= resultSet.getInt("prix");
                String descri=resultSet.getString("descri");
                int qte= resultSet.getInt("qte");
                String categorie=resultSet.getString("categorie");
                int nbClic= resultSet.getInt("nbClic");
                //Blob imgPro=resultSet.getBlob("imgPro");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int idFr= resultSet.getInt("idFr");
                String dateAjout=resultSet.getString("dateAjout");
                produitsAchetés.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));

            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return produitsAchetés;
    }



    public int takeId(String design) throws SQLException {
        int idPro = 0;
        ConnectionDB connectionDB = new ConnectionDB();
        try (Connection connection = connectionDB.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT idPro FROM produit WHERE design = ?");
           ) {

            statement.setString(1, design);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                idPro = resultSet.getInt("idPro");
            }
        } catch (SQLException e) {
            throw e;
        }
        return idPro;
    }

    //produit le plus visite
    public int produitPlusVisite() throws SQLException {
        int idPro=0;
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement("SELECT idPro, MAX(nbClic) AS nbC\n" +
                "FROM produit\n" +
                "GROUP BY idPro\n" +
                "ORDER BY nbC DESC\n" +
                "LIMIT 1;\n");
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                idPro = resultSet.getInt("idPro");
            }
        }
        return idPro;
    }

    //nb produit total/fournisseur
    public int nbProduitQteFournisseur(String nomFr) throws SQLException {
        int nb = 0;
        FournisseurDb fournisseurDb = new FournisseurDb();
        int idFr = fournisseurDb.takeId(nomFr);

        try (Connection connection = ConnectionDB.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT SUM(qte) AS nbPro FROM produit WHERE idFr=?");
             ResultSet resultSet = statement.executeQuery()) {

            statement.setInt(1, idFr);

            if (resultSet.next()) {
                nb = resultSet.getInt("nbPro");
            }
        } catch (SQLException e) {
           System.out.println("Error retrieving product count for supplier: {}"+ nomFr + e);
        }

        return nb;
    }
    public int nbProduitTypeFournisseur(String nomFr) throws SQLException {
        int nb = 0;
        FournisseurDb fournisseurDb = new FournisseurDb();
        int idFr = fournisseurDb.takeId(nomFr);

        try (Connection connection = ConnectionDB.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(idPro) AS nbPro FROM produit WHERE idFr=?");
             ResultSet resultSet = statement.executeQuery()) {

            statement.setInt(1, idFr);

            if (resultSet.next()) {
                nb = resultSet.getInt("nbPro");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving product count for supplier: {}"+ nomFr + e);
        }

        return nb;
    }
    //nb produit total / categorie
    public int nbProduitQteCategorie(String categorie) throws SQLException {
        int nb = 0;
        try (Connection connection = ConnectionDB.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT SUM(qte) AS nbPro FROM produit WHERE categorie=?");
             ResultSet resultSet = statement.executeQuery()) {

            statement.setString(1, categorie);

            if (resultSet.next()) {
                nb = resultSet.getInt("nbPro");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving product count for supplier: {}"+ categorie+ e);
        }

        return nb;
    }
    public int nbProduitTypeCategorie(String categorie) throws SQLException {
        int nb = 0;
        try (Connection connection = ConnectionDB.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(idPro) AS nbPro FROM produit WHERE categorie=?");
             ResultSet resultSet = statement.executeQuery()) {

            statement.setString(1, categorie);

            if (resultSet.next()) {
                nb = resultSet.getInt("nbPro");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving product count for supplier: {}"+ categorie+ e);
        }

        return nb;
    }
    //recherche produit par designation, categorie
    public List<Produit> recherche(String recherche) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try( PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit WHERE design like ? OR categorie like ?  ORDER by design ASC");
        ){
        statement.setString(1, "%" + recherche + "%");
        statement.setString(2, "%" + recherche + "%");
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idPro= resultSet.getInt("idPro");
            String design=resultSet.getString("design");
            int prix= resultSet.getInt("prix");
            String descri=resultSet.getString("descri");
            int qte= resultSet.getInt("qte");
            String categorie=resultSet.getString("categorie");
            int nbClic= resultSet.getInt("nbClic");
            //Blob imgPro=resultSet.getBlob("imgPro");
            byte[] imgPro=resultSet.getBytes("imgPro");
            int idFr= resultSet.getInt("idFr");
            String dateAjout=resultSet.getString("dateAjout");
            produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
            resultSet.close();
            statement.close();
        }
        }
        catch (Exception e){
            System.out.println(e);
        }

        return produits;
    }
    //nb Type Produits total
    public int nbProduitType() throws SQLException {
        int nb = 0;

        try (Connection connection = ConnectionDB.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) AS nbProduit FROM produit");
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                nb = resultSet.getInt("nbProduit");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving produit count"+ e);
        }
        return nb;
    }
    //nb  Produits total
    public int nbProduit() throws SQLException {
        int nb = 0;

        try (Connection connection = ConnectionDB.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT SUM(qte) AS nbProduit FROM produit");
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                nb = resultSet.getInt("nbProduit");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving produit count"+ e);
        }
        return nb;
    }
    //filtre entre deux dates
    public List<Produit> filtre2Date(String date1, String date2) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try( PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit WHERE dateAjout >= ? AND dateAjout <= ? ORDER BY dateAjout DESC;");
        ){

        statement.setString(1,  date1 );
        statement.setString(2,  date2 );
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idPro= resultSet.getInt("idPro");
            String design=resultSet.getString("design");
            int prix= resultSet.getInt("prix");
            String descri=resultSet.getString("descri");
            int qte= resultSet.getInt("qte");
            String categorie=resultSet.getString("categorie");
            int nbClic= resultSet.getInt("nbClic");
            //Blob imgPro=resultSet.getBlob("imgPro");
            byte[] imgPro=resultSet.getBytes("imgPro");
            int idFr= resultSet.getInt("idFr");
            String dateAjout=resultSet.getString("dateAjout");
            produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
        }
        resultSet.close();
        statement.close();

        }
        catch (Exception e){
            throw e;
        }
        return produits;
    }
    //filtre date
    public List<Produit> filtreDate(String date) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try( PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit WHERE dateAjout = ? ORDER BY dateAjout DESC;");
        ){

       statement.setString(1, "%" + date + "%");
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idPro= resultSet.getInt("idPro");
            String design=resultSet.getString("design");
            int prix= resultSet.getInt("prix");
            String descri=resultSet.getString("descri");
            int qte= resultSet.getInt("qte");
            String categorie=resultSet.getString("categorie");
            int nbClic= resultSet.getInt("nbClic");
            //Blob imgPro=resultSet.getBlob("imgPro");
            byte[] imgPro=resultSet.getBytes("imgPro");
            int idFr= resultSet.getInt("idFr");
            String dateAjout=resultSet.getString("dateAjout");
            produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
        }
        resultSet.close();
        statement.close();

        }
        catch (Exception e){
            throw e;
        }
        return produits;
    }
    //filtre produit ajouté en ce mois
    public List<Produit> filtreMois(String mois) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try( PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit WHERE MONTH(dateAjout)=? ORDER BY dateAjout DESC;");
        ){

         statement.setString(1,  mois );
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idPro= resultSet.getInt("idPro");
            String design=resultSet.getString("design");
            int prix= resultSet.getInt("prix");
            String descri=resultSet.getString("descri");
            int qte= resultSet.getInt("qte");
            String categorie=resultSet.getString("categorie");
            int nbClic= resultSet.getInt("nbClic");
            //Blob imgPro=resultSet.getBlob("imgPro");
            byte[] imgPro=resultSet.getBytes("imgPro");
            int idFr= resultSet.getInt("idFr");
            String dateAjout=resultSet.getString("dateAjout");
            produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
        }
        resultSet.close();
        statement.close();

        }
        catch (Exception e){
            throw e;
        }
        return produits;
    }
    //filtre en cette annee
    public List<Produit> filtreAnnee(String annee) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try(PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit WHERE YEAR(dateAjout)=? ORDER BY dateAjout DESC;");
        ){

        statement.setString(1, annee);
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idPro= resultSet.getInt("idPro");
            String design=resultSet.getString("design");
            int prix= resultSet.getInt("prix");
            String descri=resultSet.getString("descri");
            int qte= resultSet.getInt("qte");
            String categorie=resultSet.getString("categorie");
            int nbClic= resultSet.getInt("nbClic");
            //Blob imgPro=resultSet.getBlob("imgPro");
            byte[] imgPro=resultSet.getBytes("imgPro");
            int idFr= resultSet.getInt("idFr");
            String dateAjout=resultSet.getString("dateAjout");
            produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
        }
        resultSet.close();
        statement.close();
        }
        catch (Exception e){
            throw e;
        }
        return produits;
    }
    //filtre mois et année
    public List<Produit> filtreMoisAnnee(String mois, String annee) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try(PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit WHERE MONTH(dateAjout)=? AND YEAR(dateAjout)=? ORDER BY dateAjout DESC;");
        ){

        statement.setString(1, mois );
        statement.setString(2,  annee);
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idPro= resultSet.getInt("idPro");
            String design=resultSet.getString("design");
            int prix= resultSet.getInt("prix");
            String descri=resultSet.getString("descri");
            int qte= resultSet.getInt("qte");
            String categorie=resultSet.getString("categorie");
            int nbClic= resultSet.getInt("nbClic");
            //Blob imgPro=resultSet.getBlob("imgPro");
            byte[] imgPro=resultSet.getBytes("imgPro");
            int idFr= resultSet.getInt("idFr");
            String dateAjout=resultSet.getString("dateAjout");
            produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
        }
        resultSet.close();
        statement.close();

        }
        catch (Exception e){
            throw e;
        }
        return produits;
    }
    //filtre par fournisseur
    public List<Produit> filtreFournisseur(String nomFr) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try( PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit WHERE idFr=? ORDER BY dateAjout DESC;");
        ){

       FournisseurDb fournisseurDb=new FournisseurDb();
        int id=fournisseurDb.takeId(nomFr);
        statement.setInt(1, id );
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idPro= resultSet.getInt("idPro");
            String design=resultSet.getString("design");
            int prix= resultSet.getInt("prix");
            String descri=resultSet.getString("descri");
            int qte= resultSet.getInt("qte");
            String categorie=resultSet.getString("categorie");
            int nbClic= resultSet.getInt("nbClic");
            //Blob imgPro=resultSet.getBlob("imgPro");
            byte[] imgPro=resultSet.getBytes("imgPro");
            int idFr= resultSet.getInt("idFr");
            String dateAjout=resultSet.getString("dateAjout");
            produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
        }
        resultSet.close();
        statement.close();

        }
        catch (Exception e){
            throw e;
        }
        return produits;
    }
    //filtre categorie
    public List<Produit> filtreCategorie(String categ) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try( PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit WHERE categorie=? ORDER BY dateAjout DESC;");
        ){

        statement.setString(1,  categ);
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idPro= resultSet.getInt("idPro");
            String design=resultSet.getString("design");
            int prix= resultSet.getInt("prix");
            String descri=resultSet.getString("descri");
            int qte= resultSet.getInt("qte");
            String categorie=resultSet.getString("categorie");
            int nbClic= resultSet.getInt("nbClic");
            //Blob imgPro=resultSet.getBlob("imgPro");
            byte[] imgPro=resultSet.getBytes("imgPro");
            int idFr= resultSet.getInt("idFr");
            String dateAjout=resultSet.getString("dateAjout");
            produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
        }
        resultSet.close();
        statement.close();
        }
        catch (Exception e){
            throw e;
        }
        return produits;
    }
    //filtre entre deux prix
    public List<Produit> filtre2Prix(int prix1, int prix2) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try(PreparedStatement statement= connection.prepareStatement("SELECT * FROM produit WHERE prix >= ? AND prix <= ? ORDER BY dateAjout DESC;");
        ){

        statement.setInt(1, prix1);
        statement.setInt(2,prix2);
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idPro= resultSet.getInt("idPro");
            String design=resultSet.getString("design");
            int prix= resultSet.getInt("prix");
            String descri=resultSet.getString("descri");
            int qte= resultSet.getInt("qte");
            String categorie=resultSet.getString("categorie");
            int nbClic= resultSet.getInt("nbClic");
            //Blob imgPro=resultSet.getBlob("imgPro");
            byte[] imgPro=resultSet.getBytes("imgPro");
            int idFr= resultSet.getInt("idFr");
            String dateAjout=resultSet.getString("dateAjout");
            produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
        }
        resultSet.close();
        statement.close();

        }
        catch (Exception e){
            throw e;
        }
        return produits;
    }
    //filtre categorie & between 2 prix
    public List<Produit> filterCategoriePrix(String categ, int prixMin, int prixMax) throws SQLException {
        List<Produit> produits = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM produit WHERE categorie = ? AND prix >= ? AND prix <= ? ORDER BY prix ASC");) {

            statement.setString(1, categ);
            statement.setInt(2, prixMin);
            statement.setInt(3, prixMax);
            ResultSet resultSet = statement.executeQuery();


            while (resultSet.next()) {
                int idPro= resultSet.getInt("idPro");
                String design=resultSet.getString("design");
                int prix= resultSet.getInt("prix");
                String descri=resultSet.getString("descri");
                int qte= resultSet.getInt("qte");
                String categorie=resultSet.getString("categorie");
                int nbClic= resultSet.getInt("nbClic");
                //Blob imgPro=resultSet.getBlob("imgPro");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int idFr= resultSet.getInt("idFr");
                String dateAjout=resultSet.getString("dateAjout");
                produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));

            }
        }
        catch (Exception e){
            throw e;
        }
        return produits;
    }

    //filtre categorie & between 2 prix & month
    public List<Produit> filterByCategoriePrixMois(String categ, int prixMin, int prixMax, String mois) throws SQLException {
        List<Produit> produits = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM produit " +
                        "WHERE categorie = ? AND prix >= ? AND prix <= ? AND MONTH(dateAjout) = ? " +
                        "ORDER BY prix ASC");
            ) {

            statement.setString(1, categ);
            statement.setInt(2, prixMin);
            statement.setInt(3, prixMax);
            statement.setString(4, mois);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idPro= resultSet.getInt("idPro");
                String design=resultSet.getString("design");
                int prix= resultSet.getInt("prix");
                String descri=resultSet.getString("descri");
                int qte= resultSet.getInt("qte");
                String categorie=resultSet.getString("categorie");
                int nbClic= resultSet.getInt("nbClic");
                //Blob imgPro=resultSet.getBlob("imgPro");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int idFr= resultSet.getInt("idFr");
                String dateAjout=resultSet.getString("dateAjout");
                produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));

            }
        } catch (Exception e){
            throw e;
        }
        return produits;
    }

    //filtre categorie & between 2 prix & year
    public List<Produit> filterByCategoriePrixAnnee(String categ, int prixMin, int prixMax, String annee) throws SQLException {
        List<Produit> produits = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM produit " +
                        "WHERE categorie = ? AND prix >= ? AND prix <= ? AND YEAR(dateAjout) = ? " +
                        "ORDER BY prix ASC");
             ) {

            statement.setString(1, categ);
            statement.setInt(2, prixMin);
            statement.setInt(3, prixMax);
            statement.setString(4, annee);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idPro= resultSet.getInt("idPro");
                String design=resultSet.getString("design");
                int prix= resultSet.getInt("prix");
                String descri=resultSet.getString("descri");
                int qte= resultSet.getInt("qte");
                String categorie=resultSet.getString("categorie");
                int nbClic= resultSet.getInt("nbClic");
                //Blob imgPro=resultSet.getBlob("imgPro");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int idFr= resultSet.getInt("idFr");
                String dateAjout=resultSet.getString("dateAjout");
                produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));

            }
        } catch (Exception e){
            throw e;
        }
        return produits;
    }
    //filtre categorie prix fournisseur
    public List<Produit> filterByCategoriePrixFournisseur(String categ, int prixMin, int prixMax, String fournis) throws SQLException {
        List<Produit> produits = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM produit " +
                        "WHERE categorie = ? AND prix >= ? AND prix <= ? AND idFr = ? " +
                        "ORDER BY prix ASC");
           ) {
            FournisseurDb fournisseurDb=new FournisseurDb();
            int idFournis=fournisseurDb.takeId(fournis);
            statement.setString(1, categ);
            statement.setInt(2, prixMin);
            statement.setInt(3, prixMax);
            statement.setInt(4, idFournis);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idPro= resultSet.getInt("idPro");
                String design=resultSet.getString("design");
                int prix= resultSet.getInt("prix");
                String descri=resultSet.getString("descri");
                int qte= resultSet.getInt("qte");
                String categorie=resultSet.getString("categorie");
                int nbClic= resultSet.getInt("nbClic");
                //Blob imgPro=resultSet.getBlob("imgPro");
                byte[] imgPro=resultSet.getBytes("imgPro");;
                int idFr= resultSet.getInt("idFr");
                String dateAjout=resultSet.getString("dateAjout");
                produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));

            }
        } catch (Exception e){
            throw e;
        }
        return produits;
    }

    //pagination
    public List<Produit> page(int nb, int pageSize) throws SQLException {
        List<Produit> produits = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM produit ORDER BY design DESC LIMIT ?, ?");
            ) {

            int offset = (nb - 1) * pageSize;
            statement.setInt(1, offset);
            statement.setInt(2, pageSize);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idPro= resultSet.getInt("idPro");
                String design=resultSet.getString("design");
                int prix= resultSet.getInt("prix");
                String descri=resultSet.getString("descri");
                int qte= resultSet.getInt("qte");
                String categorie=resultSet.getString("categorie");
                int nbClic= resultSet.getInt("nbClic");
                //Blob imgPro=resultSet.getBlob("imgPro");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int idFr= resultSet.getInt("idFr");
                String dateAjout=resultSet.getString("dateAjout");
                produits.add(new Produit(idPro,design,prix,descri,qte,categorie,nbClic,imgPro,idFr,dateAjout));
            }
        } catch (Exception e){
            throw e;
        }
        return produits;
    }
    //create
    public void insertProduit(Produit produit) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();
        try (PreparedStatement statement=conn.prepareStatement("INSERT INTO produit(design, prix, descri, qte, categorie, nbClic, imgPro,idFr,dateAjout) VALUE(?,?,?,?,?,?,?,?,?)")) {
            statement.setString(1, produit.getDesign());
            statement.setInt(2,produit.getPrix());
            statement.setString(3,produit.getDescri());
            statement.setInt(4,produit.getQte());
            statement.setString(5,produit.getCategorie());
            statement.setInt(6,produit.getNbClic());
            statement.setBytes(7,produit.getImgPro());
            statement.setInt(8,produit.getIdFr());
            statement.setString(9,produit.getDateAjout());
            statement.executeUpdate();
            statement.close();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    //delete
    public void deleteProduit(int id) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();
        String delete="DELETE FROM produit WHERE idPro=?";
        try(PreparedStatement statement=conn.prepareStatement(delete);){
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    //update
    public void updateProduit(Produit produit) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE produit SET design=?, prix = ?, descri = ?, qte = ? categorie=?, nbClic=?, imgPro=?, idFr=?, dateAjout=? WHERE idPro = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,produit.getDesign());
            statement.setInt(2,produit.getPrix());
            statement.setString(3, produit.getDescri());
            statement.setInt(4,produit.getQte());
            statement.setString(5,produit.getCategorie());
            statement.setInt(6,produit.getNbClic());
            statement.setBytes(7,produit.getImgPro());
            statement.setInt(8,produit.getIdFr());
            statement.setString(9,produit.getDateAjout());
            statement.setInt(10,produit.getIdPro());
            statement.executeUpdate();
        } catch (Exception e){
            throw e;
        }
    }
    //update design
    public void updateFournisseurDesign(String design, int idPro) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE produit SET design=? WHERE idPro = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,design);
            statement.setInt(2,idPro);
            statement.executeUpdate();
        } catch (Exception e){
            throw e;
        }
    }
    //update prix
    public void updateFournisseurPrix(int prix, int idPro) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE produit SET prix=? WHERE idPro = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setInt(1,prix);
            statement.setInt(2,idPro);
            statement.executeUpdate();
        } catch (Exception e){
            throw e;
        }
    }
    //update descri
    public void updateFournisseurDescri(String descri, int idPro) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE produit SET descri=? WHERE idPro = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,descri);
            statement.setInt(2,idPro);
            statement.executeUpdate();
        } catch (Exception e){
            throw e;
        }
    }
    //update qte
    public void updateFournisseurQte(int qte, int idPro) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE produit SET qte=? WHERE idPro = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setInt(1,qte);
            statement.setInt(2,idPro);
            statement.executeUpdate();
        } catch (Exception e){
            throw e;
        }
    }

    //update categorie
    public void updateFournisseurCategorie(String categorie, int idPro) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE produit SET categorie=? WHERE idPro = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,categorie);
            statement.setInt(2,idPro);
            statement.executeUpdate();
        } catch (Exception e){
            throw e;
        }
    }
    //update nbClic
    public void updateFournisseurNbClic(int nbClic, int idPro) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE produit SET nbClic=? WHERE idPro = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setInt(1,nbClic);
            statement.setInt(2,idPro);
            statement.executeUpdate();
        } catch (Exception e){
            throw e;
        }
    }
    //update imgPro
    public void updateFournisseurImgPro(byte[] imgPro, int idPro) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE produit SET imgPro=? WHERE idPro = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setBytes(1,imgPro);
            statement.setInt(2,idPro);
            statement.executeUpdate();
        } catch (Exception e){
            throw e;
        }
    }
    //update dateAjout
    public void updateFournisseurDate(String date, int idPro) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE produit SET dateAjout=? WHERE idPro = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,date);
            statement.setInt(2,idPro);
            statement.executeUpdate();
        } catch (Exception e){
            throw e;
        }
    }

}