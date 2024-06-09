package com.example.Ihm.controllers;

import com.example.Ihm.DB.ClientDB;
import com.example.Ihm.DB.FournisseurDb;
import com.example.Ihm.models.Client;
import com.example.Ihm.models.Fournisseur;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mysql.cj.jdbc.Blob;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping(value="/client")
public class ClientController {

    @GetMapping(value="/clients")
    public List<Client> getClient() throws SQLException {
        List<Client> clients=new ArrayList<>();
        ClientDB clientDB=new ClientDB();
        clients=clientDB.selectClient();
        return clients;
    }

    @GetMapping(value="/clientsIdDesc")
    public List<Client> getClientIdDesc() throws SQLException {
        List<Client> clients=new ArrayList<>();
        ClientDB clientDB=new ClientDB();
        clients=clientDB.selectClientIdDesc();
        return clients;
    }
    @GetMapping(value="/clientsIdAsc")
    public List<Client> getClientIdAsc() throws SQLException {
        List<Client> clients=new ArrayList<>();
        ClientDB clientDB=new ClientDB();
        clients=clientDB.selectClientIdAsc();
        return clients;
    }
    @GetMapping(value="/clientsPseudoAsc")
    public List<Client> getClientPseudoAsc() throws SQLException {
        List<Client> clients=new ArrayList<>();
        ClientDB clientDB=new ClientDB();
        clients=clientDB.selectClientPseudoAsc();
        return clients;
    }
    @GetMapping(value="/clientsPseudoDesc")
    public List<Client> getClientPseudoDesc() throws SQLException {
        List<Client> clients=new ArrayList<>();
        ClientDB clientDB=new ClientDB();
        clients=clientDB.selectClientPseudoDesc();
        return clients;
    }
    @GetMapping(value="/clients/{idCli}")
    public List<Client> getClientReherche(@PathVariable int idCli) throws SQLException {
        List<Client> clients=new ArrayList<>();
        ClientDB clientDB=new ClientDB();
        clients=clientDB.selectOneClient(idCli);
        return clients;
    }
    @GetMapping(value="/clientsRecherche/{recherche}")
    public List<Client> getClientReherche(@PathVariable String recherche) throws SQLException {
        List<Client> clients=new ArrayList<>();
        ClientDB clientDB=new ClientDB();
        clients=clientDB.rechercheClient(recherche);
        return clients;
    }
    @GetMapping(value="/clientsNb")
    public int getNbClient() throws SQLException {
        ClientDB clientDB=new ClientDB();
        int nb=clientDB.nbClient();
        return nb;
    }
    @GetMapping(value = "/clientsPage/{nb}/{pageSize}")
    public List<Client> getClientPage(@PathVariable int nb, @PathVariable int pageSize) throws SQLException {
        List<Client> clients=new ArrayList<>();
        ClientDB clientDB=new ClientDB();
        clients=clientDB.page(nb,pageSize);
        return clients;
    }
    @PostMapping(value= "/clientsPost")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createClient(@RequestBody Client client) throws SQLException {
        ClientDB clientDb = new ClientDB();
        try {
            clientDb.insertClient(client);
            return ResponseEntity.ok("Client créé avec succès!");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de la création du client!");
        }
    }

    @PutMapping(value = "/clientsPut")
    public ResponseEntity<String> setClient(@RequestBody  Client client){
        ClientDB clientdb=new ClientDB();
        try{
            clientdb.updateClient(client);
            return ResponseEntity.ok("update Client réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update client!");
        }

    }

    @PutMapping(value="/clientsPseudoPut/{pseudo}/{idCli}")
    public ResponseEntity<String> setClientPseudo(@PathVariable String pseudo, @PathVariable int idCli){
        ClientDB clientdb=new ClientDB();
        try{
            clientdb.updateClientPseudo(pseudo,idCli);
            return ResponseEntity.ok("update Client pseudo réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update pseudo client!");
        }
    }
    @PutMapping(value="/clientsMdpPut/{mdpCli}/{idCli}")
    public ResponseEntity<String> setClientMdpCli(@PathVariable String mdpCli, @PathVariable int idCli){
        ClientDB clientdb=new ClientDB();
        try{
            clientdb.updateClientMdpCli(mdpCli,idCli);
            return ResponseEntity.ok("update Client mdp réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update mdp client!");
        }
    }
    @PutMapping(value="/clientsMailPut/{mailCli}/{idCli}")
    public ResponseEntity<String> setClientMailCli(@PathVariable String mailCli, @PathVariable int idCli){
        ClientDB clientdb=new ClientDB();
        try{
            clientdb.updateClientMailCli(mailCli,idCli);
            return ResponseEntity.ok("update Client mail réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update mail client!");
        }

    }
    @PutMapping(value="/clientsContactPut/{contact}/{idCli}")
    public ResponseEntity<String> setClientContact(@PathVariable String contact, @PathVariable int idCli){
        ClientDB clientdb=new ClientDB();
        try{
            clientdb.updateClientContact(contact,idCli);
            return ResponseEntity.ok("update Client contact réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update contact client!");
        }

    }
    @PutMapping(value="/clientsAdressePut/{adresse}/{idCli}")
    public ResponseEntity<String> setClientAdresse(@PathVariable String adresse, @PathVariable int idCli){
        ClientDB clientdb=new ClientDB();
        try{
            clientdb.updateClientAdresse(adresse,idCli);
            return ResponseEntity.ok("update Client adresse réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update adresse client!");
        }

    }
    @PutMapping(value="/clientsImgPut/{idCli}")
    public ResponseEntity<String> setClientImage( @PathVariable int idCli, @RequestParam("imgCli") byte[] imgCli){
        ClientDB clientdb=new ClientDB();
        try{
            clientdb.updateClientImgCli(imgCli,idCli);
            return ResponseEntity.ok("update Client img réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update img client!");
        }

    }
    @PutMapping(value="/clientsAccesPut/{acces}/{idCli}")
    public ResponseEntity<String> setClientAcces(@PathVariable Boolean acces, @PathVariable int idCli){
        ClientDB clientdb=new ClientDB();
        try{
            clientdb.updateClientAcces(acces,idCli);
            return ResponseEntity.ok("update Client acces réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de update acces client!");
        }

    }
    @DeleteMapping(value = "/clientsDelete/{id}")
    public  ResponseEntity<String> deleteClient(@PathVariable int id) throws SQLException {
        ClientDB clientDB=new ClientDB();
        try{
            clientDB.deleteClient(id);
            return ResponseEntity.ok("delete client réussi");
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Échec de delete client!");
        }
    }


}
