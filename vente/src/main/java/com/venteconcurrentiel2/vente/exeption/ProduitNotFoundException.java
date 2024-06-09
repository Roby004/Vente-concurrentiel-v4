package com.venteconcurrentiel2.vente.exeption;

public class ProduitNotFoundException extends RuntimeException {
    public ProduitNotFoundException(String mess) {
        super(mess);
    }
}
