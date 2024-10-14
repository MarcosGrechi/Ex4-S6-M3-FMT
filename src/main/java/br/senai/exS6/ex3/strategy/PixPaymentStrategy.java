package br.senai.exS6.ex3.strategy;

import br.senai.exS6.ex3.model.InformacoesPagamento;
import br.senai.exS6.ex3.model.PessoaPaciente;
import br.senai.exS6.ex3.service.BacenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PixPaymentStrategy implements PagamentoStrategy {

    @Autowired
    private BacenService bacenService;

    @Override
    public void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {
        if (informacoesPagamento.getIdTransacaoPix() != null) {
            bacenService.processaPix(informacoesPagamento.getIdTransacaoPix(), valor);
        } else {
            bacenService.geraChavePixParaPagamento(paciente.getChavePix(), valor);
        }
    }
}

