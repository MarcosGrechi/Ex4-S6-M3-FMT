package br.senai.exS6.model;

public class Remedio {
    private Integer id;
    private String nome;
    private Integer dosagemMg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getDosagemMg() {
        return dosagemMg;
    }

    public void dosagemMg(Integer dosagemMg) {
        this.dosagemMg = dosagemMg;
    }
}
