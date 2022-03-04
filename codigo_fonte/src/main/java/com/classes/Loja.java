package com.classes;

import java.util.ArrayList;
import com.classes.roupas.Roupa;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;

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

    // Construtores
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

    // Métodos
    public boolean verificarUsuario(int userID){
        for(int i = 0; i < userCadastrados.size(); i++){
            if (userCadastrados.get(i).getId() == userID){
                return true;
            }
        }
        return false;
    }

    public boolean verificarRoupa(int idRoupa){
        for(int i = 0; i < roupas.size(); i++){
            if(roupas.get(i).getId() == idRoupa){
                return true;
            }
        }
        return false;
    }

    public boolean removerUser(int idUser) {
        if (verificarUsuario(idUser) == false){
            return false;
        }
        else{
            for(int i = 0; i < userCadastrados.size(); i++) {
                if(userCadastrados.get(i).getId() == idUser){
                    userCadastrados.remove(i);
                }
            }
            return true;
        }
    }

    public boolean removerRoupa(int idRoupa){
        if(verificarRoupa(idRoupa) == false){
            return false;
        }
        else{
            for(int i = 0; i < roupas.size(); i++){
                if(roupas.get(i).getId() == idRoupa){
                    roupas.remove(i);
                }
            }
        }
        return true;
    }

    public void exibirUsuarios(){
        for(int i = 0;i < userCadastrados.size();i++){
            System.out.println(userCadastrados.get(i).getNome());
        }
    }
    
    public void exibirFuncionarios(){
        for(int i = 0;i < funcionarios.size();i++){
            System.out.println(funcionarios.get(i).getNome());
        }
    }

    public Aluguel alugar() {
        
        // Verificar se quem está alugando é um funcionário da loja ou um usuário comum;
        Scanner entrada = new Scanner(System.in);

        // Obtendo o usuário alugador
        System.out.print("Informe o ID do usuário que está alugando: ");
        int idUser = entrada.nextInt();
        
        while (idUser != -1 && verificarUsuario(idUser) == false) {
            System.out.println("ID inválido. Talvez o usuário com esse ID não esteja cadastrado no sistema");
            System.out.print("Informe um outro ID.\nCaso queira encerrar o aluguel, digite '-1': ");
            idUser = entrada.nextInt();
        }

        if (idUser == -1) {
            return null;
        } else {
            Usuario alugador = this.getUserCadastrados().get(idUser);

            // Obtendo a roupa a ser alugada
            System.out.print("\nInforme o ID da roupa a ser alugada: ");
            int idRoupa = entrada.nextInt();
            
            while (idRoupa != -1 && verificarRoupa(idRoupa) == false) {
                System.out.println("ID inválido. Talvez essa roupa com esse ID não esteja cadastrada no sistema.");
                System.out.print("Informe um outro ID.\nCaso queira encerrar o aluguel, digite '-1': ");
                idRoupa = entrada.nextInt();
            }

            if (idRoupa == -1) {
                return null;
            } else {
                Roupa roupaAlugada = this.getRoupas().get(idRoupa);

                // Obtendo a quantidade de semanas que o usuário deseja alugar a roupa
                System.out.print("\nPor quantas semanas você quer alugar a roupa? (R$ 15.00 por semana): ");
                int quantSemanas = entrada.nextInt();

                // Preço do Aluguel
                double precoAluguel = roupaAlugada.getPrecoInicial() + (15 * quantSemanas);

                // Objetos para manipular a data e formatar a data no estilo dd/MM/yyyy
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                Calendar datas = Calendar.getInstance();

                // Obtém a data do sistema no momento em que o usuário está executando o programa e o formata conforme o estilo citado acima
                String dataInicioAluguel = formatador.format(datas.getTime());
                
                // Obtém a data do sistema no formato que a classe Calendar aceita
                datas.setTime(datas.getTime());

                // Manipulando a data para obter uma nova data acrescentando a quantidade de semanas informada pelo usuário
                datas.add(Calendar.WEEK_OF_MONTH, quantSemanas);

                // Formatando a data do fim do aluguel
                String dataFimAluguel = formatador.format(datas.getTime());

                // Criando o aluguel
                Aluguel a1 = new Aluguel(this.getAlugueis().size(), dataInicioAluguel, dataFimAluguel, roupaAlugada, precoAluguel, alugador);

                return a1;
            }
        }
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

    public Usuario getUsuario(String email) {
        for (Usuario usuario : this.userCadastrados) {
            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }

        return null;
    }

    public ArrayList<FuncionarioLoja> getFuncionarios() {
        return this.funcionarios;
    }
    

    public void setFuncionarios(ArrayList<FuncionarioLoja> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public FuncionarioLoja getFuncionario(String email) {
        for (FuncionarioLoja funcionario : this.funcionarios) {
            if (funcionario.getEmail().equals(email)) {
                return funcionario;
            }
        }

        return null;
    }

    public ArrayList<Aluguel> getAlugueis() {
        return this.alugueis;
    }

    public void setAlugueis(ArrayList<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

}