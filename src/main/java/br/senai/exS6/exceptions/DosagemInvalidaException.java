package br.senai.exS6.exceptions;

public class DosagemInvalidaException extends RuntimeException {
    public DosagemInvalidaException(String mensagem) {
        super(mensagem);
    }
}