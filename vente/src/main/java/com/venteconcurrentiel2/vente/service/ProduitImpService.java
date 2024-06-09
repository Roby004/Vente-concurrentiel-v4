package com.venteconcurrentiel2.vente.service;


import com.venteconcurrentiel2.vente.DTO.ProduitPutDto;
import com.venteconcurrentiel2.vente.exeption.ProduitNotFoundException;
import com.venteconcurrentiel2.vente.exeption.FournisseurNotFoundException;
import com.venteconcurrentiel2.vente.model.Fournisseur;
import com.venteconcurrentiel2.vente.model.Produit;
import com.venteconcurrentiel2.vente.repository.FournisseurRepository;



import com.venteconcurrentiel2.vente.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitImpService implements ProduitService{
    private final ProduitRepository produitRepository;

    private final FournisseurRepository fournisseurRepository;
    @Override
    public List<Produit> getProduits() {
        return produitRepository.findAll();
    }


    public List<Produit> getProduitsByFournisseur(Long idFr) {
        List<Produit> produits = produitRepository.findByFournissIdFr(idFr);
       /* for (Produit produit : produits) {
            String base64Image =Base64.getEncoder().encodeToString(produit.getImgPro());
            produit.setImgPro(base64Image);
        }*/
        return produits;
    }
    @Override
    public List<Produit> searchProduits(String query,Long idFr) {
        if (query == null || query.isEmpty()) {
            return produitRepository.findByFournissIdFr(idFr); // Return all produits if no query is provided
        } else {
            // Perform search based on design or categorie
            System.out.println("résultat recherche : " + produitRepository.findByFournissIdFrAndDesignContainingIgnoreCaseOrCategorieContainingIgnoreCase(idFr,query,query));
            return produitRepository.findByFournissIdFrAndDesignContainingIgnoreCaseOrCategorieContainingIgnoreCase(idFr,query, query);
        }
    }

    // SELECTIONNER ET RECUPERER UN RPODUIT
   /* public List<Produit> selectUnProduit(int idProduit) throws SQLException {
        List<Produit> produits = new ArrayList<>();
        ConnectionDB connectionDB = new ConnectionDB();
        Connection connection = connectionDB.connect();
        try (
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM produit WHERE idPro = ?");
        ) {

            statement.setInt(1, idProduit);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("idPro");
                String designation = resultSet.getString("design");
                int prix = resultSet.getInt("prix");
                String description = resultSet.getString("descri");
                int quantite = resultSet.getInt("qte");
                String categorie = resultSet.getString("categorie");
                int nbClic = resultSet.getInt("nbClic");
                //Blob imgPro=resultSet.getBlob("imgPro");
                byte[] imgPro=resultSet.getBytes("imgPro");
                int idFournisseur = resultSet.getInt("idFr");
                String dateAjout = resultSet.getString("dateAjout");

                produits.add(new Produit(id, designation, prix, description, quantite, categorie, nbClic, imgPro, idFournisseur, dateAjout));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return produits;
    }*/

    @Override
    public Produit ajoutProduit(Produit produit, MultipartFile file, Long idFr) throws IOException {

        // Set the supplier by fetching it from the database using supplierId
        Fournisseur fournisseur = fournisseurRepository.findById(idFr)
                .orElseThrow(() -> new FournisseurNotFoundException("Fournisseur avec l'ID " + idFr + " non trouvé"));
        produit.setFourniss(fournisseur);

        try {
            produit.setImgPro(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to process image", e);
        }
        return produitRepository.save(produit);
        /*
         /* if (produitExist(produit.getIdPro())) {
            throw new ProduitAlreadyExistsException("Le produit " + produit.getDesign() + " est deja enregistre");
        }
        try {
            produit.setImgPro(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException("Failed to process image", e);
        }
        return produitRepository.save(produit);*/
    }



    public Produit modifProduit(ProduitPutDto produitDto, Long id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new ProduitNotFoundException("Produit avec pour ID " + id + " non trouve."));

        // Update the fields of the existing product
        produit.setCategorie(produitDto.getCategorie());
        produit.setDescri(produitDto.getDescri());
        produit.setDesign(produitDto.getDesign());
        produit.setPrix(produitDto.getPrix());
        produit.setQte(produitDto.getQte());

        // Save the updated product
        //Produit updatedProduit = produitRepository.save(produit);

        return produitRepository.save(produit);
    }

    @Override
    public Produit modifProduitImg(MultipartFile imgFile, Long id) throws IOException  {
        Produit existingProduit = produitRepository.findById(id)
                .orElseThrow(() -> new ProduitNotFoundException("Produit avec pour ID " + id + " non trouvé."));

        try {
            // Convert and update imgPro
            existingProduit.setImgPro(imgFile.getBytes());

        } catch (IOException e) {
            throw new RuntimeException("Failed to process image", e);
        }

        return produitRepository.save(existingProduit);
    }

    @Override
    public List<Produit> selectProduitIdAsc(Long id) {

        List<Produit> produits = produitRepository.findByFournissIdFrOrderByIdProAsc(id);

        return produits;
    }

    @Override
    public List<Produit> selectProduitIdDesc(Long idFr) {
        List<Produit> produits = produitRepository.findByFournissIdFrOrderByIdProDesc(idFr);
        return produits;
    }

    @Override
    public List<Produit> filtre2Date(LocalDate date1, LocalDate date2, Long idFr) {
        List<Produit> produits =produitRepository.findByDateAjoutBetweenAndFournissIdFr(date1, date2, idFr);
        return produits;
    }

    @Override
    public List<Produit> filtre2Prix(Integer prix1, Integer prix2, Long idFr) {

        List<Produit> prodFiltres = produitRepository.findByPrixRangeAndIdFr(prix1, prix2, idFr);
        return prodFiltres;
    }

    @Override
    public List<Produit> selectProduitDesignDesc(Long idFr) {
        List<Produit> produits = produitRepository.findByFournissIdFrOrderByDesignDesc(idFr);

        return produits;
    }

    @Override
    public List<Produit> selectProduitDesignAsc(Long idFr) {
        List<Produit> produits = produitRepository.findByFournissIdFrOrderByDesignAsc(idFr);
        return produits;
    }


    @Override
    public Produit selectUnProduit(Long id) {
        return produitRepository.findById(id).orElseThrow(() -> new ProduitNotFoundException("Desole, le produit est introuvable"));
    }

    @Override
    public void suppProduit(Long id) {
        if (!produitRepository.existsById(id)) {
            throw new ProduitNotFoundException("Produit avec pour ID " + id + " non trouve.");
        }

        produitRepository.deleteById(id);

    }


    private boolean produitExist(Long idPro) {

        return produitRepository.findById(idPro).isPresent();
    }




    public Optional<Produit> getProduitId(Long id){
        return produitRepository.findById(id);
    }



}
