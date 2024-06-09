package com.venteconcurrentiel2.vente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class AvisEmbId implements Serializable {
    @Column(name = "idCli")
    private Long idCli;

    @Column(name = "idPro")
    private Long idPro;

}
