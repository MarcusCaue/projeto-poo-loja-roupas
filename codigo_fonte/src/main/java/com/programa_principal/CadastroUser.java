package com.programa_principal;
import java.util.Scanner;

import com.classes.Usuario;

import java.util.ArrayList;

public class CadastroUser {
		public boolean checaEmail(String email) {
			
			String dominio = "";
			
			if(email.indexOf("@")==-1) return false;
			
			for (int i = email.indexOf("@"); i<=email.length()-1; i++) {
				dominio += email.indexOf(i);
			}
			
			if(dominio == "@gmail.com" || dominio == "@outlook.com" || dominio == "@hotmail.com") return true;
			
			return false;			
		}
		
		public boolean cadastrar(Scanner sc) {
			System.out.print("==================================\n Bem-vindos � loja <nome>! \n Comece seu cadastro para poder alugar as roupas da nossa loja! \n==================================");
			//Impedindo vari�vel vazia
			String username = "";
			do { 
				
			System.out.println("Digite o seu nome completo.");
			username = sc.nextLine();
			
			} while(username=="");
			
			String endereco = "";
			do { 
				
			System.out.println("Digite o seu endere�o.");
			endereco = sc.nextLine();
			
			} while(endereco=="");
			
			ArrayList<String> tel = new ArrayList<String>();
			
			String telefone = "";
			do { 
				
			System.out.println("Digite o n�mero de seu telefone.");
			telefone = sc.nextLine();
			
			} while(telefone=="");
			
			tel.add(telefone);
			
			ArrayList<String> email = new ArrayList<String>(); 

			String emailEnt = "";
			do { 
				
			System.out.println("Digite um e-mail v�lido para contato.");
			emailEnt = sc.nextLine();
			
			} while(emailEnt=="" || checaEmail(emailEnt)==false); 
			
			email.add(emailEnt);
			
			String senha = "";
			do {
				
				System.out.println("Digite uma senha.");
				senha = sc.nextLine();
			} while(senha == "");
			
			
			Usuario user = new Usuario(username, 0, endereco, tel, email, senha);
	
			
			return true;
			
		

	    
		
	}

}
	

