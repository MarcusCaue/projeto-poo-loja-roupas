package com;

import com.classes.*;
import com.classes.Functions;
import com.classes.roupas.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner entrada = new Scanner(System.in);

    Loja loja = new Loja();
    
    Usuario usuarioLogado = null;
    FuncionarioLoja funcionarioLogado = null;
    
    // Objeto que traz funções que são usadas com frequência no programa principal
    Functions func = new Functions(loja, entrada);

    func.titulo("Bem-vindo à loja Mirna's Fashion Look!");

    // Variáveis que vão controlar as decisões do usuário ao longo do programa
    char option = 'S'; // Controla o Login
    int escolha = 1; // Controla o Menu Inicial

    // PROGRAMA PRINCIPAL
    while (escolha != 3) {
      // Menu Inicial
      func.menu(
        "Menu Inicial",
        "1 - Cadastrar-se no sistema", "2 - Fazer o login", "3 - Sair"
      );
      
      escolha = func.leiaValidaEntrada((byte) 1, (byte) 3);

      // Cadastro de Usuario ou Funcionario
      if (escolha == 1) {
        func.menuCadastroUsuario();
      }
      // Login
      else if (escolha == 2) {
        while (option == 'S') {

          option = func.login();

          // func.titulo("LOGIN");

          // System.out.print("Insira o seu email: ");
          // String emailLogin = entrada.nextLine();

          // System.out.print("Digite a sua senha: ");
          // String senhaLogin = entrada.nextLine();

          // // Caso em que o email é inválido
          // if (loja.checaEmail(emailLogin) == false) {
          //   System.out.println("Talvez você tenha informado um email inválido");
          //   option = func.leiaValidaEntrada("Quer tentar novamente?");
          //   // Caso o usuário não consiga logar, perguntar se ele deseja se cadastrar
          //   if (option == 'N') {
          //     func.menuCadastroUsuario();
          //   }
          // }
          // // Verifica se existe um funcionário cadastrado com esse email
          // else if (emailLogin.endsWith("@gerencia.com.br")) {
          //   funcionarioLogado = loja.getFuncionario(emailLogin);

          //   if (funcionarioLogado == null) {
          //     System.out.println("Este funcionário não está cadastrado na loja");
          //     option = func.leiaValidaEntrada("Quer tentar novamente?");
          //     // Caso o usuário não consiga logar, perguntar se ele deseja se cadastrar
          //     if (option == 'N') {
          //       func.menuCadastroUsuario();
          //     }
          //   }
          //   // Verifica se a senha informada condiz com a senha cadastrada
          //   else {
          //     String senhaFuncionario = funcionarioLogado.getSenha();

          //     if (senhaLogin.equals(senhaFuncionario) == false) {
          //       System.out.println("Este funcionário não está cadastrado na loja");
          //       option = func.leiaValidaEntrada("Quer tentar novamente?");
          //       // Caso o usuário não consiga logar, perguntar se ele deseja se cadastrar
          //       if (option == 'N') {
          //         func.menuCadastroUsuario();
          //       }
          //     } else {
          //       System.out.println("Seja bem-vindo!");

          //       // Menu de Ações do Funcionário
          //       char decisao = 'S';
          //       while (decisao == 'S') {
          //         decisao = func.menuFuncionario();
          //       }
          //       option = 'N';
          //     }
          //   }
          // }
          // // Verifica se existe um usuário cadastrado com esse email
          // else {
          //   usuarioLogado = loja.getUsuario(emailLogin);

          //   if (usuarioLogado == null) {
          //     System.out.println("Este usuário não está cadastrado na loja");
          //     option = func.leiaValidaEntrada("Quer tentar novamente?");
          //     // Caso o usuário não consiga logar, perguntar se ele deseja se cadastrar
          //     if (option == 'N') {
          //       func.menuCadastroUsuario();
          //     }
          //   }
          //   // Verifica se a senha informada condiz com a senha cadastrada
          //   else {
          //     String senhaUsuario = usuarioLogado.getSenha();

          //     if (senhaUsuario.equals(senhaLogin) == false) {
          //       System.out.println("Este usuário não está cadastrado na loja");
          //       option = func.leiaValidaEntrada("Quer tentar novamente?");
          //       // Caso o usuário não consiga logar, perguntar se ele deseja se cadastrar
          //       if (option == 'N') {
          //         func.menuCadastroUsuario();
          //       }
          //     } else {
          //       System.out.println("Seja bem-vindo!");

          //       // Menu de Ações do Usuário
          //       char decisao = 'S';
          //       while (decisao == 'S') {
          //         decisao = func.menuUsuario(usuarioLogado);
          //       }
          //       option = 'N';
          //     }
          //   }
          // }
        }
      }
    }

    entrada.close();
    func.titulo("Muito obrigado e volte sempre!");
  }

}
