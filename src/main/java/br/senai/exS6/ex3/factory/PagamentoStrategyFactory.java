package br.senai.exS6.ex3.factory;

import br.senai.exS6.ex3.enums.FormaPagamento;
import br.senai.exS6.ex3.strategy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoStrategyFactory {

    private final UnimedPaymentStrategy unimedStrategy;
    private final BradescoPaymentStrategy bradescoStrategy;
    private final SusPaymentStrategy susStrategy;
    private final PixPaymentStrategy pixStrategy;

    @Autowired
    public PagamentoStrategyFactory(UnimedPaymentStrategy unimedStrategy,
                                    BradescoPaymentStrategy bradescoStrategy,
                                    SusPaymentStrategy susStrategy,
                                    PixPaymentStrategy pixStrategy) {
        this.unimedStrategy = unimedStrategy;
        this.bradescoStrategy = bradescoStrategy;
        this.susStrategy = susStrategy;
        this.pixStrategy = pixStrategy;
    }

    public PagamentoStrategy getStrategy(FormaPagamento formaPagamento) {
        switch (formaPagamento) {
            case CONVENIO_UNIMED:
                return unimedStrategy;
            case CONVENIO_BRADESCO:
                return bradescoStrategy;
            case SUS:
                return susStrategy;
            case PIX:
                return pixStrategy;
            default:
                throw new IllegalArgumentException("Forma de pagamento não suportada: " + formaPagamento);
        }
    }
}
