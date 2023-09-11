package com.classes;

import java.util.Scanner;
import java.util.regex.Pattern;

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

    this.sc.nextLine();

    return opcao;
  }

  public char leiaValidaEntrada(String msg) {
    System.out.print(msg + " ['S'/'N'] ");
    char escolha = this.sc.nextLine().toUpperCase().charAt(0);

    while (escolha != 'S' && escolha != 'N') {
      System.out.print("Valor inválido. Digite novamente a opção que você deseja: ");
      escolha = this.sc.nextLine().toUpperCase().charAt(0);
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
    this.titulo("CADASTRO");
    loja.cadastrar(this.sc);
    System.out.println("Agradecemos sua preferência!");
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

  public boolean validaEmail(String email) {
    // Verificando se é um email válido -> Pattern obtido da Internet, com algumas
    // adaptações
    Pattern regex = Pattern
        .compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@(gmail.com|outlook.com|hotmail.com|gerencia.com.br)$");

    if (regex.matcher(email).find()) {
      return true;
    }

    return false;
  }

  public void desejaCadastrar() {
    char desejaCadastrar = this.leiaValidaEntrada("Deseja se cadastrar?");

    if (desejaCadastrar == 'S')
      this.menuCadastroUsuario();
  }

  public char loginFunc(FuncionarioLoja funcionario, String email, String senha) {
    char option = 'N';

    // Funcionário não cadastrado
    if (funcionario == null) {
      System.out.println("Este funcionário não está cadastrado na loja");
      option = this.leiaValidaEntrada("Quer tentar novamente?");

      // Tela de cadastro
      if (option == 'N') {
        this.menuCadastroUsuario();
      }
    }
    // Verificando se a senha informada no login condiz com a senha do funcionário
    // cadastrado
    else {
      String senhaFuncionarioCadastrado = funcionario.getSenha();

      // Menu de Ações do Funcionário
      if (senhaFuncionarioCadastrado.equals(senha)) {
        System.out.println("Seja bem-vindo!");

        char continueInMenu = 'S';

        while (continueInMenu == 'S') {
          continueInMenu = this.menuFuncionario();
        }

        option = 'N';
      }

    }

    return option;
  }

  public char loginUsuario(Usuario usuario, String email, String senha) {
    char option = 'N';

    // Usuário não cadastrado
    if (usuario == null) {
      System.out.println("Este usuário não está cadastrado na loja");
      option = this.leiaValidaEntrada("Quer tentar novamente?");

      // Tela de cadastro
      if (option == 'N') 
        this.desejaCadastrar();
      
    }
    // Comparar as senhas
    else {
      String senhaUsuarioCadastrado = usuario.getSenha();

      if (senhaUsuarioCadastrado.equals(senha) == false) {
        System.out.println("Este usuário não está cadastrado na loja");
        option = this.leiaValidaEntrada("Quer tentar novamente?");

        // Caso o usuário não consiga logar, perguntar se ele deseja se cadastrar
        if (option == 'N')
          this.desejaCadastrar();

      } else {
        System.out.println("Seja bem-vindo!");

        // Menu de Ações do Usuário
        char continueInMenu = 'S';

        while (continueInMenu == 'S') {
          continueInMenu = this.menuUsuario(usuario);
        }
        option = 'N';
      }
    }

    return option;
  }

  public char login() {
    char connected = 'S';

    while (connected == 'S') {
      this.titulo("LOGIN");

      // Leitura dos dados de conexão
      System.out.print("Insira o seu email: ");
      String emailLogin = this.sc.nextLine();
      System.out.print("Digite a sua senha: ");
      String senhaLogin = this.sc.nextLine();

      // Email inválido
      if (validaEmail(emailLogin) == false) {
        System.out.println("Talvez você tenha informado um email inválido");

        connected = this.leiaValidaEntrada("Quer tentar novamente?");

        // Exibe uma tela de cadastro
        if (connected == 'N')
          this.desejaCadastrar();
      }
      // Verificando se há funcionário cadastrado com o email informado
      else if (emailLogin.endsWith("@gerencia.com.br")) {
        FuncionarioLoja funcionario = this.loja.getFuncionario(emailLogin);

        connected = this.loginFunc(funcionario, emailLogin, senhaLogin);
      }
      // Verificando se há usuário cadastrado com o email informado
      else {
        Usuario usuario = this.loja.getUsuario(emailLogin);

        connected = this.loginUsuario(usuario, emailLogin, senhaLogin);
      }

    }

    return connected;
  }

}
