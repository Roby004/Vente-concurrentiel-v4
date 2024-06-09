package com.example.Ihm.DB;

import com.example.Ihm.models.Achat;
import com.example.Ihm.models.AchatDashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AchatDashboardDB {
    //select
    public List<AchatDashboard> selectAchatDashboard() throws SQLException {
        List<AchatDashboard> achats=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        try( PreparedStatement statement= connection.prepareStatement("SELECT c.imgCli, f.imgFr, p.imgPro, a.qteAchat, a.dateAchat  FROM achat a LEFT JOIN produit p ON p.idPro = a.idPro LEFT JOIN client c ON c.idCli = a.idCli LEFT JOIN fournisseur f ON f.idFr = a.idFr");){
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            byte[] imgCli= resultSet.getBytes("imgCli");
            byte[] imgPro= resultSet.getBytes("imgPro");
            byte[] imgFr= resultSet.getBytes("imgFr");
            int qteAchat= resultSet.getInt("qteAchat");
            String dateAchat=resultSet.getString("dateAchat");
            achats.add(new AchatDashboard(imgCli, imgFr, imgPro, qteAchat,dateAchat));
        }
        resultSet.close();
        statement.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return achats;
    }
}
