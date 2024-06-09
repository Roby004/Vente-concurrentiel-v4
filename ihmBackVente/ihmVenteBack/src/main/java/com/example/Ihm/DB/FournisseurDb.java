package com.example.Ihm.DB;

import com.example.Ihm.models.Client;
import com.example.Ihm.models.Fournisseur;
import com.mysql.cj.jdbc.Blob;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FournisseurDb {
    //select
    public List<Fournisseur> selectFournisseur() throws SQLException {
        List<Fournisseur> fournisseurs=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM fournisseur");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idFr= resultSet.getInt("idFr");
            String nomFr=resultSet.getString("nomFr");
            String mdpFr=resultSet.getString("mdpFr");
            String mailFr=resultSet.getString("mailFr");
            //Blob imgFr=resultSet.getBlob("imgFr");
            byte[] imgFr=resultSet.getBytes("imgFr");
            String contactFr=resultSet.getString("contactFr");
            String adresseFr=resultSet.getString("adresseFr");
            Boolean accesFr=resultSet.getBoolean("accesFr");
            fournisseurs.add(new Fournisseur(idFr, nomFr,mdpFr,mailFr,imgFr,contactFr,adresseFr,accesFr));
        }
        resultSet.close();
        statement.close();
        return fournisseurs;
    }
    public List<Fournisseur> selectFournisseurIdAsc() throws SQLException {
        List<Fournisseur> fournisseurs=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM fournisseur ORDER by idFr ASC");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idFr= resultSet.getInt("idFr");
            String nomFr=resultSet.getString("nomFr");
            String mdpFr=resultSet.getString("mdpFr");
            String mailFr=resultSet.getString("mailFr");
            //Blob imgFr=resultSet.getBlob("imgFr");
            byte[] imgFr=resultSet.getBytes("imgFr");
            String contactFr=resultSet.getString("contactFr");
            String adresseFr=resultSet.getString("adresseFr");
            Boolean accesFr=resultSet.getBoolean("accesFr");
            fournisseurs.add(new Fournisseur(idFr, nomFr,mdpFr,mailFr,imgFr,contactFr,adresseFr,accesFr));
        }
        resultSet.close();
        statement.close();
        return fournisseurs;
    }
    public List<Fournisseur> selectFournisseurIdDesc() throws SQLException {
        List<Fournisseur> fournisseurs=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM fournisseur ORDER by idFr DESC");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idFr= resultSet.getInt("idFr");
            String nomFr=resultSet.getString("nomFr");
            String mdpFr=resultSet.getString("mdpFr");
            String mailFr=resultSet.getString("mailFr");
            //Blob imgFr=resultSet.getBlob("imgFr");
            byte[] imgFr=resultSet.getBytes("imgFr");
            String contactFr=resultSet.getString("contactFr");
            String adresseFr=resultSet.getString("adresseFr");
            Boolean accesFr=resultSet.getBoolean("accesFr");
            fournisseurs.add(new Fournisseur(idFr, nomFr,mdpFr,mailFr,imgFr,contactFr,adresseFr,accesFr));
        }
        resultSet.close();
        statement.close();
        return fournisseurs;
    }
    public List<Fournisseur> selectFournisseurNomDesc() throws SQLException {
        List<Fournisseur> fournisseurs=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM fournisseur ORDER by nomFr DESC");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idFr= resultSet.getInt("idFr");
            String nomFr=resultSet.getString("nomFr");
            String mdpFr=resultSet.getString("mdpFr");
            String mailFr=resultSet.getString("mailFr");
            //Blob imgFr=resultSet.getBlob("imgFr");
            byte[] imgFr=resultSet.getBytes("imgFr");
            String contactFr=resultSet.getString("contactFr");
            String adresseFr=resultSet.getString("adresseFr");
            Boolean accesFr=resultSet.getBoolean("accesFr");
            fournisseurs.add(new Fournisseur(idFr, nomFr,mdpFr,mailFr,imgFr,contactFr,adresseFr,accesFr));
        }
        resultSet.close();
        statement.close();
        return fournisseurs;
    }
    public List<Fournisseur> selectFournisseurNomAsc() throws SQLException {
        List<Fournisseur> fournisseurs=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM fournisseur ORDER by nomFr ASC");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idFr= resultSet.getInt("idFr");
            String nomFr=resultSet.getString("nomFr");
            String mdpFr=resultSet.getString("mdpFr");
            String mailFr=resultSet.getString("mailFr");
           // Blob imgFr=resultSet.getBlob("imgFr");
            byte[] imgFr=resultSet.getBytes("imgFr");
            String contactFr=resultSet.getString("contactFr");
            String adresseFr=resultSet.getString("adresseFr");
            Boolean accesFr=resultSet.getBoolean("accesFr");
            fournisseurs.add(new Fournisseur(idFr, nomFr,mdpFr,mailFr,imgFr,contactFr,adresseFr,accesFr));
        }
        resultSet.close();
        statement.close();
        return fournisseurs;
    }
    //recherche par nomFr ou mailFr ou contactFr ou adresseFr
    public List<Fournisseur> recherche(String recherche) throws SQLException {
        List<Fournisseur> fournisseurs=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM fournisseur WHERE nomFr like ? OR mailFr like ? OR contactFr like ? OR adresseFr like ?  ORDER by nomFr DESC");
        statement.setString(1, "%" + recherche + "%");
        statement.setString(2, "%" + recherche + "%");
        statement.setString(3, "%" + recherche + "%");
        statement.setString(4, "%" + recherche + "%");
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idFr= resultSet.getInt("idFr");
            String nomFr=resultSet.getString("nomFr");
            String mdpFr=resultSet.getString("mdpFr");
            String mailFr=resultSet.getString("mailFr");
            //Blob imgFr=resultSet.getBlob("imgFr");
            byte[] imgFr=resultSet.getBytes("imgFr");
            String contactFr=resultSet.getString("contactFr");
            String adresseFr=resultSet.getString("adresseFr");
            Boolean accesFr=resultSet.getBoolean("accesFr");
            fournisseurs.add(new Fournisseur(idFr, nomFr,mdpFr,mailFr,imgFr,contactFr,adresseFr,accesFr));
        }
        resultSet.close();
        statement.close();
        return fournisseurs;
    }
    //nbFournisseurs total
    public int nbFournisseur() throws SQLException {
        int nb = 0;

        try (Connection connection = ConnectionDB.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) AS nbFournisseur FROM fournisseur");
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                nb = resultSet.getInt("nbFournisseur");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving fournisseur count"+ e);

        }

        return nb;
    }
    //pagination
    public List<Fournisseur> page(int nb, int pageSize) throws SQLException {
        List<Fournisseur> fournisseurs = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM fournisseur ORDER BY nomFr DESC LIMIT ?, ?");
             ResultSet resultSet = statement.executeQuery()) {

            int offset = (nb - 1) * pageSize;
            statement.setInt(1, offset);
            statement.setInt(2, pageSize);

            while (resultSet.next()) {
                int idFr= resultSet.getInt("idFr");
                String nomFr=resultSet.getString("nomFr");
                String mdpFr=resultSet.getString("mdpFr");
                String mailFr=resultSet.getString("mailFr");
                //Blob imgFr=resultSet.getBlob("imgFr");
                byte[] imgFr=resultSet.getBytes("imgFr");
                String contactFr=resultSet.getString("contactFr");
                String adresseFr=resultSet.getString("adresseFr");
                Boolean accesFr=resultSet.getBoolean("accesFr");
                fournisseurs.add(new Fournisseur(idFr, nomFr,mdpFr,mailFr,imgFr,contactFr,adresseFr,accesFr));
            }
        }
        return fournisseurs;
    }
    public int takeId(String nomFr) throws SQLException {
        int idFr = -1; // Initialize idFr to -1 (not found) by default
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();

        try (PreparedStatement statement = connection.prepareStatement("SELECT idFr FROM fournisseur WHERE nomFr = ?");)
        {
            statement.setString(1, nomFr); // Set the parameter value
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                idFr = resultSet.getInt("idFr"); // Retrieve the idFr value
            }
        } catch (SQLException e) {
            System.out.println(e); // Re-throw the SQLException for proper handling
        } finally {
            if (connection != null) {
                connection.close(); // Close the connection
            }
        }

        return idFr; // Return the retrieved idFr or -1 if not found
    }

    //create
    public void insertFournisseur(Fournisseur fournisseur) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();
        try (PreparedStatement statement=conn.prepareStatement("INSERT INTO fournisseur(nomFr,mdpFr,mailFr,imgFr,contactFr,adresseFr,accesFr) VALUE(?,?,?,?,?,?,?)")) {
            statement.setString(1, fournisseur.getNomFr());
            statement.setString(2,fournisseur.getMdpFr());
            statement.setString(3,fournisseur.getMailFr());
            statement.setBytes(4, fournisseur.getImgFr());
            statement.setString(5,fournisseur.getContactFr());
            statement.setString(6,fournisseur.getAdresseFr());
            statement.setBoolean(7,fournisseur.getAccesFr());

            statement.executeUpdate();
            statement.close();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    //delete
    public void deleteFournisseur(int id) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();
        String delete="DELETE FROM fournisseur WHERE idFr=?";
        try(PreparedStatement statement=conn.prepareStatement(delete);){
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    //update
    public void updateFournisseur(Fournisseur fournisseur) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE fournisseur SET nomFr=?, mdpFr = ?, mailFr = ?, imgFr = ?,contactFr=?, adresseFr=?, accesFr=? WHERE idFr = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1, fournisseur.getNomFr());
            statement.setString(2,fournisseur.getMdpFr());
            statement.setString(3,fournisseur.getMailFr());
            statement.setBytes(4,fournisseur.getImgFr());
            statement.setString(5,fournisseur.getContactFr());
            statement.setString(6,fournisseur.getAdresseFr());
            statement.setBoolean(7,fournisseur.getAccesFr());
            statement.setInt(8,fournisseur.getIdFr());
            statement.executeUpdate();
        }
    }
    //update nomFr
    public void updateFournisseurNom(String nomFr, int idFr) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE fournisseur SET nomFr=? WHERE idFr = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,nomFr);
            statement.setInt(2,idFr);
            statement.executeUpdate();
        }
    }
    //update nmdpFr
    public void updateFournisseurMdp(String mdpFr, int idFr) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE fournisseur SET mdpFr=? WHERE idFr = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,mdpFr);
            statement.setInt(2,idFr);
            statement.executeUpdate();
        }
    }
    //update mailFr
    public void updateFournisseurMail(String mailFr, int idFr) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE fournisseur SET mailFr=? WHERE idFr = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,mailFr);
            statement.setInt(2,idFr);
            statement.executeUpdate();
        }
    }
    //update imgFr
    public void updateFournisseurImg(byte[] imgFr, int idFr) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE fournisseur SET imgFr=? WHERE idFr = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setBytes(1,imgFr);
            statement.setInt(2,idFr);
            statement.executeUpdate();
        }
    }
    //update contactFr
    public void updateFournisseurContact(String contactFr, int idFr) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE fournisseur SET contactFr=? WHERE idFr = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,contactFr);
            statement.setInt(2,idFr);
            statement.executeUpdate();
        }
    }
    //update adresseFr
    public void updateFournisseurAdresse(String adresseFr, int idFr) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE fournisseur SET adresseFr=? WHERE idFr = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,adresseFr);
            statement.setInt(2,idFr);
            statement.executeUpdate();
        }
    }
    //update accesFr
    public void updateFournisseurAcces(Boolean accesFr, int idFr) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE fournisseur SET accesFr=? WHERE idFr = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setBoolean(1,accesFr);
            statement.setInt(2,idFr);
            statement.executeUpdate();
        }
    }
    //verification login
    public void loginFournisseur(Fournisseur fournisseur){
    }
}
