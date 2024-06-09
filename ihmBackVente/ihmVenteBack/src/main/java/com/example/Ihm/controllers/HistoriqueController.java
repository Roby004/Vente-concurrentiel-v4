package com.example.Ihm.controllers;

import com.example.Ihm.DB.AvisDB;
import com.example.Ihm.DB.HistoriqueDB;
import com.example.Ihm.models.Avis;
import com.example.Ihm.models.Historique;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value="/historique")
public class HistoriqueController {
    @GetMapping(value = "/historique/{id}")
   public List<Historique> getHistorique(@PathVariable int id) throws SQLException {
            List<Historique> historiqueList=new ArrayList<>();
            HistoriqueDB historiqueDB=new HistoriqueDB();
            historiqueList=historiqueDB.selectHistorique(id);
            return historiqueList;

    }
}
