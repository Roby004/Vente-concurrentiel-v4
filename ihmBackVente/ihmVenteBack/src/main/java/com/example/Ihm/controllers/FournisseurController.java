package com.example.Ihm.controllers;

import com.example.Ihm.DB.ClientDB;
import com.example.Ihm.DB.FournisseurDb;
import com.example.Ihm.models.Fournisseur;
import com.mysql.cj.jdbc.Blob;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value="/fournisseur")
public class FournisseurController {

    @GetMapping(value = "/fournisseurs")
    public List<Fournisseur> getFournisseur() throws SQLException {
        List<Fournisseur> fournisseurs=new ArrayList<>();
        FournisseurDb fournisseurDb=new FournisseurDb();
        fournisseurs=fournisseurDb.selectFournisseur();
        return fournisseurs;
    }
    @GetMapping(value = "/fournisseursIdAsc")
    public List<Fournisseur> getFournisseurIdAsc() throws SQLException {
        List<Fournisseur> fournisseurs=new ArrayList<>();
        FournisseurDb fournisseurDb=new FournisseurDb();
        fournisseurs=fournisseurDb.selectFournisseurIdAsc();
        return fournisseurs;
    }
    @GetMapping(value = "/fournisseursIdDesc")
    public List<Fournisseur> getFournisseurIdDesc() throws SQLException {
        List<Fournisseur> fournisseurs=new ArrayList<>();
        FournisseurDb fournisseurDb=new FournisseurDb();
        fournisseurs=fournisseurDb.selectFournisseurIdDesc();
        return fournisseurs;
    }
    @GetMapping(value = "/fournisseursNomAsc")
    public List<Fournisseur> getFournisseurNomAsc() throws SQLException {
        List<Fournisseur> fournisseurs=new ArrayList<>();
        FournisseurDb fournisseurDb=new FournisseurDb();
        fournisseurs=fournisseurDb.selectFournisseurNomAsc();
        return fournisseurs;
    }
    @GetMapping(value = "/fournisseursNomDesc")
    public List<Fournisseur> getFournisseurNomDesc() throws SQLException {
        List<Fournisseur> fournisseurs=new ArrayList<>();
        FournisseurDb fournisseurDb=new FournisseurDb();
        fournisseurs=fournisseurDb.selectFournisseurNomDesc();
        return fournisseurs;
    }
    @GetMapping(value="/fournisseursRecherche/{recherche}")
    public List<Fournisseur> getFournisseurReherche(@PathVariable String recherche) throws SQLException {
        List<Fournisseur> fournisseurs=new ArrayList<>();
        FournisseurDb fournisseurDb=new FournisseurDb();
        fournisseurs=fournisseurDb.recherche(recherche);
        return fournisseurs;
    }
    @GetMapping(value="/fournisseursNb")
    public int getNbFournisseur() throws SQLException {
        FournisseurDb fournisseurDb=new FournisseurDb();
        int nb=fournisseurDb.nbFournisseur();
        return nb;
    }
    @GetMapping(value="/fournisseursId/{nomFr}")
    public int getFournisseurId(@PathVariable String nomFr) throws SQLException {
        FournisseurDb fournisseurDb=new FournisseurDb();
        int nb=fournisseurDb.takeId(nomFr);
        return nb;
    }
    @GetMapping(value = "/fournisseursPage/{nb}/{pageSize}")
    public List<Fournisseur> getFournisseurPage(@PathVariable int nb, @PathVariable int pageSize) throws SQLException {
        List<Fournisseur> fournisseurs=new ArrayList<>();
        FournisseurDb fournisseurDb=new FournisseurDb();
        fournisseurs=fournisseurDb.page(nb,pageSize);
        return fournisseurs;
    }
    @PostMapping(value= "/fournisseursPost")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createFournisseur(@RequestBody Fournisseur fournisseur) throws SQLException {
        FournisseurDb fournisseurDb = new FournisseurDb();
        try {
            fournisseurDb.insertFournisseur(fournisseur);
            return ResponseEntity.ok("Fournisseur créé avec succès!");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de la création du fournisseur!");
        }
    }
    @PutMapping(value = "/fournisseursPut")
    public ResponseEntity<String> setFournisseur(@RequestBody  Fournisseur fournisseur){
        FournisseurDb fournisseurDb=new FournisseurDb();
        try{
            fournisseurDb.updateFournisseur(fournisseur);
            return ResponseEntity.ok("update fournisseur réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update fournisseur!");
        }

    }
    @PutMapping(value="/fournisseursNomPut/{nomFr}/{idFr}")
    public ResponseEntity<String> setFournisseurNom(@PathVariable String nomFr, @PathVariable int idFr){
       FournisseurDb fournisseurDb=new FournisseurDb();
        try{
            fournisseurDb.updateFournisseurNom(nomFr,idFr);
            return ResponseEntity.ok("update Fournisseur nom réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update nom fournisseur!");
        }
    }
    @PutMapping(value="/fournisseursMdpPut/{mdpFr}/{idFr}")
    public ResponseEntity<String> setFournisseurMdp(@PathVariable String mdpFr, @PathVariable int idFr){
        FournisseurDb fournisseurDb=new FournisseurDb();
        try{
            fournisseurDb.updateFournisseurMdp(mdpFr,idFr);
            return ResponseEntity.ok("update Fournisseur mdp réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update mdp fournisseur!");
        }
    }
    @PutMapping(value="/fournisseursMailPut/{mailFr}/{idFr}")
    public ResponseEntity<String> setFournisseurMail(@PathVariable String mailFr, @PathVariable int idFr){
        FournisseurDb fournisseurDb=new FournisseurDb();
        try{
            fournisseurDb.updateFournisseurMail(mailFr,idFr);
            return ResponseEntity.ok("update Fournisseur mail réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update mail fournisseur!");
        }
    }
    @PutMapping(value="/fournisseursImgPut/{imgFr}/{idFr}")
    public ResponseEntity<String> setFournisseurImg(@PathVariable byte[] imgFr, @PathVariable int idFr){
        FournisseurDb fournisseurDb=new FournisseurDb();
        try{
            fournisseurDb.updateFournisseurImg(imgFr,idFr);
            return ResponseEntity.ok("update Fournisseur img réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update img fournisseur!");
        }
    }
    @PutMapping(value="/fournisseursContactPut/{contactFr}/{idFr}")
    public ResponseEntity<String> setFournisseurContact(@PathVariable String contactFr, @PathVariable int idFr){
        FournisseurDb fournisseurDb=new FournisseurDb();
        try{
            fournisseurDb.updateFournisseurContact(contactFr,idFr);
            return ResponseEntity.ok("update Fournisseur contact réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update contact fournisseur!");
        }
    }
    @PutMapping(value="/fournisseursAdressePut/{adresseFr}/{idFr}")
    public ResponseEntity<String> setFournisseurAdresse(@PathVariable String adresseFr, @PathVariable int idFr){
        FournisseurDb fournisseurDb=new FournisseurDb();
        try{
            fournisseurDb.updateFournisseurAdresse(adresseFr,idFr);
            return ResponseEntity.ok("update Fournisseur adresse réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update adresse fournisseur!");
        }
    }
    @PutMapping(value="/fournisseursAccesPut/{accesFr}/{idFr}")
    public ResponseEntity<String> setFournisseurMdp(@PathVariable Boolean accesFr, @PathVariable int idFr){
        FournisseurDb fournisseurDb=new FournisseurDb();
        try{
            fournisseurDb.updateFournisseurAcces(accesFr,idFr);
            return ResponseEntity.ok("update Fournisseur acces réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update acces fournisseur!");
        }
    }
    @DeleteMapping(value = "/fournisseursDelete/{id}")
    public  ResponseEntity<String> deleteFournisseur(@PathVariable int id) throws SQLException {
        FournisseurDb fournisseurDb=new FournisseurDb();
        try{
            fournisseurDb.deleteFournisseur(id);
            return ResponseEntity.ok("delete fournisseur réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de delete fournisseur!");
        }
    }
}
