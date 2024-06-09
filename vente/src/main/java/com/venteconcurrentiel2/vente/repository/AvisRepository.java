package com.venteconcurrentiel2.vente.repository;

import com.venteconcurrentiel2.vente.model.Avis;
import com.venteconcurrentiel2.vente.model.AvisEmbId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AvisRepository extends JpaRepository<Avis, AvisEmbId> {
    @Query("SELECT SUM(a.vote) FROM Avis a WHERE a.avisPro.idPro = :idPro")
    Float findSumVoteByProduitId(@Param("idPro") Long idPro);

    List<Avis> findByAvisPro_IdPro(Long idPro);
}

