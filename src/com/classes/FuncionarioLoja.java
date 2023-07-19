package com.classes;

public class FuncionarioLoja extends Usuario {

    private String funcao;

    public FuncionarioLoja(String nome, int id, String email, String senha, String funcao) {
        super(nome, id, email, senha);
        this.funcao = funcao;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String toString() {
        String atributosFunc = super.toString();
        atributosFunc = atributosFunc.replace("Usuario", "FuncionarioLoja");
        atributosFunc = atributosFunc.substring(0, atributosFunc.length() - 1);
        atributosFunc += ", funcao=" + funcao + "]";
        return atributosFunc;
    }
    
}