package br.com.codenation.desafio.exceptions;

public class TimeNaoEncontradoException extends RuntimeException {
    public TimeNaoEncontradoException() {
    }

    public TimeNaoEncontradoException(String message) {
        super(message);
    }
}