package br.senai.exS6.service;

public interface RemedioService {
    void saveRemedio(String nome, Integer dosagemEmMg);
    void addEstoque(Integer idR, Integer quantidade, String nomeR, Integer remedioDosagemMg);
}
