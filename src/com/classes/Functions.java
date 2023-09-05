package com.classes;

import java.util.Scanner;

public class Functions {
  Loja loja;
  Scanner sc;

  public Functions(Loja loja, Scanner sc) {
    this.loja = loja;
    this.sc = sc;
  }

  public byte leiaValidaEntrada(byte primeiraOpcao, byte ultimaOpcao) {
    System.out.print("Digite a opção que você deseja: ");
    byte opcao = this.sc.nextByte();

    while (opcao < primeiraOpcao || opcao > ultimaOpcao) {
      System.out.print("Valor inválido. Digite novamente a opção que você deseja: ");
      opcao = this.sc.nextByte();
    }

    return opcao;
  }

  public char leiaValidaEntrada(String msg) {
    System.out.print(msg + " ['S'/'N'] ");
    char escolha = this.sc.next().toUpperCase().charAt(0);

    while (escolha != 'S' && escolha != 'N') {
      System.out.print("Valor inválido. Digite novamente a opção que você deseja: ");
      escolha = this.sc.next().toUpperCase().charAt(0);
    }

    return escolha;
  }

  public void titulo(String msg) {
    System.out.println("=========== " + msg + " ===========\n");
  }

  public void menu(String msgTitulo, String... opcoes) {
    this.titulo(msgTitulo);
    String menuOpcoes = "";

    for (String opcao : opcoes) {
      menuOpcoes += opcao + "\n";
    }

    System.out.println(menuOpcoes);
  }

  public void menuCadastroUsuario() {
    char escolha = this.leiaValidaEntrada("Deseja se cadastrar no sistema da loja?");

    if (escolha == 'S') {
      this.titulo("CADASTRO");
      loja.cadastrar(this.sc);
      System.out.println("Agradecemos sua preferência!");
    } else {
      System.out.println("Até mais!");
    }
  }

  public char menuUsuario(Usuario usuarioLogado) {
    this.menu(
        "Menu de Usuários",
        "1 - Aluguel de uma Roupa", "2 - Devolução de roupa", "3 - Sair");

    byte opcao = this.leiaValidaEntrada((byte) 1, (byte) 3);

    switch (opcao) {
      // Sair do menu
      case 3:
        return 'N';

      // Aluguel de uma roupa
      case 1:
        this.titulo("ALUGUEL DE ROUPA");

        if (loja.alugar(usuarioLogado, this.sc)) {
          System.out.println("Aluguel realizado com sucesso!");
        } else {
          System.out.println("Aluguel cancelado!");
        }

        break;

      // Devolução de uma roupa alugada
      case 2:
        this.titulo("DEVOLUÇÃO DE ROUPA");

        if (loja.getAlugueis().size() == 0) {
          System.out.println("Não existem aluguéis realizados na nossa loja.");
        } else {
          char escolha = this.leiaValidaEntrada("Você deseja ver a lista de aluguéis realizados na nossa loja?");

          if (escolha == 'S') {
            this.titulo("ALUGUÉIS");
            loja.exibirAlugueis();
          }

          System.out.print("Informe o ID de um dos seus aluguéis: ");
          int idAluguel = this.sc.nextInt();

          char decisao = 'S';
          while (loja.verificarAluguel(idAluguel) == false) {
            System.out.println("Aluguel não encontrado no sistema.");
            decisao = this.leiaValidaEntrada("Quer tentar novamente?");

            if (decisao == 'N') {
              System.out.println("Devolução cancelada!");
              break;
            } else {
              System.out.print("Informe o ID de um dos seus aluguéis: ");
              idAluguel = this.sc.nextInt();
            }
          }

          loja.devolverRoupa(idAluguel, usuarioLogado);
        }

        break;
    }

    return 'S';
  }

  public char menuFuncionario() {
    this.menu(
      "Menu de Funcionários", 
      "1 - Remoção de usuário ou funcionário", "2 - Remover roupa", "3 - Cadastrar roupa", "4 - Sair");

    byte opcao = this.leiaValidaEntrada((byte) 1, (byte) 4);

    char escolha;
    switch (opcao) {
      // Sair do menu
      case 4:
        return 'N';
      
      // Remoção de um usuário ou funcionário
      case 1:
        escolha = this.leiaValidaEntrada("Você deseja ver a lista de Funcionários e de Usuários?");

        if (escolha == 'S') {
          this.titulo("FUNCIONARIOS");
          this.loja.exibirFuncionarios();

          this.titulo("USUARIOS");
          this.loja.exibirUsuarios();
        }

        System.out.print("Você quer remover um funcionário ['F'] ou um usuário ['U']? ");
        escolha = this.sc.nextLine().toUpperCase().charAt(0);

        System.out.print("\nDigite o ID da pessoa que você deseja remover: ");
        int id = this.sc.nextInt();

        // Remoção de Funcionários
        if (escolha == 'F') {
          if (loja.verificarFuncionario(id)) {
            loja.removerFuncionario(id);
            System.out.println("Funcionário removido com sucesso!");
          } else {
            System.out.println("Esse funcionário não está cadastrado no sistema.");
          }
        }
        // Remoção de Usuários
        else {
          if (loja.verificarUsuario(id)) {
            loja.removerUsuario(id);
            System.out.println("Usuário removido com sucesso!");
          } else {
            System.out.println("Esse usuário não está cadastrado no sistema.");
          }
        }
        break;
      // Remoção de roupas
      case 2:
        escolha = this.leiaValidaEntrada("Você deseja ver a lista de Roupas?");

        if (escolha == 'S') {
          this.titulo("ROUPAS");
          loja.exibirRoupas();
        }

        System.out.print("Digite o ID da roupa que você deseja remover: ");
        int idRoupa = this.sc.nextInt();

        if (loja.verificarRoupa(idRoupa)) {
          loja.removerRoupa(idRoupa);
          System.out.println("Roupa removida com sucesso!");
        } else {
          System.out.println("Essa roupa não está cadastrada no sistema.");
        }
        break;
      // Cadastro de roupas
      case 3:
        this.titulo("CADASTRO DE ROUPAS");

        char resposta = this.leiaValidaEntrada("Deseja cadastrar uma roupa?");

        if (resposta == 'S') {
          loja.cadastrarRoupa(this.sc);
          System.out.println("Roupa cadastrada com sucesso!");
        }
        break;
    }

    return 'S';
  }
}
