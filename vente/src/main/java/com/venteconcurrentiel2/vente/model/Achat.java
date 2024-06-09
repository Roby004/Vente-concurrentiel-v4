package com.venteconcurrentiel2.vente.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Achat {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idCli",insertable=false, updatable=false)
    private Client achatCli;

    @ManyToOne
    @JoinColumn(name = "idPro",insertable=false, updatable=false)
    private Produit achatPro;

    @Column(name = "qteAchat")
    private int qteAchat;

    /*@Temporal(TemporalType.TIMESTAMP)

    private Date dateAchat;*/

    @Temporal(TemporalType.TIMESTAMP)

    private Date dateAchat;

    @ManyToOne
    @JoinColumn(name = "idFr", nullable = false)
    private Fournisseur achatFr;

    public Achat( Client achatCli, Produit achatPro, Fournisseur achatFr, int qteAchat, Date dateAchat) {

        this.achatCli = achatCli;
        this.achatPro = achatPro;
        this.achatFr = achatFr != null ? achatFr : achatPro != null ? achatPro.getFourniss() : null; // Set default value to achatPro.fourniss.idFr
        this.qteAchat = qteAchat;
        this.dateAchat = dateAchat;
    }

}

 /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @EmbeddedId
    private AchatEmbId id;*/