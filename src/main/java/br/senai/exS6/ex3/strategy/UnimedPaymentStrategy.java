package br.senai.exS6.ex3.strategy;

import br.senai.exS6.ex3.exception.RegraDeNegocionException;
import br.senai.exS6.ex3.model.InformacoesPagamento;
import br.senai.exS6.ex3.model.PessoaPaciente;
import br.senai.exS6.ex3.service.UnimedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnimedPaymentStrategy implements PagamentoStrategy {

    @Autowired
    private UnimedService unimedService;

    @Override
    public void processaPagamento(PessoaPaciente paciente, InformacoesPagamento informacoesPagamento, Float valor) {
        if (paciente.getNumeroConvenio() == null || paciente.getCpf() == null) {
            throw new RegraDeNegocionException("Informações obrigatórias não preenchidas. Preencha Número de Convênio e CPF.");
        }
        unimedService.processaPagamento(paciente.getCpf(), paciente.getNumeroConvenio(), informacoesPagamento.getCpfMedico());
    }
}
