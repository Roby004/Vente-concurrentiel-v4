package com.venteconcurrentiel2.vente.controller;

import com.venteconcurrentiel2.vente.model.Achat;
import com.venteconcurrentiel2.vente.model.Produit;
import com.venteconcurrentiel2.vente.service.AchatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
//import java.time.LocalDate;

@RestController
@RequestMapping("/achat")
@RequiredArgsConstructor
public class AchatController {

    @Autowired
    private AchatService achatService;

    @GetMapping("/qteAchatFr/{idFr}")
    public ResponseEntity<Integer> getTotalQteAchatFr(@PathVariable Long idFr) {
        Integer totalQte = achatService.getTotalQteAchatByidFr(idFr);
        return ResponseEntity.ok(totalQte);
    }

    /*@GetMapping("/top5produits/{idFr}")
    public ResponseEntity<List<Object[]>> getTop5ProduitsByTotalQuantitySold(@PathVariable Long idFr) {
        List<Object[]> top5Produits = achatService.findTop5ProduitsFr(idFr);
        return ResponseEntity.ok(top5Produits);
    }*/

    @GetMapping("/top5produits/{idFr}")
public ResponseEntity<List<Object[]>> getTop5ProduitsFr(
        @PathVariable Long idFr,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date debutDate,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) 
{
    List<Object[]> top5Produits = achatService.findTop5ProduitsFrDate(idFr, debutDate, endDate);
    System.out.println("Received top5Produits: " + top5Produits);
    return ResponseEntity.ok(top5Produits);
}


    @GetMapping("/listAchat/{idFr}/last30days")
    public ResponseEntity<List<Achat>> getAchatsOfFournisseurLast30Days(@PathVariable Long idFr) {
        List<Achat> achats = achatService.getAchatsOfFournisseurLast30Days(idFr);
        System.out.println("Received liste achat: " + achats);
        return ResponseEntity.ok(achats);
    }

    /*@GetMapping("/revenueFrMois/{idFr}")
    public ResponseEntity<Integer> getTotalRevenueByFournisseur(@PathVariable Long idFr) {
        Integer totalRevenue = achatService.getTotalRevenueByFournisseur(idFr);
        return ResponseEntity.ok(totalRevenue);
    }
    @GetMapping("/revenueBarFr/{debDate}/{finDate}/{idFr}")
    public ResponseEntity<Map<String, Integer>> getRevenueData(
            @PathVariable("debDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date debDate,
            @PathVariable("finDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date finDate,
            @PathVariable("idFr") Long idFr) {
        Map<String, Integer> revenueData = achatService.getRevenueData(debDate, finDate, idFr);
        return ResponseEntity.ok().body(revenueData);
    }*/

    @GetMapping("/fournisseur/{idFr}/nbAchat/last30days")
    public ResponseEntity<Integer> getNbAchatOfFrLast30Days(@PathVariable Long idFr) {
        Integer achatCount = achatService.getCountAchatsOfFrLast30Days(idFr);

        return ResponseEntity.ok(achatCount);
    }

    @GetMapping("/fournisseur/{idFr}/nbCli/last30days")
    public ResponseEntity<Integer> getNbCliOfFrLast30Days(@PathVariable Long idFr) {

        Integer clientCount = achatService.getCountClientsOfFrLast30Days(idFr);

        return ResponseEntity.ok(clientCount);
    }

    @GetMapping("/revenueMoisFr/{idFr}")
    public ResponseEntity<Integer> getTotalRevenueByFournisseurId(@PathVariable Long idFr) {
        Integer totalRevenue = achatService.getTotalRevenueByFournisseur(idFr);
        return ResponseEntity.ok(totalRevenue);
    }
    
    
    @GetMapping("/revenueFr/{fournisseurId}")
    public ResponseEntity<List<Map<String, Object>>> getTotalRevenueByFournisseurAndDateRange(
            @PathVariable Long fournisseurId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date debutDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {

        List<Object[]> results = achatService.getTotalRevenueByFournisseurAndDateRange(fournisseurId, debutDate, endDate);
        List<Map<String, Object>> response = new ArrayList<>();

        for (Object[] result : results) {
            Map<String, Object> map = new HashMap<>();
            map.put("date", result[1]);
            map.put("totalRevenue", result[0]);
            response.add(map);
        }

        return ResponseEntity.ok(response);
    }
}
