package com.example.Ihm.controllers;

import com.example.Ihm.DB.ClientDB;
import com.example.Ihm.DB.FournisseurDb;
import com.example.Ihm.DB.ProduitDB;
import com.example.Ihm.models.Fournisseur;
import com.example.Ihm.models.Produit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value="/produit")
public class ProduitController {

    @GetMapping(value = "/produits")
    public List<Produit> getProduit() throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.selectProduit();
        return produits;
    }
    @GetMapping(value = "/produitsIdAsc")
    public List<Produit> getProduitIdAsc() throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.selectProduitIdAsc();
        return produits;
    }
    @GetMapping(value = "/produitsIdDesc")
    public List<Produit> getProduitIdDesc() throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.selectProduitIdDesc();
        return produits;
    }
    @GetMapping(value = "/produitsDesignAsc")
    public List<Produit> getProduitDesignAsc() throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.selectProduitDesignAsc();
        return produits;
    }
    @GetMapping(value = "/produitsDesignDesc")
    public List<Produit> getProduitDesignDesc() throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.selectProduitDesignDesc();
        return produits;
    }
    @GetMapping(value = "/produitsPrixAsc")
    public List<Produit> getProduitPrixAsc() throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.selectProduitPrixAsc();
        return produits;
    }
    @GetMapping(value = "/produitsPrixDesc")
    public List<Produit> getProduitPrixDesc() throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.selectProduitPrixDesc();
        return produits;
    }
    @GetMapping(value="/produitsRecherche/{recherche}")
    public List<Produit> getProduitReherche(@PathVariable String recherche) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.recherche(recherche);
        return produits;
    }
    @GetMapping(value="/produitsTypeNb")
    public int getNbProduitType() throws SQLException {
        ProduitDB produitDB=new ProduitDB();
        int nbType=produitDB.nbProduitType();
        return nbType;
    }
    @GetMapping(value="/produitsNb")
    public int getNbProduit() throws SQLException {
        ProduitDB produitDB=new ProduitDB();
        int nb=produitDB.nbProduit();
        return nb;
    }

    @GetMapping(value="/produitsFiltre2Dates/{date1}/{date2}")
    public  List<Produit> getProduitBtwDate(@PathVariable String date1, @PathVariable String date2) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.filtre2Date(date1,date2);
        return produits;
    }
    @GetMapping(value = "/produitPagination/{nb}/{pageSize}")
    public  List<Produit> getProduitPagination(@PathVariable int nb,@PathVariable int pageSize) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.page(nb,pageSize);
        return produits;
    }
    @GetMapping(value="/produitsFiltreDate/{date}")
    public  List<Produit> getProduitDate(@PathVariable String date) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.filtreDate(date);
        return produits;
    }
    @GetMapping(value="/produitsFiltreMois/{mois}")
    public  List<Produit> getProduitMois(@PathVariable String mois) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.filtreMois(mois);
        return produits;
    }
    @GetMapping(value="/produitsFiltreAnnee/{annee}")
    public  List<Produit> getProduitAnnee(@PathVariable String annee) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.filtreAnnee(annee);
        return produits;
    }
    @GetMapping(value="/produitsFiltreMoisAnnee/{mois}/{annee}")
    public  List<Produit> getProduitMoisAnnee(@PathVariable String mois, @PathVariable String annee) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.filtreMoisAnnee(mois,annee);
        return produits;
    }
    @GetMapping(value="/produitsFiltreFournisseur/{nomFr}")
    public  List<Produit> getProduitFournisseur(@PathVariable String nomFr) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.filtreFournisseur(nomFr);
        return produits;
    }
    @GetMapping(value="/produitsFiltreCategorie/{categ}")
    public  List<Produit> getProduitCategorie(@PathVariable String categ) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.filtreCategorie(categ);
        return produits;
    }
    @GetMapping(value="/produitsFiltre2Prix/{prix1}/{prix2}")
    public  List<Produit> getProduitBtwPrix(@PathVariable int prix1, @PathVariable int prix2) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.filtre2Prix(prix1,prix2);
        return produits;
    }
    @GetMapping(value="/produitsFiltreCategoriePrix/{categ}/{prixMin}/{prixMax}")
    public  List<Produit> getProduitPrixCategorie(@PathVariable String categ, @PathVariable int prixMin, @PathVariable int prixMax) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.filterCategoriePrix(categ,prixMin,prixMax);
        return produits;
    }
    @GetMapping(value="/produitsFiltreCategoriePrixMois/{categ}/{prixMin}/{prixMax}/{mois}")
    public  List<Produit> getProduitPrixCategorieMois(@PathVariable String categ, @PathVariable int prixMin, @PathVariable int prixMax,@PathVariable String mois) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.filterByCategoriePrixMois(categ,prixMin,prixMax,mois);
        return produits;
    }
    @GetMapping(value="/produitsFiltreCategoriePrixAnnee/{categ}/{prixMin}/{prixMax}/{annee}")
    public  List<Produit> getProduitPrixCategorieAnnee(@PathVariable String categ, @PathVariable int prixMin, @PathVariable int prixMax,@PathVariable String annee) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.filterByCategoriePrixMois(categ,prixMin,prixMax,annee);
        return produits;
    }
    @GetMapping(value="/produitsFiltreCategoriePrixFr/{categ}/{prixMin}/{prixMax}/{fournisseur}")
    public  List<Produit> getProduitPrixCategorieFr(@PathVariable String categ, @PathVariable int prixMin, @PathVariable int prixMax,@PathVariable String fournisseur) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.filterByCategoriePrixMois(categ,prixMin,prixMax,fournisseur);
        return produits;
    }
    @GetMapping(value="/produitsTakeId/{design}")
    public int getIdPro(@PathVariable String design) throws SQLException {
        ProduitDB produitDB=new ProduitDB();
        int nb=produitDB.takeId(design);
        return nb;
    }
    @GetMapping(value="/produitsAcheteParClient/{idCli}")
    public  List<Produit> getProduitAcheteParClient( @PathVariable int idCli) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.getProduitsAchetésParClient(idCli);
        return produits;
    }

    @GetMapping(value="/produitsAcheteParClientParAnnee/{idCli}/{annee}")
    public  List<Produit> getProduitAcheteParClientParAnnee( @PathVariable int idCli,@PathVariable String annee) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.getProduitsAchetésParClientAnnee(idCli,annee);
        return produits;
    }
    @GetMapping(value="/produitsAcheteParClientParMoisAnnee/{idCli}/{mois}/{annee}")
    public  List<Produit> getProduitAcheteParClientParMoisAnnee( @PathVariable int idCli,@PathVariable String mois, @PathVariable String annee) throws SQLException {
        List<Produit> produits=new ArrayList<>();
        ProduitDB produitDB=new ProduitDB();
        produits=produitDB.getProduitsAchetésParClientMoisAnne(idCli,mois,annee);
        return produits;
    }
    @GetMapping(value="/produitsAcheteParClientMois/{idCli}/{mois}")
    public List<Produit> getProduitsAchetésParClientMoisController(@PathVariable int idCli, @PathVariable String mois) throws SQLException {
        ProduitDB produitDB = new ProduitDB();
        return produitDB.getProduitsAchetésParClientMois(idCli, mois);
    }

    @GetMapping(value="/getUnProduit/{id}")
    public List<Produit> getUnProduit(@PathVariable int id) throws SQLException {
        ProduitDB produitDB=new ProduitDB();
        List<Produit> produits=produitDB.selectUnProduit(id);
        return produits;
    }
    @GetMapping(value="/produitsPlusVisite")
    public int getProduitPlusVisite() throws SQLException {
        ProduitDB produitDB=new ProduitDB();
        int nb=produitDB.produitPlusVisite();
        return nb;
    }

    @PostMapping(value= "/produitsPost")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createProduit(@RequestBody Produit produit) throws SQLException {
        ProduitDB produitdb = new ProduitDB();
        try {
            produitdb.insertProduit(produit);
            return ResponseEntity.ok("Produit créé avec succès!");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de la création du produit!");
        }
    }

    @PutMapping(value = "/produitsPut")
    public ResponseEntity<String> setProduit(@RequestBody  Produit produit){
        ProduitDB produitDB=new ProduitDB();
        try{
            produitDB.updateProduit(produit);
            return ResponseEntity.ok("update produit réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update produit!");
        }

    }
    @PutMapping(value="/produitsDesignPut/{design}/{idPro}")
    public ResponseEntity<String> setProduitDesign(@PathVariable String design, @PathVariable int idPro){
        ProduitDB produitDB=new ProduitDB();
        try{
            produitDB.updateFournisseurDesign(design,idPro);
            return ResponseEntity.ok("update réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update !");
        }

    }
    @PutMapping(value="/produitsDescriPut/{descri}/{idPro}")
    public ResponseEntity<String> setProduitDescri(@PathVariable String descri, @PathVariable int idPro){
        ProduitDB produitDB=new ProduitDB();
        try{
            produitDB.updateFournisseurDescri(descri,idPro);
            return ResponseEntity.ok("update réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update !");
        }

    }
    @PutMapping(value="/produitsCategoriePut/{categorie}/{idPro}")
    public ResponseEntity<String> setProduitCategorie(@PathVariable String categorie, @PathVariable int idPro){
        ProduitDB produitDB=new ProduitDB();
        try{
            produitDB.updateFournisseurCategorie(categorie,idPro);
            return ResponseEntity.ok("update réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update !");
        }
    }
    @PutMapping(value="/produitsDatePut/{date}/{idPro}")
    public ResponseEntity<String> setProduitDate(@PathVariable String date, @PathVariable int idPro){
        ProduitDB produitDB=new ProduitDB();
        try{
            produitDB.updateFournisseurDate(date,idPro);
            return ResponseEntity.ok("update réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update !");
        }
    }
    @PutMapping(value="/produitsPrixPut/{prix}/{idPro}")
    public ResponseEntity<String> setProduitPrix(@PathVariable int prix, @PathVariable int idPro){
        ProduitDB produitDB=new ProduitDB();
        try{
            produitDB.updateFournisseurPrix(prix,idPro);
            return ResponseEntity.ok("update réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update !");
        }

    }
    @PutMapping(value="/produitsQtePut/{qte}/{idPro}")
    public ResponseEntity<String> setProduitQte(@PathVariable int qte, @PathVariable int idPro){
        ProduitDB produitDB=new ProduitDB();
        try{
            produitDB.updateFournisseurQte(qte,idPro);
            return ResponseEntity.ok("update réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update !");
        }

    }
    @PutMapping(value="/produitsNbClicPut/{nbClic}/{idPro}")
    public ResponseEntity<String> setProduitNbClic(@PathVariable int nbClic, @PathVariable int idPro){
        ProduitDB produitDB=new ProduitDB();
        try{
            produitDB.updateFournisseurNbClic(nbClic,idPro);
            return ResponseEntity.ok("update réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update !");
        }

    }
    @PutMapping(value="/produitsImgPut/{imgPro}/{idPro}")
    public ResponseEntity<String> setProduitImg(@PathVariable byte[] imgPro, @PathVariable int idPro){
        ProduitDB produitDB=new ProduitDB();
        try{
            produitDB.updateFournisseurImgPro(imgPro,idPro);
            return ResponseEntity.ok("update réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update !");
        }

    }
    @DeleteMapping(value = "/produitsDelete/{id}")
    public  ResponseEntity<String> deleteProduit(@PathVariable int id) throws SQLException {
        ProduitDB produitDB=new ProduitDB();
        try{
            produitDB.deleteProduit(id);
            return ResponseEntity.ok("delete produit réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de delete produit!");
        }
    }
}
