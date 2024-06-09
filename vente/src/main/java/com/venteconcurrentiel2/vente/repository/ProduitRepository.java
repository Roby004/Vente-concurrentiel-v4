package com.venteconcurrentiel2.vente.repository;

import com.venteconcurrentiel2.vente.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProduitRepository extends JpaRepository<Produit,Long> {
    List<Produit> findByFournissIdFr(Long idFr);
    List<Produit> findByFournissIdFrAndDesignContainingIgnoreCaseOrCategorieContainingIgnoreCase(Long id,String design, String categorie);

    List<Produit> findByFournissIdFrOrderByDesignAsc(Long idFr);

    List<Produit> findByFournissIdFrOrderByDesignDesc(Long idFr);

    List<Produit> findByFournissIdFrOrderByIdProDesc(Long idFr);

    List<Produit> findByFournissIdFrOrderByIdProAsc(Long id);

    @Query("SELECT p FROM Produit p WHERE p.prix BETWEEN :prix1 AND :prix2 AND p.fourniss.idFr = :idFr")
    List<Produit> findByPrixRangeAndIdFr(@Param("prix1") Integer prix1, @Param("prix2")  Integer prix2, @Param("idFr") Long idFr);

    List<Produit> findByDateAjoutBetweenAndFournissIdFr(LocalDate date1, LocalDate date2, Long idFr);

    //Optional<Produit> findById();

}
