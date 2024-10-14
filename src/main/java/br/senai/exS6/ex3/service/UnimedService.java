package br.senai.exS6.ex3.service;

import org.springframework.stereotype.Service;

@Service
public class UnimedService {
    public void processaPagamento(String cpf, String numeroConvenio, String cpfMedico) {
        // Lógica para processar pagamento via Unimed
        System.out.println("Processando pagamento da Unimed para CPF: " + cpf + " e número de convênio: " + numeroConvenio);
    }
}
