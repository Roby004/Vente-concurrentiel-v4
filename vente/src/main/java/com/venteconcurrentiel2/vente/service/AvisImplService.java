package com.venteconcurrentiel2.vente.service;

import com.venteconcurrentiel2.vente.model.Avis;
import com.venteconcurrentiel2.vente.repository.AvisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvisImplService implements AvisService {
    @Autowired
    private AvisRepository avisRepository;

    public Float getSumVoteByProduitId(Long idPro) {
        return avisRepository.findSumVoteByProduitId(idPro);
    }

    public List<Avis> getCommentairesByProduitId(Long idPro) {
        return avisRepository.findByAvisPro_IdPro(idPro);
    }
}
