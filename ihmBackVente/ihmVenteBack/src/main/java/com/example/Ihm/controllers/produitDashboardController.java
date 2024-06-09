package com.example.Ihm.controllers;

import com.example.Ihm.DB.produitDashboardDB;
import com.example.Ihm.models.produitDashboard;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value="/produit")
public class produitDashboardController {
     @GetMapping(value = "/produitsDashboard")
    public List<produitDashboard> getProduitDash() throws SQLException {
        List<produitDashboard> produitsD=new ArrayList<>();
        produitDashboardDB produitDB=new produitDashboardDB();
        produitsD=produitDB.selectProduitDash();
        return produitsD;
    }
    @GetMapping(value = "/produitsGraphe/{tri}")
    public List<produitDashboard> getProduitGraphe(@PathVariable String tri) throws SQLException {
        List<produitDashboard> produitsD=new ArrayList<>();
        produitDashboardDB produitDB=new produitDashboardDB();
        produitsD=produitDB.selectProduitDash();
        return produitsD;
    }
}
