package com.venteconcurrentiel2.vente.controller;

import com.venteconcurrentiel2.vente.model.Avis;
import com.venteconcurrentiel2.vente.service.AvisService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/avis")
public class AvisController {

    @Autowired
    private AvisService avisService;

    @GetMapping("/avisParProduit/{idPro}")
    public ResponseEntity<List<Avis>> getAvisByProduitId(@PathVariable Long idPro) {
        
        List<Avis> avisList = avisService.getCommentairesByProduitId(idPro);

        

        return ResponseEntity.ok(avisList);
    }
}
