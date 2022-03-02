package com.programa_principal;

import java.util.Scanner;

import com.classes.FuncionarioLoja;
import com.classes.Usuario;
import java.util.ArrayList;

public class CadastroUser {
	
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

	public static boolean cadastrar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("======= Bem-vindo à loja Mirna's Fashion Look! =======");
		System.out.println("Comece seu cadastro para poder alugar as roupas da nossa loja!\n");
		
		// Leitura do nome do usuário
		String username = "";
		do {

			System.out.print("Digite o seu nome completo: ");
			username = sc.nextLine();

		} while (username.equals(""));

		// Leitura do endereço
		String endereco = "";
		do {

			System.out.print("Digite o seu endereço: ");
			endereco = sc.nextLine();

		} while (endereco.equals(""));

		// Leitura do(s) telefone(s)
		String tel = "";
		do {

			System.out.print("Digite o número de seu telefone: ");
			tel = sc.nextLine();

		} while (tel.equals(""));
	
		// Leitura do(s) email(s)
		String email = "";
		do {

			System.out.print("Digite um e-mail válido para contato: ");
			email = sc.nextLine();

		} while (email.equals("") || checaEmail(email) == false);
	
		
		// Leitura da Senha
		String senha = "";
		do {

			System.out.print("Digite uma senha: ");
			senha = sc.nextLine();

		} while (senha.equals(""));

		// Criando um Usuário ou um Funcionário da Loja

		// Caso o usuário tenha uma conta de funcionário da loja, cria-se um objeto da classe FuncionarioLoja
		if (email.endsWith("@gerencia.com.br")) {

			// Leitura da função dele dentro da loja
			String funcao = "";
			do {

				System.out.print("Informe a sua função na loja: ");
				funcao = sc.nextLine();
			
			} while (funcao.equals(""));

			FuncionarioLoja funcionario = new FuncionarioLoja(username, 0, endereco, tel, email, senha, funcao);

		} else {
			// Do contrário, cria-se um usuário simples (cliente)
			Usuario usuario = new Usuario(username, 0, endereco, tel, email, senha);
		}

		return true;
	}

	public static void main(String[] args) {
		cadastrar();
	}
}
