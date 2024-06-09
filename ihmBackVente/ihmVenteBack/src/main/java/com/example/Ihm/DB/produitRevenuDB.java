package com.example.Ihm.DB;

import com.example.Ihm.models.produitDashboard;
import com.example.Ihm.models.produitRevenu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class produitRevenuDB {
public List<produitRevenu> selectProduitRevenue(int year) throws SQLException {
        List<produitRevenu> produitsD=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try(PreparedStatement statement= connection.prepareStatement("SELECT MONTH(a.dateAchat) AS mois, YEAR(a.dateAchat) AS annee, SUM(p.prix * a.qteAchat) AS revenue FROM produit p JOIN achat a ON p.idPro = a.idPro WHERE YEAR(a.dateAchat) = ? GROUP BY MONTH(a.dateAchat) ORDER BY mois ASC")){
        	statement.setInt(1, year);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
               String mois=resultSet.getString("mois");
                String annee=resultSet.getString("annee");
                int revenue=resultSet.getInt("revenue");
                produitsD.add(new produitRevenu(mois,annee,revenue));
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
