package com.example.Ihm.DB;

import com.example.Ihm.models.Client;
import com.mysql.cj.jdbc.Blob;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDB {
    //select
    public List<Client> selectClient() throws SQLException {
        List<Client> clients=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM client");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idCli= resultSet.getInt("idCli");
            String pseudo=resultSet.getString("pseudo");
            String mdpCli=resultSet.getString("mdpCli");
            String mailCli=resultSet.getString("mailCli");
            byte[] imgCli=resultSet.getBytes("imgCLi");
            String contact=resultSet.getString("contact");
            String adresse=resultSet.getString("adresse");
            Boolean acces=resultSet.getBoolean("acces");
        clients.add(new Client(idCli, pseudo,mdpCli,mailCli,imgCli,contact,adresse,acces));
        }
        resultSet.close();
        statement.close();
        return clients;
    }
    //select client by IdCli ASC
    public List<Client> selectClientIdAsc() throws SQLException {
        List<Client> clients=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM client ORDER by idCli ASC");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idCli= resultSet.getInt("idCli");
            String pseudo=resultSet.getString("pseudo");
            String mdpCli=resultSet.getString("mdpCli");
            String mailCli=resultSet.getString("mailCli");
            //Blob imgCli=resultSet.getBlob("imgCli");
            byte[] imgCli=resultSet.getBytes("imgCLi");
            String contact=resultSet.getString("contact");
            String adresse=resultSet.getString("adresse");
            Boolean acces=resultSet.getBoolean("acces");
            clients.add(new Client(idCli, pseudo,mdpCli,mailCli,imgCli,contact,adresse,acces));
        }
        resultSet.close();
        statement.close();
        return clients;
    }
    //select client by IdCli DESC
    public List<Client> selectClientIdDesc() throws SQLException {
        List<Client> clients=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM client ORDER by idCli DESC");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idCli= resultSet.getInt("idCli");
            String pseudo=resultSet.getString("pseudo");
            String mdpCli=resultSet.getString("mdpCli");
            String mailCli=resultSet.getString("mailCli");
            //Blob imgCli=resultSet.getBlob("imgCli");
            byte[] imgCli=resultSet.getBytes("imgCLi");
            String contact=resultSet.getString("contact");
            String adresse=resultSet.getString("adresse");
            Boolean acces=resultSet.getBoolean("acces");
            clients.add(new Client(idCli, pseudo,mdpCli,mailCli,imgCli,contact,adresse,acces));
        }
        resultSet.close();
        statement.close();
        return clients;
    }
    //select client by pseudo ASC
    public List<Client> selectClientPseudoAsc() throws SQLException {
        List<Client> clients=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM client ORDER by pseudo ASC");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idCli= resultSet.getInt("idCli");
            String pseudo=resultSet.getString("pseudo");
            String mdpCli=resultSet.getString("mdpCli");
            String mailCli=resultSet.getString("mailCli");
            //Blob imgCli=resultSet.getBlob("imgCli");
            byte[] imgCli=resultSet.getBytes("imgCLi");
            String contact=resultSet.getString("contact");
            String adresse=resultSet.getString("adresse");
            Boolean acces=resultSet.getBoolean("acces");
            clients.add(new Client(idCli, pseudo,mdpCli,mailCli,imgCli,contact,adresse,acces));
        }
        resultSet.close();
        statement.close();
        return clients;
    }
    //select client by IdCli DESC
    public List<Client> selectClientPseudoDesc() throws SQLException {
        List<Client> clients=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM client ORDER by pseudo DESC");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idCli= resultSet.getInt("idCli");
            String pseudo=resultSet.getString("pseudo");
            String mdpCli=resultSet.getString("mdpCli");
            String mailCli=resultSet.getString("mailCli");
            //Blob imgCli=resultSet.getBlob("imgCli");
            byte[] imgCli=resultSet.getBytes("imgCLi");
            String contact=resultSet.getString("contact");
            String adresse=resultSet.getString("adresse");
            Boolean acces=resultSet.getBoolean("acces");
            clients.add(new Client(idCli, pseudo,mdpCli,mailCli,imgCli,contact,adresse,acces));
        }
        resultSet.close();
        statement.close();
        return clients;
    }
    //recherche par pseudo/mail/contact/adresse
    public List<Client> rechercheClient(String recherche) throws SQLException {
        List<Client> clients=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM client WHERE pseudo like ? OR mailCli like ? OR contact like ? OR adresse like ?  ORDER by pseudo DESC");
        statement.setString(1, "%" + recherche + "%");
        statement.setString(2, "%" + recherche + "%");
        statement.setString(3, "%" + recherche + "%");
        statement.setString(4, "%" + recherche + "%");
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idCli= resultSet.getInt("idCli");
            String pseudo=resultSet.getString("pseudo");
            String mdpCli=resultSet.getString("mdpCli");
            String mailCli=resultSet.getString("mailCli");
            //Blob imgCli=resultSet.getBlob("imgCli");
            byte[] imgCli=resultSet.getBytes("imgCLi");
            String contact=resultSet.getString("contact");
            String adresse=resultSet.getString("adresse");
            Boolean acces=resultSet.getBoolean("acces");
            clients.add(new Client(idCli, pseudo,mdpCli,mailCli,imgCli,contact,adresse,acces));
        }
        resultSet.close();
        statement.close();
        return clients;
    }
    
    public List<Client> selectOneClient(int id) throws SQLException {
        List<Client> clients=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM client WHERE idCli = ? ");
        statement.setInt(1, id );
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idCli= resultSet.getInt("idCli");
            String pseudo=resultSet.getString("pseudo");
            String mdpCli=resultSet.getString("mdpCli");
            String mailCli=resultSet.getString("mailCli");
            //Blob imgCli=resultSet.getBlob("imgCli");
            byte[] imgCli=resultSet.getBytes("imgCLi");
            String contact=resultSet.getString("contact");
            String adresse=resultSet.getString("adresse");
            Boolean acces=resultSet.getBoolean("acces");
            clients.add(new Client(idCli, pseudo,mdpCli,mailCli,imgCli,contact,adresse,acces));
        }
        resultSet.close();
        statement.close();
        return clients;
    }
    //nbClients total
    public int nbClient() throws SQLException {
        int nb = 0;

        try (Connection connection = ConnectionDB.connect();
             PreparedStatement statement = connection.prepareStatement("SELECT COUNT(*) AS nbClient FROM client");
             ResultSet resultSet = statement.executeQuery()) {

            if (resultSet.next()) {
                nb = resultSet.getInt("nbClient");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving client count"+ e);

        }

        return nb;
    }
    public int takeId(String pseudo) throws SQLException {
        int idCli = -1;
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement("SELECT idCli FROM client WHERE pseudo = ?");
             ResultSet resultSet = statement.executeQuery()) {

            statement.setString(1, pseudo);

            if (resultSet.next()) {
                idCli = resultSet.getInt("idCli");
            }
        }
        return idCli;
    }
    //pagination
    public List<Client> page(int nb, int pageSize) throws SQLException {
        List<Client> clients = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM client ORDER BY pseudo DESC LIMIT ?, ?");
             ResultSet resultSet = statement.executeQuery()) {

            int offset = (nb - 1) * pageSize;
            statement.setInt(1, offset);
            statement.setInt(2, pageSize);

            while (resultSet.next()) {
                int idCli = resultSet.getInt("idCli");
                String pseudo = resultSet.getString("pseudo");
                String mdpCli = resultSet.getString("mdpCli");
                String mailCli = resultSet.getString("mailCli");
                //Blob imgCli = resultSet.getBlob("imgCli");
                byte[] imgCli=resultSet.getBytes("imgCLi");
                String contact = resultSet.getString("contact");
                String adresse = resultSet.getString("adresse");
                Boolean acces = resultSet.getBoolean("acces");
                clients.add(new Client(idCli, pseudo, mdpCli, mailCli, imgCli, contact, adresse, acces));
            }
        }
        return clients;
    }
    //create
    public void insertClient(Client client) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();
        try (PreparedStatement statement=conn.prepareStatement("INSERT INTO client(pseudo, mdpCli, mailCli, imgCli,contact,adresse,acces) VALUE(?,?,?,?,?,?,?)")) {
            statement.setString(1, client.getPseudo());
            statement.setString(2, client.getMdpCli());
            statement.setString(3, client.getMailCli());
            statement.setBytes(4, client.getImgCli());
            statement.setString(5,client.getContact());
            statement.setString(6,client.getAdresse());
            statement.setBoolean(7,client.getAcces());
            statement.executeUpdate();
            statement.close();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    //delete
    public void deleteClient(int id) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();
        String delete="DELETE FROM client WHERE idCli=?";
        try(PreparedStatement statement=conn.prepareStatement(delete)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    //update
    public void updateClient(Client client) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE client SET pseudo=?, mdpCli = ?, mailCli = ?, contact=?, adresse=?, acces=? WHERE idCli = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,client.getPseudo());
            statement.setString(2, client.getMdpCli());
            statement.setString(3, client.getMailCli());
            //statement.setBytes(4, client.getImgCli());
            statement.setString(4,client.getContact());
            statement.setString(5,client.getAdresse());
            statement.setBoolean(6,client.getAcces());
            statement.setInt(7, client.getIdCli());
            statement.executeUpdate();
        }
    }
    //update pseudo
    public void updateClientPseudo(String pseudo, int idCli) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE client SET pseudo=? WHERE idCli = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,pseudo);
            statement.setInt(2,idCli);
            statement.executeUpdate();
        }
    }
    //update mdpCli
    public void updateClientMdpCli(String mdpCli, int idCli) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE client SET mdpCli=? WHERE idCli = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,mdpCli);
            statement.setInt(2,idCli);
            statement.executeUpdate();
        }
    }
    //update mailCli
    public void updateClientMailCli(String mailCli, int idCli) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE client SET mailCli=? WHERE idCli = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,mailCli);
            statement.setInt(2,idCli);
            statement.executeUpdate();
        }
    }
    //update imgCli
    public void updateClientImgCli(byte[] imgCli, int idCli) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE client SET imgCli=? WHERE idCli = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setBytes(1,imgCli);
            statement.setInt(2,idCli);
            statement.executeUpdate();
        }
    }
    //update contact
    public void updateClientContact(String contact, int idCli) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE client SET contact=? WHERE idCli = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,contact);
            statement.setInt(2,idCli);
            statement.executeUpdate();
        }
    }
    //update adresse
    public void updateClientAdresse(String adresse, int idCli) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE client SET adresse=? WHERE idCli = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,adresse);
            statement.setInt(2,idCli);
            statement.executeUpdate();
        }
    }
    //update acces
    public void updateClientAcces(Boolean acces, int idCli) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE client SET acces=? WHERE idCli = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setBoolean(1,acces);
            statement.setInt(2,idCli);
            statement.executeUpdate();
        }
    }
    //verification login
    public void loginClient(Client client){
        //pseudo, mdpCli,mailCli,imgCli,idCli
        //si pseudo, mdpCli, mailCli, imgCli == data dans bdd
    }
}
