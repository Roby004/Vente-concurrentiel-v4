package com.venteconcurrentiel2.vente.controller;


import com.venteconcurrentiel2.vente.DTO.ClientDto;
import com.venteconcurrentiel2.vente.DTO.FournisseurDto;
import com.venteconcurrentiel2.vente.DTO.FrLoginRequest;
import com.venteconcurrentiel2.vente.DTO.ProduitPutDto;
import com.venteconcurrentiel2.vente.model.Client;
import com.venteconcurrentiel2.vente.model.Fournisseur;
import com.venteconcurrentiel2.vente.model.Produit;
import com.venteconcurrentiel2.vente.service.ClientService;
import com.venteconcurrentiel2.vente.service.FournisseurService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private FournisseurService fournisseurService;

    @Value("${admin.mail}")
    private String adminMail;

    @Value("${admin.password}")
    private String adminMdp;

    @PostMapping("/client/signup")
    public ResponseEntity<?> registerClient(@RequestBody ClientDto clientDto) {
        Client client = clientService.enregistrer(clientDto);
        // Handle registration response
        return ResponseEntity.ok().body("Client registered successfully");
    }

    @PostMapping("/fournisseur/signup")
    public ResponseEntity<?> registerFournisseur(@RequestBody FournisseurDto fournisseurDto) {
        Fournisseur fournisseur = fournisseurService.enregistrer(fournisseurDto);
        // Handle registration response
        return ResponseEntity.ok().body("Fournisseur registered successfully");
    }

    @PostMapping("/client/login")
    public ResponseEntity<?> authenticateClient(@RequestBody FrLoginRequest loginRequest,HttpSession session) {
        String adMail = loginRequest.getMail();
        String adMdp = loginRequest.getPassword();
        Client client = clientService.validateClient(loginRequest.getMail(), loginRequest.getPassword());

        if(adMail.equals(adminMail) && adMdp.equals(adminMdp)){
            session.setAttribute("isAdmin", true);
            return ResponseEntity.ok().body("Admin  authentifie");
        }

        if (client != null) {

            session.setAttribute("clientId", client.getIdCli());
            String sessionId = session.getId();
            System.out.println("Session ID loginClient: " + sessionId);
            System.out.println(" ID loginClient: " + client.getIdCli());
            // Set the fournisseur ID as a model attribute
            //model.addAttribute("frId", Long.valueOf(fournisseur.getFournisseurId()));

            return ResponseEntity.ok().body(Map.of("clientId", client.getIdCli()));
            // Return fournisseur details
        } else {
            // Handle authentication failure
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @PostMapping("/fournisseur/login")
    public ResponseEntity<?> authenticateFournisseur(@RequestBody FrLoginRequest loginRequest,  HttpSession session) {
        String adMail = loginRequest.getMail();
        String adMdp = loginRequest.getPassword();

        if(adMail.equals(adminMail) && adMdp.equals(adminMdp)){
            session.setAttribute("isAdmin", true);

            System.out.println("Admin authentifié " );
            return ResponseEntity.ok().body(Map.of("isAdmin", true));
            //return ResponseEntity.ok().body("Admin  authentifie");
        }

        Fournisseur fournisseur = fournisseurService.validateFournisseur(loginRequest.getMail(), loginRequest.getPassword());
        if (fournisseur != null) {
            session.setAttribute("fournisseurId", fournisseur.getIdFr());
            String sessionId = session.getId();
            System.out.println("Session ID loginFr: " + sessionId);
            // Set the fournisseur ID as a model attribute
            //model.addAttribute("frId", Long.valueOf(fournisseur.getFournisseurId()));

            return ResponseEntity.ok().body(Map.of("fournisseurId", fournisseur.getIdFr()));
            //return ResponseEntity.ok().body(Map.of("fournisseurId", fournisseur.getIdFr()));
            // Return fournisseur details
        } else {
            // Handle authentication failure
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }

    @PostMapping("/logout")
        public ResponseEntity<?> loggout(HttpServletRequest request){
             request.getSession().invalidate();
             return ResponseEntity.ok().body("logout reussi");
        }

    @GetMapping("/detailClient/{idCli}")
    public ResponseEntity<?> getClientDetails(@PathVariable Long idCli) {
       Client client = clientService.getClientById(idCli);
        if (client != null) {
            ClientDto clientDto = convertToClientDto(client);
            return ResponseEntity.ok().body(clientDto);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fournisseur details not found");
        }

    }
// METHODE pour convertir Client entity en ClientDTO
    private ClientDto convertToClientDto(Client client) {
        ClientDto clientDto = new ClientDto();
        clientDto.setAdresse(client.getAdresse());
        clientDto.setPseudo(client.getPseudo());
        clientDto.setContact(client.getContact());
        clientDto.setMdpCli(client.getMdpCli());
        clientDto.setMailCli(client.getMailCli());

        return clientDto;
    }

    @GetMapping("/detailFr/{fournisseurId}")
    public ResponseEntity<?> getFournisseurDetails(@PathVariable Long fournisseurId) {
        Fournisseur fournisseur = fournisseurService.getFournisseurById(fournisseurId);
        if (fournisseur != null) {
            FournisseurDto fournisseurDto = convertToFournisseurDto(fournisseur);
            return ResponseEntity.ok().body(fournisseurDto);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fournisseur details not found");
        }

    }



    //  METHODE pour convertir Fournisseur entity en FournisseurDto
    private FournisseurDto convertToFournisseurDto(Fournisseur fournisseur) {
        FournisseurDto fournisseurDto = new FournisseurDto();

        fournisseurDto.setCompany(fournisseur.getCompany());
        fournisseurDto.setAdresseFr(fournisseur.getAdresseFr());
        fournisseurDto.setContactFr(fournisseur.getContactFr());
        fournisseurDto.setMailFr(fournisseur.getMailFr());
        fournisseurDto.setMdpFr(fournisseur.getMdpFr());

        return fournisseurDto;
    }
    @PutMapping("/fournisseurPut/{id}")
    public ResponseEntity<String> modifFournisseur(@RequestBody FournisseurDto frDto, @PathVariable Long id) {
        System.out.println("Received idFr: " + id);
        try {
            Fournisseur updatedFr = fournisseurService.modifFournisseur(frDto, id);
            return ResponseEntity.ok("Fournisseur modifie avec succes");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur de modification du fournisseur: " + e.getMessage());
        }
    }

    @PutMapping("/fournisseurPutImg/{id}")
    public Produit modifFournisseurImg(@RequestParam("imgFile") MultipartFile imgFile, @PathVariable Long id) throws IOException {
        System.out.println("Received imgFile: " + imgFile.getOriginalFilename());
        System.out.println("Received idFr: " + id);
        return fournisseurService.modifFournisseurImg(imgFile, id);
    }

    @DeleteMapping("/frDelete/{idFr}")
    public ResponseEntity<Void> deleteFournisseur(@PathVariable Long idFr, HttpServletRequest request) {
        fournisseurService.deleteFournisseur(idFr);
         // Invalidate session
        request.getSession().invalidate();

        return ResponseEntity.noContent().build();
    }

}

  /*
           if (frId != null) {
            System.out.println("fr details found in session:" + frId);
            Fournisseur fournisseur = fournisseurService.getFournisseurById(frId);

            System.out.println("fr details found in session:" + fournisseur);
            FournisseurDto fournisseurDto = convertToFournisseurDto(fournisseur);
            return ResponseEntity.ok().body(fournisseurDto);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fournisseur details not found");
        }
          String sessionId = session.getId();
        System.out.println("Session ID DetailFr: " + sessionId);
       Long fournisseurId = (Long) session.getAttribute("fournisseurId");
        Fournisseur fournisseur = fournisseurService; // Assuming you have a method to retrieve fournisseur by ID

        System.out.println("fr details found in session:"+fournisseur);
        if (fournisseur != null) {
            System.out.println("fr details found in session:"+fournisseur);
            FournisseurDto fournisseurDto = convertToFournisseurDto(fournisseur);
            return ResponseEntity.ok().body(fournisseurDto);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fournisseur details not found");
        }*/