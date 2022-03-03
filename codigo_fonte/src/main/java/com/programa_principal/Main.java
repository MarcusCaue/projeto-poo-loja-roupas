package com.programa_principal;

import com.classes.*;
import com.classes.roupas.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Main {

    /* public Aluguel alugar() {
        
        // Verificar se quem está alugando é um funcionário da loja ou um usuário comum;

         * import java.util.Scanner;
         * import java.util.Calendar;
         * import java.text.SimpleDateFormat;
         * 
    

        Scanner entrada = new Scanner(System.in);

        // Obtendo o usuário alugador
        System.out.println("Informe o ID do usuário que está alugando: ");
        int idUser = entrada.nextInt();
        
        while (verificarUsuario(idUser) == false || idUser != -1) {
            System.out.println("ID inválido. Talvez o usuário com esse ID não esteja cadastrado no sistema");
            System.out.println("Informe um outro ID.\nCaso queira encerrar o aluguel, digite '-1': ");
            idUser = entrada.nextInt();
        }

        if (idUser == -1) {
            return null;
        } else {
            Usuario alugador = loja.getUsuarios().get(idUser);

            // Obtendo a roupa a ser alugada
            System.out.println("Informe o ID da roupa a ser alugada: ");
            int idRoupa = entrada.nextInt();
            
            while (verificarRoupa(idRoupa) == false || idRoupa != -1) {
                System.out.println("ID inválido. Talvez essa roupa com esse ID não esteja cadastrada no sistema.");
                System.out.println("Informe um outro ID.\nCaso queira encerrar o aluguel, digite '-1': ");
                idRoupa = entrada.nextInt();
            }

            if (idRoupa == -1) {
                return null;
            } else {
                Roupa roupaAlugada = loja.getRoupas().get(idRoupa);

                // Obtendo a quantidade de semanas que o usuário deseja alugar a roupa
                System.out.println("Por quantas semanas você quer alugar a roupa? (R$ 15.00 por semana): ");
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
                Aluguel a1 = new Aluguel(loja.getAlugueis().size(), dataInicioAluguel, dataFimAluguel, roupaAlugada, precoAluguel, alugador);

                return a1;
            }
        }
    } */

    // Método que irá exibir um pequeno título
    public static void titulo(String msg) {
        System.out.println("\n=========== " + msg + " ===========\n");
    }

    // Método que vai checar se o email informado faz parte da lista de emails aceitos pela loja
    public static boolean checaEmail(String email) {

		String dominio = "";

		// Verificando se existe um @ no email informado
		if (email.indexOf("@") == -1) {
			return false;
		}

		// Obtendo o domínio
		dominio = email.substring(email.indexOf("@"));

		// Lista de domínios aceitos
		ArrayList<String> listaDominios = new ArrayList<>();
		listaDominios.add("@gmail.com");
		listaDominios.add("@hotmail.com");
		listaDominios.add("@outlook.com");
		listaDominios.add("@gerencia.com.br");

		// Verificando se o email informado contém um domínio válido
		if (listaDominios.contains(dominio))
			return true;

		return false;
	}

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Inserindo alguns dados na Loja
        Loja loja;

        // As chaves foram colocadas para que essas varíaveis sejam apagadas, uma vez que elas só servem para armazenarem dados que serão enviadas ao construtor da Loja.
        // Logo, elas não precisam estar ocupando espaço no programa principal.
        {
            String nome = "Mirna's Fashion Look©";
            String rua = "Rua das Roupas Mais Lindas do Mundo, nº 85";
            String tel = "083 99405-8932";
            String email = "mirnasFLookComercial@gmail.com";

            ArrayList<Roupa> roupas = new ArrayList<Roupa>();
            Pajem p1 = new Pajem(roupas.size(), "Pajem Masculino Tamanho P", "Branco", true, 27.00);
            Pajem p2 = new Pajem(roupas.size(), "Pajem Masculino Tamanho M", "Preto", true, 27.00);
            Pajem p3 = new Pajem(roupas.size(), "Pajem Masculino Tamanho P", "Azul", true, 27.00);
            BermudaShort b1 = new BermudaShort(roupas.size(), "Short Jeans Tamanho 34", "Azul Escuro", true, 15.00);
            BermudaShort b2 = new BermudaShort(roupas.size(), "Bermuda Taktel Tamanho 36", "Vermelho Listrado", true, 9.80);
            BermudaShort b3 = new BermudaShort(roupas.size(), "Bermuda Jeans Tamanho 30", "Preto", true, 17.00);

            roupas.add(p1);
            roupas.add(p2);
            roupas.add(p3);
            roupas.add(b1);
            roupas.add(b2);
            roupas.add(b3);

            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
            Usuario u1 = new Usuario("Jonas de Samos", usuarios.size(), "Rua dos Filósofos Brabos", "99345-6712", "jonas@gmail.com", "1234");
            Usuario u2 = new Usuario("Amanda de Abdera", usuarios.size(), "Rua dos Filósofos Brabos", "99436-7621", "amanda@hotmail.com", "1234");
            Usuario u3 = new Usuario("Kleito de Esparta", usuarios.size(), "Rua dos Filósofos Brabos", "99323-3232", "kleitin@outlook.com", "1234");

            usuarios.add(u1);
            usuarios.add(u2);
            usuarios.add(u3);

            ArrayList<FuncionarioLoja> funcionarios = new ArrayList<FuncionarioLoja>();
            FuncionarioLoja f1 = new FuncionarioLoja("Marcus Cauê", funcionarios.size(), "Rua Pref. Leonardo, 88", "99404-6892", "caue@gerencia.com.br", "1234", "Desenvolvedor");
            FuncionarioLoja f2 = new FuncionarioLoja("Paula Miranda Barbosa", funcionarios.size(), "Rua Pref. Leonardo, 88", "99404-6892", "paula@gerencia.com.br", "1234", "Desenvolvedora");
            FuncionarioLoja f3 = new FuncionarioLoja("Priscila Mayumi", funcionarios.size(), "Rua Pref. Leonardo, 88", "99404-6892", "pri@gerencia.com.br", "1234", "Arquiteta de Software");

            funcionarios.add(f1);
            funcionarios.add(f2);
            funcionarios.add(f3);

            ArrayList<Aluguel> alugueis = null;

            loja = new Loja(nome, rua, tel, email, roupas, usuarios, funcionarios, alugueis);
        }

        Usuario usuarioLogado; FuncionarioLoja funcionarioLogado;

        /* Tela de Login */
        // Variável que faz com que o usuário do sistema fique na tela de login até informar as credenciais que estejam cadastradas no sistema ou desista de tentar logar no mesmo.
        char option = 'S'; 
        while (option == 'S') {
            titulo("LOGIN");
            System.out.print("Insira o seu email: ");
            String emailLogin = entrada.nextLine();
            System.out.print("Digite a sua senha: ");
            String senhaLogin = entrada.nextLine();
    
            // Caso em que o email é inválido
            if (checaEmail(emailLogin) ==  false) {
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

        }

        /* Tela de Opções */
        while (option == 'S') {

        }
        
        titulo("Muito obrigado e volte sempre!");

    }

}
