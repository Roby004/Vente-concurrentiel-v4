package com.venteconcurrentiel2.vente.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProduitDto {
    private Long idPro;
    private String design;
    private String categorie;
    private String descri;
    private Integer prix;
    private Integer qte;
    private String imgPro;
    private Date dateAjout;
}
