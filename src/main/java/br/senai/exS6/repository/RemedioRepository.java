package br.senai.exS6.repository;

import br.senai.exS6.model.Remedio;

public interface RemedioRepository {
    boolean existe(Integer id);
    boolean existePorNome(String nome);
    Remedio getRemedioPorId(Integer id);
    Remedio getRemedioPorNome(String nome);
    Integer save(Remedio remedio);
}