package br.senai.exS6.ex3.service;

import org.springframework.stereotype.Service;

@Service
public class BacenService {
    public void processaPix(String idTransacaoPix, Float valor) {
        // Lógica para processar pagamento via PIX com transação
        System.out.println("Processando PIX com ID: " + idTransacaoPix + " no valor: " + valor);
    }

    public void geraChavePixParaPagamento(String chavePix, Float valor) {
        // Lógica para gerar chave PIX para pagamento
        System.out.println("Gerando chave PIX: " + chavePix + " para pagamento no valor: " + valor);
    }
}
