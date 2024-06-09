package com.venteconcurrentiel2.vente.service;

import com.venteconcurrentiel2.vente.model.Avis;

import java.util.List;

public interface AvisService {

    public Float getSumVoteByProduitId(Long idPro);
    public List<Avis> getCommentairesByProduitId(Long idPro);
}
