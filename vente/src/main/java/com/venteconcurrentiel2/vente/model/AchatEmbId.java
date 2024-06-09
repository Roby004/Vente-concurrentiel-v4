package com.venteconcurrentiel2.vente.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class AchatEmbId implements Serializable {

    private Long idCli;

    private Long idPro;

    // Default constructor, getters, setters, equals, and hashCode methods
}
