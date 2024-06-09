package com.example.Ihm.controllers;

import com.example.Ihm.DB.ProduitAccueilDB;
import com.example.Ihm.DB.ProduitDB;
import com.example.Ihm.models.Produit;
import com.example.Ihm.models.ProduitAccueil;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value="/produit")
public class ProduitAccueilsController {
    @GetMapping(value = "/produitAccueil")
    public List<ProduitAccueil> getProduit() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ProduitAccueilDB produitAccueilDB=new ProduitAccueilDB();
        produitAccueils=produitAccueilDB.selectProduitAccueil();
        return produitAccueils;
    }
    @GetMapping(value = "/produitAccueilRecent")
    public List<ProduitAccueil> getProduitRecent() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ProduitAccueilDB produitAccueilDB=new ProduitAccueilDB();
        produitAccueils=produitAccueilDB.selectProduitAccueilRecent();
        return produitAccueils;
    }
    @GetMapping(value = "/produitAccueilAsc")
    public List<ProduitAccueil> getProduiAsc() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ProduitAccueilDB produitAccueilDB=new ProduitAccueilDB();
        produitAccueils=produitAccueilDB.selectProduitAccueilAsc();
        return produitAccueils;
    }
    @GetMapping(value = "/produitAccueilDesc")
    public List<ProduitAccueil> getProduitDesc() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ProduitAccueilDB produitAccueilDB=new ProduitAccueilDB();
        produitAccueils=produitAccueilDB.selectProduitAccueilDesc();
        return produitAccueils;
    }
    @GetMapping(value = "/produitAccueilPlusAime")
    public List<ProduitAccueil> getProduitPlusAime() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ProduitAccueilDB produitAccueilDB=new ProduitAccueilDB();
        produitAccueils=produitAccueilDB.selectProduitAccueilPlusAime();
        return produitAccueils;
    }
    @GetMapping(value = "/produitAccueilPlusVisite")
    public List<ProduitAccueil> getProduitPlusVisite() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ProduitAccueilDB produitAccueilDB=new ProduitAccueilDB();
        produitAccueils=produitAccueilDB.selectProduitAccueilPlusVisite();
        return produitAccueils;
    }
    @GetMapping(value = "/produitAccueilPlusAchete")
    public List<ProduitAccueil> getProduitPlusAchete() throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ProduitAccueilDB produitAccueilDB=new ProduitAccueilDB();
        produitAccueils=produitAccueilDB.selectProduitAccueilPlusAChete();
        return produitAccueils;
    }
    @GetMapping(value = "/produitAccueilRecherche/{recherche}")
    public List<ProduitAccueil> getProduitRecherche(@PathVariable String recherche) throws SQLException {
        List<ProduitAccueil> produitAccueils=new ArrayList<>();
        ProduitAccueilDB produitAccueilDB=new ProduitAccueilDB();
        produitAccueils=produitAccueilDB.selectProduitRecherche(recherche);
        return produitAccueils;
    }
}
