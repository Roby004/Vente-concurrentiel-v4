package com.example.Ihm.controllers;

import com.example.Ihm.DB.ProduitDB;
import com.example.Ihm.DB.produitRevenuDB;
import com.example.Ihm.models.Produit;
import com.example.Ihm.models.produitRevenu;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value="/produit")
public class produitRevenuController {

	 @GetMapping(value="/produitRevenue/{year}")
     public List<produitRevenu> getProduit(@PathVariable int year) throws SQLException {
        List<produitRevenu> produits=new ArrayList<>();
        produitRevenuDB produitDB=new produitRevenuDB();
        produits=produitDB.selectProduitRevenue(year);
        return produits;
    }
}
