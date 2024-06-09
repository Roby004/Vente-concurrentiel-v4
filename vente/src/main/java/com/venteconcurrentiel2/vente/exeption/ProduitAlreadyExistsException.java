package com.venteconcurrentiel2.vente.exeption;

public class ProduitAlreadyExistsException extends RuntimeException {
    public ProduitAlreadyExistsException(String mess){
        super(mess);
    }
}
