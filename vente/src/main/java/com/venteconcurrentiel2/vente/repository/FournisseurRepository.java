package com.venteconcurrentiel2.vente.repository;

import com.venteconcurrentiel2.vente.model.Fournisseur;

//import jakarta.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
    Fournisseur findByMailFr(String mail);

    List<Fournisseur> findByCompanyContainingOrMailFrContainingOrContactFrContainingOrAdresseFrContainingOrderByCompanyDesc(String recherche, String recherche1, String recherche2, String recherche3);

    @Query("SELECT COUNT(f) FROM Fournisseur f")
    int countFournisseurs();

    Page<Fournisseur> findAll(Pageable pageable);

    @Transactional
    void deleteByIdFr(Long idFr);
      


    boolean existsByIdFr(Long idFr);
}