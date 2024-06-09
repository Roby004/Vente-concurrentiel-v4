package com.venteconcurrentiel2.vente.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Avis {
    @EmbeddedId
    private AvisEmbId id;
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    private String commentaire;

    private Float vote;

    @Temporal(TemporalType.DATE)
    private Date dateAvis;

    @ManyToOne
    @JoinColumn(name = "idPro", insertable=false, updatable=false)
    private Produit avisPro;

    @ManyToOne
    @JoinColumn(name = "idCli", insertable=false, updatable=false)
    private Client avisCli;

}
