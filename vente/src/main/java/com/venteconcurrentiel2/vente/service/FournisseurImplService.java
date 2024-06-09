package com.venteconcurrentiel2.vente.service;

import com.venteconcurrentiel2.vente.DTO.FournisseurDto;

import com.venteconcurrentiel2.vente.model.Fournisseur;
import com.venteconcurrentiel2.vente.model.Produit;
import com.venteconcurrentiel2.vente.repository.AchattRepository;
import com.venteconcurrentiel2.vente.repository.FournisseurRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import java.util.Optional;

@Service
public class FournisseurImplService implements FournisseurService{
    @Autowired
    private FournisseurRepository fournisseurRepository;

     @Autowired
    private  AchattRepository achatRepository;


    @Override
    public Fournisseur enregistrer(FournisseurDto fournisseurDto) {
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setCompany(fournisseurDto.getCompany());
        fournisseur.setMdpFr(fournisseurDto.getMdpFr());
        fournisseur.setMailFr(fournisseurDto.getMailFr());
        fournisseur.setContactFr(fournisseurDto.getContactFr());
        fournisseur.setAdresseFr(fournisseurDto.getAdresseFr());
        fournisseur.setRole("ROLE_FOURNISSEUR"); // Assuming default role
        fournisseur.setAccesFr(false); // Assuming default access
        return fournisseurRepository.save(fournisseur);
    }

    @Override
    public Fournisseur findByMail(String mail) {
        return fournisseurRepository.findByMailFr(mail);
    }

    public Fournisseur getFournisseurById(Long idFr) {
        Optional<Fournisseur> fournisseurOptional = fournisseurRepository.findById(idFr);
        return fournisseurOptional.orElse(null);
    }

    @Override
    public Fournisseur validateFournisseur(String mail, String password) {
        Fournisseur fournisseur = fournisseurRepository.findByMailFr(mail);
        if (fournisseur != null && fournisseur.getMdpFr().equals(password)) {
            return fournisseur;
        }
        return null;
    }


    @Override
    public List<Fournisseur> selectFournisseurs() {
        return fournisseurRepository.findAll();
    }

    @Override
    public List<Fournisseur> selectFournisseursSortedByIdAsc() {
        return fournisseurRepository.findAll(Sort.by(Sort.Direction.ASC, "idFr"));
    }

    @Override
    public List<Fournisseur> selectAllFournisseursSortedByIdDesc() {
        return fournisseurRepository.findAll(Sort.by(Sort.Direction.DESC, "idFr"));
    }

    @Override
    public List<Fournisseur> selectFournisseursSortedByNomAsc() {
        return fournisseurRepository.findAll(Sort.by(Sort.Direction.ASC, "company"));
    }

    @Override
    public List<Fournisseur> selectFournisseursSortedByNomDesc() {
        return fournisseurRepository.findAll(Sort.by(Sort.Direction.DESC, "company"));
    }

    @Override
    public List<Fournisseur> searchFournisseurs(String recherche) {
        return fournisseurRepository.findByCompanyContainingOrMailFrContainingOrContactFrContainingOrAdresseFrContainingOrderByCompanyDesc(recherche, recherche, recherche, recherche);
    }

    @Override
    public int countFournisseurs() {
        return fournisseurRepository.countFournisseurs();
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur fournisseur) {
        // Check if the fournisseur with the given ID exists in the database
        if (fournisseurRepository.existsByIdFr(fournisseur.getIdFr())) {
            // If the fournisseur exists, save it to update
            return fournisseurRepository.save(fournisseur);
        } else {
            // If the fournisseur does not exist, throw an exception or handle it accordingly
            throw new EntityNotFoundException("Fournisseur with ID " + fournisseur.getIdFr() + " not found");
        }
    }

    @Override
    public Produit modifFournisseurImg(MultipartFile imgFile, Long id) {
        return null;
    }

    @Override
    public Fournisseur modifFournisseur(FournisseurDto frDto, Long id) {
        return null;
    }

     public void deleteFournisseur(Long idFr) {
        // Delete related achats
        achatRepository.deleteByAchatFr_IdFr(idFr);
        // Delete fournisseur
        fournisseurRepository.deleteByIdFr(idFr);
    }
}
