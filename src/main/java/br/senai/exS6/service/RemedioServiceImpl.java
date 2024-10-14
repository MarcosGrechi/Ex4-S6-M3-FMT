package br.senai.exS6.service;

import br.senai.exS6.exceptions.DosagemInvalidaException;
import br.senai.exS6.exceptions.NomeRemedioInvalidoException;
import br.senai.exS6.exceptions.QuantidadeInvalidaException;
import br.senai.exS6.model.Estoque;
import br.senai.exS6.model.Remedio;
import br.senai.exS6.repository.EstoqueRepository;
import br.senai.exS6.repository.RemedioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class RemedioServiceImpl implements RemedioService {

    private final RemedioRepository remedioRepository;
    private final EstoqueRepository estoqueRepository;

    @Autowired
    public RemedioServiceImpl(RemedioRepository remedioRepository, EstoqueRepository estoqueRepository) {
        this.remedioRepository = remedioRepository;
        this.estoqueRepository = estoqueRepository;
    }

    @Override
    public void saveRemedio(String nome, Integer dosagemEmMg) {
        validarRemedio(nome, dosagemEmMg);
        Remedio remedio = new Remedio();
        remedio.setNome(nome);
        remedio.dosagemMg(dosagemEmMg);
        remedioRepository.save(remedio);
    }

    @Override
    public void addEstoque(Integer idR, Integer quantidade, String nomeR, Integer remedioDosagemMg) {
        validarQuantidade(quantidade);
        Remedio remedio = buscarOuSalvarRemedio(idR, nomeR, remedioDosagemMg);
        Estoque estoqueAtual = estoqueRepository.getEstoqueAtual(remedio.getId());

        if (estoqueAtual == null) {
            Estoque novoEstoque = new Estoque();
            novoEstoque.setIdRemedio(remedio.getId());
            novoEstoque.setQuantidade(quantidade);
            estoqueRepository.save(novoEstoque);
        } else {
            estoqueAtual.setQuantidade(estoqueAtual.getQuantidade() + quantidade);
            estoqueRepository.save(estoqueAtual);
        }
    }

    private void validarRemedio(String nome, Integer dosagemEmMg) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new NomeRemedioInvalidoException("Nome do remédio não pode ser vazio");
        }
        if (dosagemEmMg == null || dosagemEmMg < 0) {
            throw new DosagemInvalidaException("Dosagem do remédio não pode ser negativa ou nula");
        }
    }

    private void validarQuantidade(Integer quantidade) {
        if (quantidade == null || quantidade < 0) {
            throw new QuantidadeInvalidaException("Quantidade não pode ser negativa ou nula");
        }
    }

    private Remedio buscarOuSalvarRemedio(Integer id, String nome, Integer dosagem) {
        Remedio remedio;
        if (id != null && remedioRepository.existe(id)) {
            remedio = remedioRepository.getRemedioPorId(id);
        } else if (nome != null && remedioRepository.existePorNome(nome)) {
            remedio = remedioRepository.getRemedioPorNome(nome);
        } else {
            remedio = new Remedio();
            remedio.setNome(nome);
            remedio.dosagemMg(dosagem);
            Integer remedioId = remedioRepository.save(remedio);
            remedio.setId(remedioId);
        }
        return remedio;
    }
}

