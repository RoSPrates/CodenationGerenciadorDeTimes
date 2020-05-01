package br.com.codenation.desafio.exceptions;

public class CapitaoNaoInformadoException extends RuntimeException {

    public CapitaoNaoInformadoException(){}

    public CapitaoNaoInformadoException(String message) {
        super(message);
    }
}
