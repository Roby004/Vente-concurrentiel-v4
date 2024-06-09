package com.venteconcurrentiel2.vente.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;


import java.sql.Blob;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCli")
    private Long idCli;

    @NaturalId(mutable = true)

    private String pseudo;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "mdpCli")
    private String mdpCli;

    @Lob
    @Column(name = "imgCli", columnDefinition = "BLOB")
    private byte[] imgCli;

    //private Blob image;


    @NaturalId(mutable = true)
    @Column(name = "mailCli")
    private String mailCli;

    private String role = "ROLE_CLIENT";
    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    private String adresse;

    private Boolean acces;


    @OneToMany(mappedBy = "achatCli")
    private Set<Achat> achats;

    @OneToMany(mappedBy = "avisCli")
    private Set<Avis> avis;

}
