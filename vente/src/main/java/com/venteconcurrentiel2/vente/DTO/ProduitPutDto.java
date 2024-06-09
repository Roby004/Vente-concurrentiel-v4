package com.venteconcurrentiel2.vente.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProduitPutDto {
    private Long idPro;
    private String categorie;
    private String descri;
    private String design;
    private Integer prix;
    private Integer qte;
}
