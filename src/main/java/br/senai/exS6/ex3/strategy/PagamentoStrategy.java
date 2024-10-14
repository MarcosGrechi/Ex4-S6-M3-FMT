package br.senai.exS6.ex3.strategy;

import br.senai.exS6.ex3.model.InformacoesPagamento;
import br.senai.exS6.ex3.model.PessoaPaciente;

public interface PagamentoStrategy {
    void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor);
}
