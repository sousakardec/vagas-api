package com.mearimsistemas.vagas_api.exceptions;

public class UsernameExisteException extends RuntimeException{
    public UsernameExisteException(){
        super("Usuário ja existe");
    }
}
