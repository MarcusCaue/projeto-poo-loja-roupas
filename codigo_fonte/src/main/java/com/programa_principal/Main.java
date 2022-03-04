package com.programa_principal;

import com.classes.*;
import com.classes.roupas.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Main {

    // Método que irá exibir um pequeno título
    public static void titulo(String msg) {
        System.out.println("\n=========== " + msg + " ===========\n");
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        /* Inserindo alguns dados na Loja
         * As chaves foram colocadas para que essas varíaveis sejam apagadas, uma vez que elas só servem para armazenarem dados que serão enviadas ao construtor da Loja.
         * Logo, elas não precisam estar ocupando espaço no programa principal.
        */

        Loja loja;

        {
            String nome = "Mirna's Fashion Look©";
            String rua = "Rua das Roupas Mais Lindas do Mundo, nº 85";
            String tel = "083 99405-8932";
            String email = "mirnasFLookComercial@gmail.com";

            ArrayList<Roupa> roupas = new ArrayList<Roupa>();
            Pajem p1 = new Pajem(roupas.size(), "Pajem Masculino Tamanho P", "Branco", true, 27.00);
            roupas.add(p1);

            Pajem p2 = new Pajem(roupas.size(), "Pajem Masculino Tamanho M", "Preto", true, 27.00);
            roupas.add(p2);

            Pajem p3 = new Pajem(roupas.size(), "Pajem Masculino Tamanho P", "Azul", true, 27.00);
            roupas.add(p3);

            BermudaShort b1 = new BermudaShort(roupas.size(), "Short Jeans Tamanho 34", "Azul Escuro", true, 15.00);
            roupas.add(b1);

            BermudaShort b2 = new BermudaShort(roupas.size(), "Bermuda Taktel Tamanho 36", "Vermelho Listrado", true, 9.80);
            roupas.add(b2);

            BermudaShort b3 = new BermudaShort(roupas.size(), "Bermuda Jeans Tamanho 30", "Preto", true, 17.00);
            roupas.add(b3);

            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            Usuario u1 = new Usuario("Jonas de Samos", usuarios.size(), "Rua dos Filósofos Brabos", "99345-6712", "jonas@gmail.com", "1234");
            usuarios.add(u1);

            Usuario u2 = new Usuario("Amanda de Abdera", usuarios.size(), "Rua dos Filósofos Brabos", "99436-7621", "amanda@hotmail.com", "1234");
            usuarios.add(u2);

            Usuario u3 = new Usuario("Kleito de Esparta", usuarios.size(), "Rua dos Filósofos Brabos", "99323-3232", "kleitin@outlook.com", "1234");
            usuarios.add(u3);

            ArrayList<FuncionarioLoja> funcionarios = new ArrayList<FuncionarioLoja>();
            FuncionarioLoja f1 = new FuncionarioLoja("Marcus Cauê", funcionarios.size(), "Rua Pref. Leonardo, 88", "99404-6892", "caue@gerencia.com.br", "1234", "Gerente");
            funcionarios.add(f1);

            FuncionarioLoja f2 = new FuncionarioLoja("Paula Miranda Barbosa", funcionarios.size(), "Rua Pref. Leonardo, 88", "99404-6892", "paula@gerencia.com.br", "1234", "Desenvolvedora");
            funcionarios.add(f2);

            FuncionarioLoja f3 = new FuncionarioLoja("Priscila Mayumi", funcionarios.size(), "Rua Pref. Leonardo, 88", "99404-6892", "pri@gerencia.com.br", "1234", "Gerente");
            funcionarios.add(f3);

            ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();

            loja = new Loja(nome, rua, tel, email, roupas, usuarios, funcionarios, alugueis);
        }

        Usuario usuarioLogado; FuncionarioLoja funcionarioLogado;

        /* Tela de Login */
        // Variável que faz com que o usuário do sistema fique na tela de login até informar as credenciais que estejam cadastradas no sistema ou desista de tentar logar no mesmo.
        /* char option = 'S'; 
        while (option == 'S') {
            titulo("LOGIN");
            System.out.print("Insira o seu email: ");
            String emailLogin = entrada.nextLine();
            System.out.print("Digite a sua senha: ");
            String senhaLogin = entrada.nextLine();
    
            // Caso em que o email é inválido
            if (loja.checaEmail(emailLogin) ==  false) {
                System.out.println("Talvez você tenha informado um email inválido");
            } 
            // Verifica se existe um funcionário cadastrado com esse email
            else if (emailLogin.endsWith("@gerencia.com.br")) {
                funcionarioLogado = loja.getFuncionario(emailLogin);
    
                if (funcionarioLogado == null) {
                    System.out.println("Este funcionário não está cadastrado na loja");
                } 
                // Verifica se a senha informada condiz com a senha cadastrada
                else {
                    String senhaFuncionario = funcionarioLogado.getSenha();

                    if (senhaLogin.equals(senhaFuncionario) == false) {
                        System.out.println("Este funcionário não está cadastrado na loja");
                    }
                    else {
                        System.out.println("Seja bem-vindo!");
                        break;
                    }
                }
            } 
            // Verifica se existe um usuário cadastrado com esse email
            else {
                usuarioLogado = loja.getUsuario(emailLogin);

                if (usuarioLogado == null) {
                    System.out.println("Este usuário não está cadastrado na loja");
                }
                // Verifica se a senha informada condiz com a senha cadastrada
                else {
                    String senhaUsuario = usuarioLogado.getSenha();
                    if (senhaUsuario.equals(senhaLogin) == false) {
                        System.out.println("Este usuário não está cadastrado na loja");
                    }
                    else {
                        System.out.println("Seja bem-vindo!");
                        break;
                    }  
                }
            }

            System.out.print("Quer tentar novamente? ");
            option = entrada.nextLine().toUpperCase().charAt(0);
        } */

        /* // Caso o usuário não consiga logar, perguntar se ele deseja se cadastrar
        if (option == 'N') {
            System.out.print("Deseja se cadastrar no sistema? ");
            option = entrada.nextLine().toUpperCase().charAt(0);
            if (option == 'S') {
                titulo("CADASTRO");
                loja.cadastrar();
            }
        } */
        
        // Fazendo o cadastro de uma roupa
        titulo("CADASTRO DE ROUPA");
        loja.cadastrarRoupa(loja.getFuncionario("caue@gerencia.com.br").getFuncao());
        titulo("CADASTRO DE ROUPA");
        loja.cadastrarRoupa(loja.getFuncionario("pri@gerencia.com.br").getFuncao());
        titulo("CADASTRO DE ROUPA");
        loja.cadastrarRoupa(loja.getFuncionario("paula@gerencia.com.br").getFuncao());

        titulo("Muito obrigado e volte sempre!");

    }

}
