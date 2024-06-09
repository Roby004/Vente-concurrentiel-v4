package com.example.Ihm.controllers;

import com.example.Ihm.DB.AvisDB;
import com.example.Ihm.models.Avis;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value="/avis")
public class AvisController {

    @GetMapping(value = "/avis")
    public List<Avis> getAvis() throws SQLException {
        List<Avis> avisList=new ArrayList<>();
        AvisDB avisdb=new AvisDB();
        avisList=avisdb.selectAvis();
        return avisList;
    }
    @GetMapping(value = "/avisAsc")
    public List<Avis> getAvisAsc() throws SQLException {
        List<Avis> avisList=new ArrayList<>();
        AvisDB avisdb=new AvisDB();
        avisList=avisdb.selectAvisAsc();
        return avisList;
    }
    @GetMapping(value = "/avisDesc")
    public List<Avis> getAvisDesc() throws SQLException {
        List<Avis> avisList=new ArrayList<>();
        AvisDB avisdb=new AvisDB();
        avisList=avisdb.selectAvisDesc();
        return avisList;
    }
    @GetMapping(value = "/avisParProduit/{idPr}")
    public  List<Avis> getAvisParProduit(@PathVariable int idPr) throws SQLException {
        List<Avis> avisList=new ArrayList<>();
        AvisDB avisdb=new AvisDB();
        avisList=avisdb.selectAvisParProduit(idPr);
        return avisList;
    }
    @PostMapping(value= "/avisPost")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createAvis(@RequestBody Avis avis) throws SQLException {
        AvisDB avisDB = new AvisDB();
        try {
            avisDB.insertAvis(avis);
            return ResponseEntity.ok("Avis créé avec succès!");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de la création de l avis!");
        }
    }

    @PutMapping(value = "/avisPut")
    public ResponseEntity<String> setAvis(@RequestBody  Avis avis){
        AvisDB avisDB=new AvisDB();
        try{
            avisDB.updateAvis(avis);
            return ResponseEntity.ok("update avis réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update avis!");
        }

    }
    @PutMapping(value = "/avisPutCommentaire/{commentaire}/{idCli}/{idPro}")
    public ResponseEntity<String> setAvisCommentaire(@PathVariable String commentaire,@PathVariable int idCli, @PathVariable int idPro){
        AvisDB avisDB=new AvisDB();
        try{
            avisDB.updateAvisCommentaire(commentaire,idCli,idPro);
            return ResponseEntity.ok("update avis réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update avis!");
        }

    }
    @PutMapping(value = "/avisPutVote/{vote}/{idCli}/{idPro}")
    public ResponseEntity<String> setAvisCommentaire(@PathVariable double vote,@PathVariable int idCli, @PathVariable int idPro){
        AvisDB avisDB=new AvisDB();
        try{
            avisDB.updateAvisVote(vote,idCli,idPro);
            return ResponseEntity.ok("update avis réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update avis!");
        }

    }

    @PutMapping(value = "/avisPutDate/{date}/{idCli}/{idPro}")
    public ResponseEntity<String> setAvisDate(@PathVariable String date,@PathVariable int idCli, @PathVariable int idPro){
        AvisDB avisDB=new AvisDB();
        try{
            avisDB.updateAvisDate(date,idCli,idPro);
            return ResponseEntity.ok("update avis réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update avis!");
        }

    }

    @DeleteMapping(value = "/avisDelete/{idCli}/{idPro}")
    public  ResponseEntity<String> deleteAvis(@PathVariable int idCli, @PathVariable int idPro) throws SQLException {
        AvisDB avisDB=new AvisDB();
        try{
            avisDB.deleteAvis(idCli,idPro);
            return ResponseEntity.ok("delete avis réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de delete avis!");
        }
    }

}
