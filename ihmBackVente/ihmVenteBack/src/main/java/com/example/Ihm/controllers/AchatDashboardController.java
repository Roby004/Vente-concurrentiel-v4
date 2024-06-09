package com.example.Ihm.controllers;

import com.example.Ihm.DB.AchatDashboardDB;
import com.example.Ihm.models.AchatDashboard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value="/achat")
public class AchatDashboardController {
	@GetMapping(value = "/achatDashboard")
    public List<AchatDashboard> getAchat() throws SQLException {
        List<AchatDashboard> achats=new ArrayList<>();
        AchatDashboardDB achatdb=new AchatDashboardDB();
        achats=achatdb.selectAchatDashboard();
        return achats;
    }
}
