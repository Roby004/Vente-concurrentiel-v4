package com.example.Ihm.DB;

import com.example.Ihm.models.produitDashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class produitDashboardDB {
    public List<produitDashboard> selectProduitDash() throws SQLException {
        List<produitDashboard> produitsD=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try(PreparedStatement statement= connection.prepareStatement("SELECT p.idPro,p.idFr, p.imgPro, p.design, f.nomFr, COUNT(*) AS nb_ventes FROM produit p JOIN achat a ON p.idPro = a.idPro JOIN fournisseur f ON a.idFr = f.idFr WHERE a.dateAchat >= DATE_SUB(CURRENT_DATE(), INTERVAL 1 MONTH) GROUP BY p.idPro, p.imgPro, p.design, f.nomFr ORDER BY nb_ventes ASC")){
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                int idPro= resultSet.getInt("idPro");
                int idFr=resultSet.getInt("idFr");
                String design=resultSet.getString("design");
                byte[] imgPro=resultSet.getBytes("imgPro");
                String nomFr=resultSet.getString("nomFr");
                produitsD.add(new produitDashboard(idPro,design,nomFr,idFr,imgPro));
            }
            resultSet.close();
            statement.close();
        }
        catch (Exception e){
            System.out.println(e);
        }


        return produitsD;
    }
    public List<produitDashboard> selectProduitGraphe(String tri) throws SQLException {
        List<produitDashboard> produitsD=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try(PreparedStatement statement= connection.prepareStatement("select p.design as label, SUM(a.qteAchat) as value FROM produit p JOIN achat a WHERE a.idPro=p.idPro AND p.categorie=? GROUP BY label LIMIT 6")){
            statement.setString(1,tri);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
               String label=resultSet.getString("label");
               int value=resultSet.getInt("value");
                produitsD.add(new produitDashboard(label,value));
            }
            resultSet.close();
            statement.close();
        }
        catch (Exception e){
            System.out.println(e);
        }


        return produitsD;
    }
}
