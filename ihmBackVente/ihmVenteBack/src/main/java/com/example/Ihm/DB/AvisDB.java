package com.example.Ihm.DB;

import com.example.Ihm.models.Avis;
import com.example.Ihm.models.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvisDB {
    //select
    public List<Avis> selectAvis() throws SQLException {
        List<Avis> avisList=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT * FROM avis");

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idCli= resultSet.getInt("idCli");
            int idPro= resultSet.getInt("idPro");
            String commentaire=resultSet.getString("commentaire");
            double vote= resultSet.getDouble("vote");
            String dateAvis=resultSet.getString("dateAvis");
            avisList.add(new Avis(idCli,idPro,commentaire,vote,dateAvis));
        }
        resultSet.close();
        statement.close();
        return avisList;
    }
    public List<Avis> selectAvisAsc() throws SQLException {
        List<Avis> avisList=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try( PreparedStatement statement= connection.prepareStatement("SELECT * FROM avis ORDER by dateAvis ASC");
        ){

        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idCli= resultSet.getInt("idCli");
            int idPro= resultSet.getInt("idPro");
            String commentaire=resultSet.getString("commentaire");
            double vote= resultSet.getDouble("vote");
            String dateAvis=resultSet.getString("dateAvis");
            avisList.add(new Avis(idCli,idPro,commentaire,vote,dateAvis));
        }
        resultSet.close();
        statement.close();
        }
    catch (Exception e){
            System.out.println(e);
    }
        return avisList;
    }
    public List<Avis> selectAvisDesc() throws SQLException {
        List<Avis> avisList=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try( PreparedStatement statement= connection.prepareStatement("SELECT * FROM avis ORDER by dateAvis DESC");
        ){
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            int idCli= resultSet.getInt("idCli");
            int idPro= resultSet.getInt("idPro");
            String commentaire=resultSet.getString("commentaire");
            double vote= resultSet.getDouble("vote");
            String dateAvis=resultSet.getString("dateAvis");
            avisList.add(new Avis(idCli,idPro,commentaire,vote,dateAvis));
        }
        resultSet.close();
        statement.close();
        }catch (Exception e){
            System.out.println(e);
        }
        return avisList;
    }
    public List<Avis> selectAvisParProduit(int idPr) throws SQLException {
        List<Avis> avisList=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try(PreparedStatement statement= connection.prepareStatement("SELECT * FROM avis WHERE idPro=?")){
            statement.setInt(1, idPr);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                int idCli= resultSet.getInt("idCli");
                int idPro= resultSet.getInt("idPro");
                String commentaire=resultSet.getString("commentaire");
                double vote= resultSet.getDouble("vote");
                String dateAvis=resultSet.getString("dateAvis");
                avisList.add(new Avis(idCli,idPro,commentaire,vote,dateAvis));
            }
            resultSet.close();
            statement.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

        return avisList;
    }
    //create
    public void insertAvis(Avis avis) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();
        try (PreparedStatement statement=conn.prepareStatement("INSERT INTO avis(idCli, idPro, commentaire, vote, dateAvis) VALUE(?,?,?,?,?)")) {
            statement.setInt(1, avis.getIdCli());
            statement.setInt(2, avis.getIdPro());
            statement.setString(3,avis.getCommentaire());
            statement.setDouble(4, avis.getVote());
            statement.setString(5,avis.getDateAvis());
            statement.executeUpdate();
            statement.close();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    //delete
    public void deleteAvis(int idCli, int idPro) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();
        String delete="DELETE FROM avis WHERE idCli=? AND idPro=?";
        try(PreparedStatement statement=conn.prepareStatement(delete);){
            statement.setInt(1, idCli);
            statement.setInt(2,idPro);
            statement.executeUpdate();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    //update
    public void updateAvis(Avis avis) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE avis SET commentaire=?, vote = ?, dateAvis = ? WHERE idCli=? AND idPro = ?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setInt(4, avis.getIdCli());
            statement.setInt(5, avis.getIdPro());
            statement.setString(1,avis.getCommentaire());
            statement.setDouble(2, avis.getVote());
            statement.setString(3,avis.getDateAvis());
            statement.executeUpdate();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    //update commentaire
    public void updateAvisCommentaire(String commentaire, int idCli, int idPro) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE avis SET commentaire=? WHERE idCli = ? AND idPro=?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,commentaire);
            statement.setInt(2,idCli);
            statement.setInt(3,idPro);
            statement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //update vote
    public void updateAvisVote(Double vote, int idCli, int idPro) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE avis SET vote=? WHERE idCli = ? AND idPro=?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setDouble(1,vote);
            statement.setInt(2,idCli);
            statement.setInt(3,idPro);
            statement.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    //update dateAvis
    public void updateAvisDate(String date, int idCli, int idPro) throws SQLException {
        ConnectionDB conndb=new ConnectionDB();
        Connection conn=conndb.connect();

        String updateSql = "UPDATE avis SET dateAvis=? WHERE idCli = ? AND idPro=?";

        try (PreparedStatement statement = conn.prepareStatement(updateSql)) {
            statement.setString(1,date);
            statement.setInt(2,idCli);
            statement.setInt(3,idPro);
            statement.executeUpdate();
        }
    }
}
