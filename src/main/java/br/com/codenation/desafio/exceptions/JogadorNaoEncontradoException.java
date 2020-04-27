package br.com.codenation.desafio.exceptions;

public class JogadorNaoEncontradoException extends RuntimeException {

    public JogadorNaoEncontradoException() {
    }

    public JogadorNaoEncontradoException(String message) {
        super(message);
    }
}
