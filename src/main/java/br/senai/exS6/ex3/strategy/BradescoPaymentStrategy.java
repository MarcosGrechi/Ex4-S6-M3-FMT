package br.senai.exS6.ex3.strategy;

import br.senai.exS6.ex3.exception.RegraDeNegocionException;
import br.senai.exS6.ex3.model.InformacoesPagamento;
import br.senai.exS6.ex3.model.PessoaPaciente;
import br.senai.exS6.ex3.service.BradescoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BradescoPaymentStrategy implements PagamentoStrategy {

    @Autowired
    private BradescoService bradescoService;

    @Override
    public void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {
        if (paciente.getCpf() == null) {
            throw new RegraDeNegocionException("Informação obrigatória não preenchida. Preencha o CPF.");
        }
        bradescoService.processaPagamento(paciente.getCpf(), informacoesPagamento.getCpfMedico(), valor);
    }
}
