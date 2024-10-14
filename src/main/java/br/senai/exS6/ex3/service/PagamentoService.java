package br.senai.exS6.ex3.service;

import br.senai.exS6.ex3.enums.FormaPagamento;
import br.senai.exS6.ex3.factory.PagamentoStrategyFactory;
import br.senai.exS6.ex3.model.InformacoesPagamento;
import br.senai.exS6.ex3.model.PessoaPaciente;
import br.senai.exS6.ex3.strategy.PagamentoStrategy;
import org.springframework.beans.factory.annotation.Autowired;

public class PagamentoService {

    private final PagamentoStrategyFactory pagamentoStrategyFactory;

    @Autowired
    public PagamentoService(PagamentoStrategyFactory pagamentoStrategyFactory) {
        this.pagamentoStrategyFactory = pagamentoStrategyFactory;
    }

    public void processaPagamento(PessoaPaciente paciente,
                                  FormaPagamento formaPagamento,
                                  InformacoesPagamento informacoesPagamento,
                                  Float valor) {
        PagamentoStrategy strategy = pagamentoStrategyFactory.getStrategy(formaPagamento);
        strategy.processaPagamento(paciente, informacoesPagamento, valor);
    }
}

