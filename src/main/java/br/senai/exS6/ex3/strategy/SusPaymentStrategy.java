package br.senai.exS6.ex3.strategy;

import br.senai.exS6.ex3.exception.RegraDeNegocionException;
import br.senai.exS6.ex3.model.InformacoesPagamento;
import br.senai.exS6.ex3.model.PessoaPaciente;
import br.senai.exS6.ex3.service.SusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SusPaymentStrategy implements PagamentoStrategy {

    @Autowired
    private SusService susService;

    @Override
    public void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {
        if (paciente.getCpf() == null || paciente.getNumeroPis() == null) {
            throw new RegraDeNegocionException("Informações obrigatórias não preenchidas. Preencha Número do PIS e CPF.");
        }
        susService.solicitaProcessoPagamento(paciente.getCpf(), paciente.getNumeroPis(), valor);
    }
}

