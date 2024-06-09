package com.example.Ihm.DB;

import com.example.Ihm.models.Achat;
import com.example.Ihm.models.Avis;
import com.example.Ihm.models.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AchatDB {
    //select
    public List<Achat> selectAchat() throws SQLException {
        List<Achat> achats=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try( PreparedStatement statement= connection.prepareStatement("SELECT * FROM achat");){
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idCli= resultSet.getInt("idCli");
            int idPro= resultSet.getInt("idPro");
            int idFr= resultSet.getInt("idFr");
            int qteAchat= resultSet.getInt("qteAchat");
            String dateAchat=resultSet.getString("dateAchat");
            achats.add(new Achat(idCli, idPro, idFr, qteAchat,dateAchat));
        }
        resultSet.close();
        statement.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return achats;
    }

    public List<Achat> selectAchatAsc() throws SQLException {
        List<Achat> achats=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try( PreparedStatement statement= connection.prepareStatement("SELECT * FROM achat ORDER by dateAchat ASC");
        ){
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idCli= resultSet.getInt("idCli");
            int idPro= resultSet.getInt("idPro");
            int idFr= resultSet.getInt("idFr");
            int qteAchat= resultSet.getInt("qteAchat");
            String dateAchat=resultSet.getString("dateAchat");
            achats.add(new Achat(idCli, idPro, idFr, qteAchat,dateAchat));
        }
        resultSet.close();
        statement.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

        return achats;
    }
    public List<Achat> selectAchatDesc() throws SQLException {
        List<Achat> achats=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try(  PreparedStatement statement= connection.prepareStatement("SELECT * FROM achat ORDER by dateAchat DESC");
        ){
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idCli= resultSet.getInt("idCli");
            int idPro= resultSet.getInt("idPro");
            int idFr= resultSet.getInt("idFr");
            int qteAchat= resultSet.getInt("qteAchat");
            String dateAchat=resultSet.getString("dateAchat");
            achats.add(new Achat(idCli, idPro, idFr, qteAchat,dateAchat));
        }
        resultSet.close();
        statement.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return achats;
    }
    //qtte achat par client
    public int getQteAchat(int idCli){
        int nb=0;
        try (Connection connection = ConnectionDB.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(qteAchat) AS nbAchat FROM achat WHERE idCli=?");) {

            statement.setInt(1, idCli);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nb = resultSet.getInt("nbPro");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving product count for supplier: {}"+ idCli+ e);
        }
        return nb;

    }
   //qtte achat par produit
    public int getQteAchatProduit(int idPro){
        int nb=0;
        try (Connection connection = ConnectionDB.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(qteAchat) AS nbAchat FROM achat WHERE idPro=?");) {

            statement.setInt(1, idPro);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nb = resultSet.getInt("nbPro");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving product count for supplier: {}"+ idPro+ e);
        }
        return nb;

    }
    //qtte achat par fournisseur
    public int getQteAchatFournisseur(int idFr){
        int nb=0;
        try (Connection connection = ConnectionDB.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(qteAchat) AS nbAchat FROM achat WHERE idFr=?");
      ) {

            statement.setInt(1, idFr);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nb = resultSet.getInt("nbPro");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving product count for supplier: {}"+ idFr+ e);
        }
        return nb;

    }
    //qte achat par fournisseur produit
    public int getQteAchatFournisseurProduit(int idFr,int idPro){
        int nb=0;
        try (Connection connection = ConnectionDB.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(qteAchat) AS nbAchat FROM achat WHERE idFr=? AND idPro=?");
) {

            statement.setInt(1, idFr);
            statement.setInt(2, idPro);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                nb = resultSet.getInt("nbPro");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving product count for supplier: {}"+ idFr+ e);
        }
        return nb;
    }
    //qte achat total
    public int getNbAchatTotal(){
        int nb=0;
        try (Connection connection = ConnectionDB.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(qteAchat) AS nbAchat FROM achat");) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                nb = resultSet.getInt("nbPro");

            }
        } catch (SQLException e) {
            System.out.println("Error retrieving product count for supplier: {}"+ e);
        }
        return nb;
    }

    //create
    public void insertAchat(Achat achat) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();
        try (PreparedStatement statement=conn.prepareStatement("INSERT INTO achat(idCli, idPro, idFr, qteAchat, dateAchat) VALUE(?,?,?,?,?)")) {
            statement.setInt(1, achat.getIdCli());
            statement.setInt(2,achat.getIdPro());
            statement.setInt(3,achat.getIdFr());
            statement.setInt(4, achat.getQteAchat());
            statement.setString(5, achat.getDateAchat());
            statement.executeUpdate();
            statement.close();
            conn.close();
            ProduitDB p = new ProduitDB();
            int nbPro = p.nbParProduit(achat.getIdPro());
            int qte = nbPro-achat.getQteAchat();
            p.updateFournisseurQte(qte, achat.getIdPro());
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    //delete
    public void deleteAchat(int idCli, int idPro, int idFr) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();
        String delete="DELETE FROM achat WHERE idCli=? AND idPro=? AND idFr=?";
        try(PreparedStatement statement=conn.prepareStatement(delete);){
            statement.setInt(1, idCli);
            statement.setInt(2,idPro);
            statement.setInt(3,idFr);
            statement.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    //update
    public void updateAchat(Achat achat) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE achat SET qteAchat=?, dateAchat = ? WHERE idCli=? AND idPro = ? AND idFr=?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setInt(3, achat.getIdCli());
            statement.setInt(4,achat.getIdPro());
            statement.setInt(5,achat.getIdFr());
            statement.setInt(1, achat.getQteAchat());
            statement.setString(2, achat.getDateAchat());
            statement.executeUpdate();
        }
    }
    //update qteAchat
    public void updateAchatQte(int qte, int idCli, int idFr, int idPro) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE achat SET qteAchat=? WHERE idCli=? AND idFr=? AND idPro = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setInt(1,qte);
            statement.setInt(2,idCli);
            statement.setInt(3,idFr);
            statement.setInt(4,idPro);
            statement.executeUpdate();
        }
    }
    //MAX count(idPro) from produit
    public int produitPlusVendu() throws SQLException {
        int idPro=0;
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement("SELECT idPro, COUNT(idPro) AS nbAchats\n" +
                "FROM achat\n" +
                "GROUP BY idPro\n" +
                "ORDER BY nbAchats DESC\n" +
                "LIMIT 1;");
             ) {
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                idPro = resultSet.getInt("idPro");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        return idPro;
    }
    //produit le plus aimé -> plus de vote (moyenne vente total le plus sup)
    public int produitPlusAime() throws SQLException {
        int idPro=0;
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement("SELECT idPro, AVG(vote) AS avgVote\n" +
                "FROM avis\n" +
                "GROUP BY idPro\n" +
                "ORDER BY avgVote DESC\n" +
                "LIMIT 1;\n");
             ) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                idPro = resultSet.getInt("idPro");
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return idPro;
    }

}
