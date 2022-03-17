package com.classes;

public class FuncionarioLoja extends Usuario {

    private String funcao;

    public FuncionarioLoja(String novoNome, int novoId, String novoEmail, String novaSenha, String novaFuncao) {
        super(novoNome, novoId, novoEmail, novaSenha);
        this.funcao = novaFuncao;
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String novaFuncao) {
        this.funcao = novaFuncao;
    }

    
    public String toString() {
        String atributosFunc = super.toString();
        atributosFunc = atributosFunc.replace("Usuario", "FuncionarioLoja");
        atributosFunc = atributosFunc.substring(0, atributosFunc.length() - 1);
        atributosFunc += ", funcao=" + funcao + "]";
        return atributosFunc;
    }
    
}