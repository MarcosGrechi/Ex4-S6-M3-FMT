package br.senai.exS6.ex3.service;

import org.springframework.stereotype.Service;

@Service
public class SusService {
    public void solicitaProcessoPagamento(String cpf, String numeroPis, Float valor) {
        // Lógica para processar pagamento via SUS
        System.out.println("Solicitando processo de pagamento do SUS para CPF: " + cpf + " e número do PIS: " + numeroPis + " no valor: " + valor);
    }
}
