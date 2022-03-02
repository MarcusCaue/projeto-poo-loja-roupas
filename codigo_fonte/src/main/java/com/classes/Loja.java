package com.classes;

import java.util.ArrayList;
import com.classes.roupas.Roupa;

public class Loja {
    // Atributos
    String nome;
    String endereco;
    String tel;
    String email;
    ArrayList<Roupa> roupas;
    ArrayList<Usuario> userCadastrados;
    ArrayList<FuncionarioLoja> funcionarios;
    ArrayList<Aluguel> alugueis;

    // Construtor
    public Loja(String novoNome, String novoEndereco, String novoTel, String novoEmail, ArrayList<Roupa> novasRoupas, ArrayList<Usuario> novosUserCadastrados, ArrayList<FuncionarioLoja> novosFuncionarios, ArrayList<Aluguel> novosAlugueis) {
        this.nome = novoNome;
        this.endereco = novoEndereco;
        this.tel = novoTel;
        this.email = novoEmail;
        this.roupas = novasRoupas;
        this.userCadastrados = novosUserCadastrados;
        this.funcionarios = novosFuncionarios;
        this.alugueis = novosAlugueis;
    }

    // Getters e Setters
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Roupa> getRoupas() {
        return this.roupas;
    }

    public void setRoupas(ArrayList<Roupa> roupas) {
        this.roupas = roupas;
    }

    public ArrayList<Usuario> getUserCadastrados() {
        return this.userCadastrados;
    }

    public void setUserCadastrados(ArrayList<Usuario> userCadastrados) {
        this.userCadastrados = userCadastrados;
    }

    public ArrayList<FuncionarioLoja> getFuncionarios() {
        return this.funcionarios;
    }

    public void setFuncionarios(ArrayList<FuncionarioLoja> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public ArrayList<Aluguel> getAlugueis() {
        return this.alugueis;
    }

    public void setAlugueis(ArrayList<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    // Métodos
    
}
