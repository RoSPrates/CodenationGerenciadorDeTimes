package br.com.codenation.desafio.exceptions;

public class IdentificadorUtilizadoException extends RuntimeException {

    public IdentificadorUtilizadoException(){}
    public IdentificadorUtilizadoException(String message){
        super(message);
    }
}
