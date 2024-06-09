package com.venteconcurrentiel2.vente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import java.util.Set;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPro;
    private String design;

    @Column(nullable = false)
    private Integer prix;

    @Column(nullable = false)

    private String descri;




    @Column(nullable = false)
    private Integer qte;

    @Lob
    @Column(name = "imgPro", columnDefinition = "LONGBLOB")
    private byte[] imgPro;

    private  String categorie;
    private Integer nbClic = 0;

    @Temporal(TemporalType.DATE)
    private Date dateAjout;

    @ManyToOne
    @JoinColumn(name = "idFr", nullable = false)
    private Fournisseur fourniss;


    @OneToMany(mappedBy = "achatPro")
    private Set<Achat> achats;

    @OneToMany(mappedBy = "avisPro")
    private Set<Avis> avis;

}
