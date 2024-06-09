package com.venteconcurrentiel2.vente.exeption;

public class FournisseurNotFoundException extends RuntimeException {
    public FournisseurNotFoundException(String mess){
        super(mess);
    }
}
