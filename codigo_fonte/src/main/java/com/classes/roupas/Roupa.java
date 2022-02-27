package com.classes.roupas;

public abstract class Roupa {
    private int id;
    private String name;
    private String cor;
    private boolean disponibilidade;
    private double precoInicial;

    protected Roupa(int id, String name, String cor, boolean disponibilidade, double precoInicial) {
        this.id = id;
        this.name = name;
        this.cor = cor;
        this.disponibilidade = disponibilidade;
        this.precoInicial = precoInicial;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
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
        return "Roupa [cor=" + cor + ", disponibilidade=" + disponibilidade + ", id=" + id + ", name=" + name
                + ", precoInicial=" + precoInicial + "]";
    }

}
