package com.programa_principal;

import com.classes.*;
import com.classes.roupas.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Método que irá exibir um pequeno título
    public static void titulo(String msg) {
        System.out.println("\n=========== " + msg + " ===========\n");
    }

    public static char tentarNovamente() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Quer tentar novamente? ['S'/'N'] ");
        char escolha = entrada.nextLine().toUpperCase().charAt(0);

        return escolha;
    }

    public static void menuCadastroUser(Loja loja) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Deseja se cadastrar no sistema da loja? ['S'/'N'] ");
        char resposta = sc.nextLine().toUpperCase().charAt(0);
        
        if (resposta == 'S') {
            titulo("CADASTRO");
            loja.cadastrar();
            System.out.println("Agradecemos sua preferência!");
        } else {
            System.out.println("Até mais!");
        }
    }

    public static char menuFuncionario(Loja loja) {
        titulo("Menu de Funcionários");
        System.out.println("1 - Remoção de usuário ou funcionário\n2 - Remover roupa\n3 - Cadastrar roupa\n4 - Sair");
        System.out.print("\nDigite a opção que você deseja: ");

        Scanner escaneador = new Scanner(System.in);
        int opcao = escaneador.nextInt();
        escaneador.nextLine();

        char escolha;
        // Sair do Menu
        if (opcao == 4) {
            return 'N';
        }
        // Removendo Funcionários ou Usuários 
        else if (opcao == 1) {
            System.out.print("Você deseja ver a lista de Funcionários e de Usuários? ['S'/'N'] ");
            escolha = escaneador.nextLine().toUpperCase().charAt(0);

            if (escolha == 'S') {
                titulo("FUNCIONARIOS");
                loja.exibirFuncionarios();

                titulo("USUARIOS");
                loja.exibirUsuarios();
            }

            System.out.print("Você quer remover um funcionário ['F'] ou um usuário ['U']? ");
            escolha = escaneador.nextLine().toUpperCase().charAt(0);

            System.out.print("\nDigite o ID da pessoa que você deseja remover: ");
            int id = escaneador.nextInt();

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
        } 
        // Remoção de roupas
        else if (opcao == 2) {
            System.out.print("Você deseja ver a lista de Roupas? ['S'/'N'] ");
            escolha = escaneador.nextLine().toUpperCase().charAt(0);

            if (escolha == 'S') {
                titulo("ROUPAS");
                loja.exibirRoupas();
            }

            System.out.print("Digite o ID da roupa que você deseja remover: ");
            int idRoupa = escaneador.nextInt();

            if (loja.verificarRoupa(idRoupa)) {
                loja.removerRoupa(idRoupa);
                System.out.println("Roupa removida com sucesso!");
            } else {
                System.out.println("Essa roupa não está cadastrada no sistema.");
            }
        }
        // Cadastro de roupa
        else {
            titulo("CADASTRO DE ROUPAS");
       
            System.out.print("Deseja cadastrar uma roupa? ['S'/'N'] ");
            char resposta = escaneador.nextLine().toUpperCase().charAt(0);
        
            if (resposta == 'S') {
                loja.cadastrarRoupa();
                System.out.println("Roupa cadastrada com sucesso!");
            }
        }

        return 'S';
    }

    public static char menuUsuario(Loja loja, Usuario user) {
        titulo("Menu de Usuários");
        System.out.println("1 - Aluguel de uma Roupa\n2 - Devolução de roupa\n3 - Sair");
        System.out.print("\nDigite a opção que você deseja: ");

        Scanner escaneador = new Scanner(System.in);
        int opcao = escaneador.nextInt(); escaneador.nextLine();

        // Sair do menu
        if (opcao == 3) {
            return 'N';
        }
        // Alugar uma roupa 
        else if (opcao == 1) {
            titulo("ALUGUEL DE ROUPA");
            if (loja.alugar(user)) {
                System.out.println("Aluguel realizado com sucesso!");
            } else {
                System.out.println("Aluguel cancelado!");
            }
        } 
        // Devolver uma roupa
        else {
            titulo("DEVOLUÇÃO DE ROUPA");
            System.out.print("Você deseja ver a lista de aluguéis realizados na nossa loja? ['S'/'N'] ");
            char escolha = escaneador.nextLine().toUpperCase().charAt(0);

            if (escolha == 'S') {
                titulo("ALUGUÉIS");
                loja.exibirAlugueis();
            }

            System.out.print("Informe o ID de um dos seus aluguéis: ");
            int idAluguel = escaneador.nextInt();
            
            char decisao = 'S';
            while (loja.verificarAluguel(idAluguel) == false) {
                System.out.println("Aluguel não encontrado no sistema.");
                decisao = tentarNovamente();

                if (decisao == 'N') {
                    break;
                } else {
                    System.out.print("Informe o ID de um dos seus aluguéis: ");
                    idAluguel = escaneador.nextInt();
                }
            }

            if (decisao == 'N') {
                System.out.println("Devolução cancelada!");
            } else {
                Aluguel aluguel = loja.getAlugueis().get(idAluguel);
                loja.devolverRoupa(aluguel, user);
            }
        }

        return 'S';
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        /*
         * Inserindo alguns dados na Loja
         * As chaves foram colocadas para que essas varíaveis sejam apagadas, uma vez
         * que elas só servem para armazenarem dados que serão enviadas ao construtor da
         * Loja.
         * Logo, elas não precisam continuar ocupando espaço no programa principal.
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

            BermudaShort b2 = new BermudaShort(roupas.size(), "Bermuda Taktel Tamanho 36", "Vermelho Listrado", true,
                    9.80);
            roupas.add(b2);

            BermudaShort b3 = new BermudaShort(roupas.size(), "Bermuda Jeans Tamanho 30", "Preto", true, 17.00);
            roupas.add(b3);

            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            Usuario u1 = new Usuario("Jonas de Samos", usuarios.size(), "Rua dos Filósofos Brabos", "99345-6712",
                    "jonas@gmail.com", "1234");
            usuarios.add(u1);

            Usuario u2 = new Usuario("Amanda de Abdera", usuarios.size(), "Rua dos Filósofos Brabos", "99436-7621",
                    "amanda@hotmail.com", "1234");
            usuarios.add(u2);

            Usuario u3 = new Usuario("Kleito de Esparta", usuarios.size(), "Rua dos Filósofos Brabos", "99323-3232",
                    "kleitin@outlook.com", "1234");
            usuarios.add(u3);

            ArrayList<FuncionarioLoja> funcionarios = new ArrayList<FuncionarioLoja>();
            FuncionarioLoja f1 = new FuncionarioLoja("Marcus Cauê", funcionarios.size(), "Rua Pref. Leonardo, 88",
                    "99404-6892", "caue@gerencia.com.br", "1234", "Gerente");
            funcionarios.add(f1);

            FuncionarioLoja f2 = new FuncionarioLoja("Paula Miranda Barbosa", funcionarios.size(),
                    "Rua Pref. Leonardo, 88", "99404-6892", "paula@gerencia.com.br", "1234", "Desenvolvedora");
            funcionarios.add(f2);

            FuncionarioLoja f3 = new FuncionarioLoja("Priscila Mayumi", funcionarios.size(), "Rua Pref. Leonardo, 88",
                    "99404-6892", "pri@gerencia.com.br", "1234", "Gerente");
            funcionarios.add(f3);

            ArrayList<Aluguel> alugueis = new ArrayList<Aluguel>();

            loja = new Loja(nome, rua, tel, email, roupas, usuarios, funcionarios, alugueis);
        }

        Usuario usuarioLogado = null; FuncionarioLoja funcionarioLogado = null;

        titulo("Bem-vindo à loja Mirna's Fashion Look!");
        
        // Variáveis que vão controlar as decisões do usuário ao longo do programa
        char option;  // Controla o Login
        int escolha = 1;    // Controla o Menu Inicial
        char decisao; // Controla os Menus de Usuario e de Funcionario

        // PROGRAMA PRINCIPAL
        while (escolha != 3) {
            // Menu Inicial
            titulo("Menu Inicial");
            System.out.println("1 - Cadastrar-se no sistema\n2 - Fazer o login\n3 - Sair");
            System.out.print("\nDigite a sua escolha: ");
            escolha = entrada.nextInt(); entrada.nextLine();

            // Cadastro de Usuario ou Funcionario
            if (escolha == 1) {
                menuCadastroUser(loja);
            } 
            // Login
            else if (escolha == 2) {
                option = 'S';
                while (option == 'S') {
                    titulo("LOGIN");
                    System.out.print("Insira o seu email: ");
                    String emailLogin = entrada.nextLine();
                    System.out.print("Digite a sua senha: ");
                    String senhaLogin = entrada.nextLine();

                    // Caso em que o email é inválido
                    if (loja.checaEmail(emailLogin) == false) {
                        System.out.println("Talvez você tenha informado um email inválido");
                        option = tentarNovamente();
                        // Caso o usuário não consiga logar, perguntar se ele deseja se cadastrar
                        if (option == 'N') {
                            menuCadastroUser(loja);
                        }
                    }
                    // Verifica se existe um funcionário cadastrado com esse email
                    else if (emailLogin.endsWith("@gerencia.com.br")) {
                        funcionarioLogado = loja.getFuncionario(emailLogin);

                        if (funcionarioLogado == null) {
                            System.out.println("Este funcionário não está cadastrado na loja");
                            option = tentarNovamente();
                            // Caso o usuário não consiga logar, perguntar se ele deseja se cadastrar
                            if (option == 'N') {
                                menuCadastroUser(loja);
                            }
                        }
                        // Verifica se a senha informada condiz com a senha cadastrada
                        else {
                            String senhaFuncionario = funcionarioLogado.getSenha();

                            if (senhaLogin.equals(senhaFuncionario) == false) {
                                System.out.println("Este funcionário não está cadastrado na loja");
                                option = tentarNovamente();
                                // Caso o usuário não consiga logar, perguntar se ele deseja se cadastrar
                                if (option == 'N') {
                                    menuCadastroUser(loja);
                                }
                            } else {
                                System.out.println("Seja bem-vindo!");
                                
                                // Menu de Ações do Funcionário
                                decisao = 'S';
                                while (decisao == 'S') {
                                    decisao = menuFuncionario(loja);
                                }
                                option = 'N';
                            }
                        }
                    }
                    // Verifica se existe um usuário cadastrado com esse email
                    else {
                        usuarioLogado = loja.getUsuario(emailLogin);

                        if (usuarioLogado == null) {
                            System.out.println("Este usuário não está cadastrado na loja");
                            option = tentarNovamente();
                            // Caso o usuário não consiga logar, perguntar se ele deseja se cadastrar
                            if (option == 'N') {
                                menuCadastroUser(loja);
                            }
                        }
                        // Verifica se a senha informada condiz com a senha cadastrada
                        else {
                            String senhaUsuario = usuarioLogado.getSenha();
                            if (senhaUsuario.equals(senhaLogin) == false) {
                                System.out.println("Este usuário não está cadastrado na loja");
                                option = tentarNovamente();
                                // Caso o usuário não consiga logar, perguntar se ele deseja se cadastrar
                                if (option == 'N') {
                                    menuCadastroUser(loja);
                                }
                            } else {
                                System.out.println("Seja bem-vindo!");
                                
                                // Menu de Ações do Usuário
                                decisao = 'S';
                                while (decisao == 'S') {
                                    decisao = menuUsuario(loja, usuarioLogado);
                                }
                                option = 'N';
                            }
                        }
                    }
                }
            }
        }
       
        entrada.close();
        titulo("Muito obrigado e volte sempre!");
    }

}
