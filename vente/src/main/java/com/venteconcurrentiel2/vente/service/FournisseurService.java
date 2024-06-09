package com.venteconcurrentiel2.vente.service;

import com.venteconcurrentiel2.vente.DTO.FournisseurDto;
import com.venteconcurrentiel2.vente.model.Fournisseur;
import com.venteconcurrentiel2.vente.model.Produit;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface FournisseurService {
    Fournisseur enregistrer(FournisseurDto fournisseurDto);
    Fournisseur findByMail(String mail);
    Fournisseur validateFournisseur(String mail, String password);
    Fournisseur getFournisseurById(Long idFr);

     void deleteFournisseur(Long idFr);

    List<Fournisseur> selectFournisseurs();

    List<Fournisseur> selectFournisseursSortedByIdAsc();

    List<Fournisseur> selectAllFournisseursSortedByIdDesc();

    List<Fournisseur> selectFournisseursSortedByNomAsc();

    List<Fournisseur> selectFournisseursSortedByNomDesc();

    List<Fournisseur> searchFournisseurs(String recherche);

    int countFournisseurs();

    Fournisseur updateFournisseur(Fournisseur fournisseur);

    Produit modifFournisseurImg(MultipartFile imgFile, Long id);

    Fournisseur modifFournisseur(FournisseurDto frDto, Long id);
}
