package br.senai.exS6.repository;

import br.senai.exS6.model.Estoque;

public interface EstoqueRepository {
    Estoque getEstoqueAtual(Integer idRemedio);
    void save(Estoque estoque);
}
