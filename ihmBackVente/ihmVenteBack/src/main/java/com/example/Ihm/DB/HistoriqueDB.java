package com.example.Ihm.DB;

import com.example.Ihm.models.Client;
import com.example.Ihm.models.Historique;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoriqueDB {
    public List<Historique> selectHistorique(int id) throws SQLException {
        List<Historique> historiques=new ArrayList<>();
        ConnectionDB connectionDB=new ConnectionDB();
        Connection connection= connectionDB.connect();
        PreparedStatement statement= connection.prepareStatement("SELECT a.idCli, p.design AS Produit, f.nomFr AS Compagnie, a.qteAchat AS Quantite, a.qteAchat * p.prix AS Prix, a.dateAchat AS Date, p.imgPro as img FROM achat a JOIN produit p ON a.idPro = p.idPro JOIN fournisseur f ON a.idFr = f.idFr WHERE a.idCli=? ORDER BY a.dateAchat DESC");
        statement.setInt(1,id);
        ResultSet resultSet=statement.executeQuery();
        while(resultSet.next()){
            String produit= resultSet.getString("Produit");
            String compagnie= resultSet.getString("Compagnie");
            int prix=resultSet.getInt("Prix");
            int quantite=resultSet.getInt("Quantite");
            String date=resultSet.getString("Date");
            byte[] img=resultSet.getBytes("img");
            historiques.add(new Historique(produit,compagnie,prix,quantite,date,img));
        }
        resultSet.close();
        statement.close();
        return historiques;
    }
}
