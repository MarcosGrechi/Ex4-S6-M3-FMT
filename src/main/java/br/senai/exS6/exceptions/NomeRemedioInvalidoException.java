package br.senai.exS6.exceptions;

public class NomeRemedioInvalidoException extends RuntimeException {
    public NomeRemedioInvalidoException(String mensagem) {
        super(mensagem);
    }
}
