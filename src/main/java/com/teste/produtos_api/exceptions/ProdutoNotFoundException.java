package com.teste.produtos_api.exceptions;


//classe de exceção personalizada
public class ProdutoNotFoundException extends RuntimeException{
    public ProdutoNotFoundException(String message){
        super(message);
    }
}
