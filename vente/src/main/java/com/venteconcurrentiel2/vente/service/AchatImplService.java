package com.venteconcurrentiel2.vente.service;

import com.venteconcurrentiel2.vente.model.Achat;
import com.venteconcurrentiel2.vente.model.Produit;
import com.venteconcurrentiel2.vente.repository.AchattRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

//import java.time.LocalDate;
import java.util.*;

@Service
public class AchatImplService implements AchatService{

    @Autowired
    private  AchattRepository achatRepository;


    public Integer getTotalQteAchatByidFr(Long idFr) {
        return achatRepository.getTotalQteAchatFr(idFr);
    }

    public List<Object[]> findTop5ProduitsFr(Long idFr) {
        return achatRepository.findTop5ProduitsFr(idFr, PageRequest.of(0, 5));
    }
    public List<Object[]> findTop5ProduitsFrDate(Long idFr, Date debutDate, Date endDate) {
    return achatRepository.findTop5ProduitsFrDate(idFr, debutDate, endDate, PageRequest.of(0, 5));
}


    public Integer getTotalRevenueByFournisseur(Long idFr) {
        return achatRepository.getTotalRevenueByFr(idFr);
    }

    public Integer getCountAchatsOfFrLast30Days(Long idFr) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -30);
        Date startDate = calendar.getTime();
        return achatRepository.countAchatsByFournisseurAndLast30Days(idFr, startDate);
    }

    public Integer getCountClientsOfFrLast30Days(Long idFr) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -30);
        Date startDate = calendar.getTime();
        return achatRepository.countUniqueClientsByFournisseurAndLast30Days(idFr, startDate);
    }
    public List<Achat> getAchatsOfFournisseurLast30Days(Long idFr) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -30);
        Date startDate = calendar.getTime();
        return achatRepository.findAchatByFournisseurAndLast30Days(idFr, startDate);
    }


   


    /*@Override
    public Map<String, Integer> getRevenueData(Date debDate, Date finDate, Long idFr) {
        // Fetch revenue data from the repository
        List<Object[]> revenueData = achatRepository.findRevenueByDateRangeAndIdFr(debDate, finDate, idFr);

        // Process the fetched data
        List<String> dates = new ArrayList<>();
        List<Integer> amounts = new ArrayList<>();

        Map<String, Integer> revenueMap = new LinkedHashMap<>(); // Preserve insertion order

        for (Object[] rowData : revenueData) {
            Date date = (Date) rowData[0];
            Integer revenue = ((Number) rowData[1]).intValue();
            // Cast to Number first
            String dateRev = date.toString();
            revenueMap.put(dateRev, revenue);
        }

        return revenueMap;
    }*/

    public List<Object[]> getTotalRevenueByFournisseurAndDateRange(Long fournisseurId, Date startDate, Date endDate) {
        return achatRepository.findTotalRevenueByFournisseurAndDateRange(fournisseurId, startDate, endDate);
    }
}
