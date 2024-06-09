package com.venteconcurrentiel2.vente.service;

import com.venteconcurrentiel2.vente.model.Achat;
import com.venteconcurrentiel2.vente.model.Produit;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AchatService {
    public Integer getTotalQteAchatByidFr(Long idFr);

    List<Object[]> findTop5ProduitsFr(Long idFr);

    public List<Object[]> findTop5ProduitsFrDate(Long idFr, Date debutDate, Date endDate);

    Integer getTotalRevenueByFournisseur(Long idFr);

    //public Map<String, Integer> getRevenueData(Date debDate, Date finDate, Long idFr);

    public List<Object[]> getTotalRevenueByFournisseurAndDateRange(Long fournisseurId, Date startDate, Date endDate);

    List<Achat> getAchatsOfFournisseurLast30Days(Long idFr);

    Integer getCountAchatsOfFrLast30Days(Long idFr);

    Integer getCountClientsOfFrLast30Days(Long idFr);
}
