package com.venteconcurrentiel2.vente.repository;

import com.venteconcurrentiel2.vente.model.Achat;
import com.venteconcurrentiel2.vente.model.Fournisseur;

//import com.venteconcurrentiel2.vente.model.AchatEmbId;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

//import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AchattRepository extends JpaRepository<Achat, Long>{

    @Transactional
    void deleteByAchatFr_IdFr(Long idFr);

    @Query("SELECT SUM(a.qteAchat) FROM Achat a JOIN a.achatPro p WHERE p.fourniss.idFr = :idFr")
    Integer getTotalQteAchatFr(@Param("idFr") Long idFr);

    @Query("SELECT a.achatPro.design, SUM(a.qteAchat) as totalQuantity FROM Achat a WHERE a.achatPro.fourniss.idFr = :idFr GROUP BY a.achatPro.idPro ORDER BY totalQuantity DESC")
    List<Object[]> findTop5ProduitsFr(@Param("idFr") Long idFr, Pageable pageable);

    @Query("SELECT a.achatPro.design, SUM(a.qteAchat) as totalQuantity FROM Achat a " +
            "WHERE a.achatPro.fourniss.idFr = :idFr AND a.dateAchat BETWEEN :debutDate AND :endDate " +
            "GROUP BY a.achatPro.idPro ORDER BY totalQuantity DESC")
    List<Object[]> findTop5ProduitsFrDate(@Param("idFr") Long idFr, @Param("debutDate") Date debutDate,
            @Param("endDate") Date endDate, Pageable pageable);

    @Query("SELECT SUM(a.achatPro.prix * a.qteAchat) FROM Achat a WHERE a.achatPro.fourniss.idFr = :idFr")
    Integer getTotalRevenueByFr(@Param("idFr") Long idFr);

    @Query("SELECT COUNT(a) FROM Achat a WHERE a.achatPro.fourniss.idFr = :idFr AND a.dateAchat >= :startDate")
    Integer countAchatsByFournisseurAndLast30Days(@Param("idFr") Long idFr, @Param("startDate") Date startDate);

    @Query("SELECT COUNT(DISTINCT a.achatCli.idCli) FROM Achat a WHERE a.achatPro.fourniss.idFr = :idFr AND a.dateAchat >= :startDate")
    Integer countUniqueClientsByFournisseurAndLast30Days(@Param("idFr") Long idFr, @Param("startDate") Date startDate);

    @Query("SELECT a FROM Achat a WHERE a.achatPro.fourniss.idFr = :idFr AND a.dateAchat >= :startDate")
    List<Achat> findAchatByFournisseurAndLast30Days(@Param("idFr") Long idFr, @Param("startDate") Date startDate);


    /*@Query("SELECT a.id,a.achatCli,a.achatPro,a.qteAchat FROM Achat a WHERE a.achatPro.fourniss.idFr = :idFr AND a.dateAchat >= :startDate")
    List<Achat> findAchatByFournisseurAndLast30Days(@Param("idFr") Long idFr, @Param("startDate") Date startDate);*/

    @Query("SELECT SUM(a.achatPro.prix * a.qteAchat), a.dateAchat FROM Achat a WHERE a.achatPro.fourniss.idFr = :fournisseurId AND a.dateAchat BETWEEN :startDate AND :endDate GROUP BY a.dateAchat ORDER BY a.dateAchat")
    List<Object[]> findTotalRevenueByFournisseurAndDateRange(@Param("fournisseurId") Long fournisseurId,
            @Param("startDate") Date startDate, @Param("endDate") Date endDate);

}