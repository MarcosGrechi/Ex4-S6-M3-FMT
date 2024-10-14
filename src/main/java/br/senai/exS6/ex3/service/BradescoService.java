package br.senai.exS6.ex3.service;

import org.springframework.stereotype.Service;

@Service
public class BradescoService {
    public void processaPagamento(String cpf, String cpfMedico, Float valor) {
        // Lógica para processar pagamento via Bradesco
        System.out.println("Processando pagamento do Bradesco para CPF: " + cpf + " no valor: " + valor);
    }
}
