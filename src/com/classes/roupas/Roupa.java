package com.classes.roupas;

public abstract class Roupa {
    private int id;
    private String nome;
    private String cor;
    private boolean disponibilidade;
    private double precoInicial;

    protected Roupa(int id, String nome, String cor, boolean disponibilidade, double precoInicial) {
        this.id = id;
        this.nome = nome;
        this.cor = cor;
        this.disponibilidade = disponibilidade;
        this.precoInicial = precoInicial;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public double getPrecoInicial() {
        return precoInicial;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void setPrecoInicial(double precoInicial) {
        this.precoInicial = precoInicial;
    }

    @Override
    public String toString() {
        return "Roupa [cor=" + cor + ", disponibilidade=" + disponibilidade + ", id=" + id + ", nome=" + nome + ", precoInicial=" + precoInicial + "]";
    }

}
