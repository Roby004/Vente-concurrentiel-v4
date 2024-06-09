package com.example.Ihm.controllers;

import com.example.Ihm.DB.AchatDB;
import com.example.Ihm.models.Achat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value="/achat")
public class AchatController {

     @GetMapping(value = "/achats")
    public List<Achat> getAchat() throws SQLException {
        List<Achat> achats=new ArrayList<>();
        AchatDB achatdb=new AchatDB();
        achats=achatdb.selectAchat();
        return achats;
    }

    @GetMapping(value = "/achatsAsc")
    public List<Achat> getAchatAsc() throws SQLException {
        List<Achat> achats=new ArrayList<>();
        AchatDB achatdb=new AchatDB();
        achats=achatdb.selectAchatAsc();
        return achats;
    }
    @GetMapping(value = "/achatsDesc")
    public List<Achat> getAchatDesc() throws SQLException {
        List<Achat> achats=new ArrayList<>();
        AchatDB achatdb=new AchatDB();
        achats=achatdb.selectAchatDesc();
        return achats;
    }
    @GetMapping(value = "/achatsQteParClient/{idCli}")
    public int getAchatQteParClient(@PathVariable int idCli) throws SQLException {
        AchatDB achatdb=new AchatDB();
        int nbAchat=achatdb.getQteAchat(idCli);
        return nbAchat;
    }
    @GetMapping(value = "/achatsQteParProduit/{idPro}")
    public int getAchatQteParProduit(@PathVariable int idPro) throws SQLException {
        AchatDB achatdb=new AchatDB();
        int nbAchat=achatdb.getQteAchatProduit(idPro);
        return nbAchat;
    }
    @GetMapping(value = "/achatsQteParFournisseur/{idFr}")
    public int getAchatQteParFournisseur(@PathVariable int idFr) throws SQLException {
        AchatDB achatdb=new AchatDB();
        int nbAchat=achatdb.getQteAchatFournisseur(idFr);
        return nbAchat;
    }
    @GetMapping(value = "/achatsQteParFournisseurProduit/{idFr}/{idPro}")
    public int getAchatQteParFournisseuProduitr(@PathVariable int idFr,@PathVariable int idPro) throws SQLException {
        AchatDB achatdb=new AchatDB();
        int nbAchat=achatdb.getQteAchatFournisseurProduit(idFr,idPro);
        return nbAchat;
    }
    @GetMapping(value = "/achatsTotal")
    public int getAchatTotal() throws SQLException {
        AchatDB achatdb=new AchatDB();
        int nbAchat=achatdb.getNbAchatTotal();
        return nbAchat;
    }
    @GetMapping(value = "/produitPlusVendu")
    public int getProduitPlusVendu() throws SQLException {
        AchatDB achatdb=new AchatDB();
        int idPro=achatdb.produitPlusVendu();
        return idPro;
    }
    @GetMapping(value = "/produitPlusAime")
    public int getProduitPlusAime() throws SQLException {
        AchatDB achatdb=new AchatDB();
        int idPro=achatdb.produitPlusAime();
        return idPro;
    }
    @PostMapping(value= "/achatsPost")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createAchats(@RequestBody Achat achat) throws SQLException {
        AchatDB achatDB = new AchatDB();
        try {
            achatDB.insertAchat(achat);
            return ResponseEntity.ok("Achat créé avec succès!");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de la création de l achat!");
        }
    }

    @PutMapping(value = "/achatsPut")
    public ResponseEntity<String> setAchat(@RequestBody  Achat achat){
        AchatDB achatDB=new AchatDB();
        try{
            achatDB.updateAchat(achat);
            return ResponseEntity.ok("update achat réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update achat!");
        }

    }
    @PutMapping(value="/achatsPutQteAchat/{qte}/{idCli}/{idFr}/{idPro}")
    public ResponseEntity<String> setQteAchat(@PathVariable int qte,@PathVariable int idCli,@PathVariable int idFr,@PathVariable int idPro){
        AchatDB achatDB=new AchatDB();
        try{
            achatDB.updateAchatQte(qte,idCli,idFr,idPro);
            return ResponseEntity.ok("update  réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update!");
        }

    }
    @DeleteMapping(value = "/achatDelete/{idCli}/{idPro}/{idFr}")
    public  ResponseEntity<String> deleteAchat(@PathVariable int idCli, @PathVariable int idPro,@PathVariable int idFr) throws SQLException {
        AchatDB achatDB=new AchatDB();
        try{
            achatDB.deleteAchat(idCli,idPro,idFr);
            return ResponseEntity.ok("delete achat réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de delete achat!");
        }
    }
}
