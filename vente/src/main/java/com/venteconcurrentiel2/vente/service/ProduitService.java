package com.venteconcurrentiel2.vente.service;
import com.venteconcurrentiel2.vente.DTO.ProduitPutDto;
import com.venteconcurrentiel2.vente.model.Produit;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ProduitService {
    Produit ajoutProduit(Produit produit, MultipartFile imgPro, Long idFr) throws IOException;
    List<Produit> getProduits();
    public List<Produit> getProduitsByFournisseur(Long idFr);
    public Optional<Produit> getProduitId(Long id);
    //public List<Produit> selectUnProduit(int idProduit) throws SQLException ;
    Produit modifProduit(ProduitPutDto produitDto, Long id);
    Produit selectUnProduit(Long id);
    void suppProduit(Long id);

    Produit modifProduitImg(MultipartFile imgFile, Long id) throws IOException ;

    List<Produit> selectProduitIdAsc(Long id);

    List<Produit> filtre2Date(LocalDate date1, LocalDate date2, Long idFr);


    List<Produit> filtre2Prix(Integer prix1, Integer prix2, Long idFr);

    List<Produit> selectProduitDesignDesc(Long idFr);

    List<Produit> selectProduitDesignAsc(Long idFr);

    List<Produit> selectProduitIdDesc(Long idFr);

    List<Produit> searchProduits(String query, Long idFr);
}
