package com.classes;

import com.classes.roupas.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

public class Loja {
    // Atributos
    private String nome;
    private String email;
    private ArrayList<Roupa> roupas;
    private ArrayList<Usuario> usuariosCadastrados;
    private ArrayList<FuncionarioLoja> funcionarios;
    private ArrayList<Aluguel> alugueis;

    // Construtor
    public Loja(String novoNome, String novoEmail, ArrayList<Roupa> novasRoupas, ArrayList<Usuario> novosUserCadastrados, ArrayList<FuncionarioLoja> novosFuncionarios, ArrayList<Aluguel> novosAlugueis) {
        this.nome = novoNome;
        this.email = novoEmail;
        this.roupas = novasRoupas;
        this.usuariosCadastrados = novosUserCadastrados;
        this.funcionarios = novosFuncionarios;
        this.alugueis = novosAlugueis;
    }

    // Métodos
    
    // Método que vai checar se o email informado faz parte da lista de emails aceitos pela loja
    public boolean checaEmail(String email) {

		String dominio = "";

		// Verificando se existe um @ no email informado
		if (email.indexOf("@") == -1) {
			return false;
		}

		// Obtendo o domínio
		dominio = email.substring(email.indexOf("@"));

		// Lista de domínios aceitos
		ArrayList<String> listaDominios = new ArrayList<String>();
		listaDominios.add("@gmail.com");
		listaDominios.add("@hotmail.com");
		listaDominios.add("@outlook.com");
		listaDominios.add("@gerencia.com.br");

		// Verificando se o email informado contém um domínio válido
		if (listaDominios.contains(dominio)) {
			return true;
        }

		return false;
	}
    
    public boolean cadastrar() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Comece seu cadastro para poder alugar as roupas da nossa loja!\n");
		
		// Leitura do nome do usuário
		String username = "";
		do {
			System.out.print("Digite o seu nome completo: ");
			username = sc.nextLine();
		} while (username.equals(""));
	
		// Leitura do email
        String email = "";
        do {
            System.out.print("Digite um e-mail válido para contato: ");
            email = sc.nextLine();
        } while (email.equals("") || checaEmail(email) == false);
	
		// Leitura da Senha
		String senha = "";
		do {
			System.out.print("Digite uma senha válida: ");
			senha = sc.nextLine();
		} while(senha.equals(""));

        if (email.endsWith("@gerencia.com.br")) {

            // Leitura da função do funcionário da loja
            String funcao = "";
            do {
                System.out.print("Digite a sua função dentro da loja: ");
                funcao = sc.nextLine();
            } while (funcao.equals(""));

            FuncionarioLoja funcionario = new FuncionarioLoja(username, this.funcionarios.size(), email, senha, funcao);
            this.funcionarios.add(funcionario);
        } else {
            Usuario user = new Usuario(username, this.usuariosCadastrados.size(), email, senha);
            this.usuariosCadastrados.add(user);
        }
	
        return true;
	}
    
    public boolean cadastrarRoupa() {
		Scanner sc = new Scanner(System.in);

        String nome = "";
		do {
			System.out.print("Digite o nome da roupa: ");
			nome = sc.nextLine();
		} while(nome.equals(""));

        ArrayList<String> tiposRoupa = new ArrayList<String>();
        tiposRoupa.add("vestido");
        tiposRoupa.add("calca");
        tiposRoupa.add("bermuda/short");
        tiposRoupa.add("camisa");
        tiposRoupa.add("pajem");
        tiposRoupa.add("terno");

        String tipo = "";
        do {
            System.out.print("Digite o tipo da roupa ['vestido', 'calca', 'camisa', 'bermuda/short', 'pajem', 'terno']: ");
            tipo = sc.nextLine();
        } while (tipo.equals("") || tiposRoupa.contains(tipo) == false);

        String cor = "";
        do {
            System.out.print("Digite a cor da roupa: ");
		    cor = sc.nextLine();
        } while (cor.equals(""));

		System.out.print("Digite o preço da da roupa: ");
		double precoInicial = sc.nextDouble();
        
		boolean disponibilidade = true;

        if (tipo.equals("vestido")) {
            Vestido v1 = new Vestido(this.roupas.size(), nome, cor, disponibilidade, precoInicial);
            this.roupas.add(v1);
        } else if (tipo.equals("calca")) {
            Calca c1 = new Calca(this.roupas.size(), nome, cor, disponibilidade, precoInicial);
            this.roupas.add(c1);
        } else if (tipo.equals("bermuda/short")) {
            BermudaShort bs1 = new BermudaShort(this.roupas.size(), nome, cor, disponibilidade, precoInicial);
            this.roupas.add(bs1);
        } else if (tipo.equals("camisa")) {
            Camisa c1 = new Camisa(this.roupas.size(), nome, cor, disponibilidade, precoInicial);
            this.roupas.add(c1);
        } else if (tipo.equals("pajem")) {
            Pajem p1 = new Pajem(this.roupas.size(), nome, cor, disponibilidade, precoInicial);
            this.roupas.add(p1);
        } else {
            Terno t1 = new Terno(this.roupas.size(), nome, cor, disponibilidade, precoInicial);
            this.roupas.add(t1);
        }

        return true;
	}

    public boolean verificarUsuario(int idUser){
        if (idUser < 0) {
            return false;
        }

        for(int i = 0; i < this.usuariosCadastrados.size(); i++){
            if (this.usuariosCadastrados.get(i).getId() == idUser){
                return true;
            }
        }
        return false;
    }

    public boolean verificarRoupa(int idRoupa){
        if (idRoupa < 0) {
            return false;
        }

        for(int i = 0; i < this.roupas.size(); i++){
            if(this.roupas.get(i).getId() == idRoupa){
                return true;
            }
        }

        return false;
    }

    public boolean verificarFuncionario(int idFunc){
        if (idFunc < 0) {
            return false;
        }

        for(int i = 0; i < this.funcionarios.size(); i++){
            if(this.funcionarios.get(i).getId() == idFunc){
                return true;
            }
        }
        return false;
    }

    public boolean verificarAluguel(int idAluguel) {
        if (idAluguel < 0) {
            return false;
        }

		for(int i = 0; i < this.alugueis.size(); i++) {
			if(this.alugueis.get(i).getId() == idAluguel) {
                return true;
            }
		}
		return false;
	}

    public boolean removerUsuario(int idUser) {
        if (verificarUsuario(idUser) == false){
            return false;
        }
        else{
            for(int i = 0; i < this.usuariosCadastrados.size(); i++) {
                if(this.usuariosCadastrados.get(i).getId() == idUser){
                    this.usuariosCadastrados.remove(i);
                }
            }
            return true;
        }
    }

    public boolean removerFuncionario(int idFunc) {
        if (verificarFuncionario(idFunc) == false){
            return false;
        }
        else{
            for(int i = 0; i < this.funcionarios.size(); i++) {
                if(this.funcionarios.get(i).getId() == idFunc){
                    this.funcionarios.remove(i);
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
            for(int i = 0; i < this.roupas.size(); i++){
                if(this.roupas.get(i).getId() == idRoupa){
                    this.roupas.remove(i);
                }
            }
        }
        return true;
    }

    public boolean alugar(Usuario user) {
        Scanner entrada = new Scanner(System.in);
        
        // Obtendo o id do usuário alugador
        int idUser = user.getId();

        Usuario alugador = this.getUserCadastrados().get(idUser);

        // Obtendo a roupa a ser alugada
        char escolha;
        System.out.print("Você deseja ver a lista de Roupas cadastradas? ['S'/'N'] ");
        escolha = entrada.nextLine().toUpperCase().charAt(0);

        if (escolha == 'S') {
            System.out.println("\n=========== " + "ROUPAS" + " ===========\n");
            exibirRoupas();
        }

        System.out.print("\nInforme o ID da roupa a ser alugada: ");
        int idRoupa = entrada.nextInt(); entrada.nextLine();
        
        while (idRoupa != -1 && verificarRoupa(idRoupa) == false) {
            System.out.println("ID inválido. Talvez essa roupa com esse ID não esteja cadastrada no sistema.");
            System.out.print("Informe um outro ID.\nCaso queira encerrar o aluguel, digite '-1': ");
            idRoupa = entrada.nextInt(); entrada.nextLine();
        }

        if (idRoupa == -1) {
            return false;
        } else {
            Roupa roupaAlugada = this.getRoupas().get(idRoupa);

            if (roupaAlugada.getDisponibilidade() == true) {
                // Tirando a disponibilidade da roupa
                roupaAlugada.setDisponibilidade(false);
            } else {
                System.out.println("Essa roupa já está alugada!");
                return false;
            }

            // Obtendo a quantidade de semanas que o usuário deseja alugar a roupa
            System.out.print("\nPor quantas semanas você quer alugar a roupa? (R$ 15.00 por semana): ");
            int quantSemanas = entrada.nextInt(); entrada.nextLine();

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

            // Mostrando o preço do aluguel
            System.out.printf("Preço final do aluguel: R$%,.2f\n", precoAluguel);
            // Criando o aluguel
            Aluguel a1 = new Aluguel(this.getAlugueis().size(), dataInicioAluguel, dataFimAluguel, roupaAlugada, precoAluguel, alugador);

            alugueis.add(a1);
            
            return true;
        }
    }

    public void devolverRoupa(int idAluguel, Usuario user_Devolve) {

        Aluguel aluguel = null;

        for (int i = 0; i < this.alugueis.size(); i++) {
            if (this.alugueis.get(i).getId() == idAluguel) {
                aluguel = this.alugueis.get(i);
            }
        }

        if (aluguel.getAlugador().equals(user_Devolve)) {

            //Checando se a devolução foi feita no prazo
            // Caso queira testar essa função de multa (mostrando o valor), basta colocar um número negativo na quantidade de semanas quando estiverdes fazendo o aluguel.
            double multa = emitirMulta(aluguel.getDataFim());
                    
            if (multa == 0) {
                System.out.println("Devolução concluída no prazo!\nMuito obrigado por alugar na nossa loja.");
            } else {
                System.out.println("Oh-Ow, devolução feita fora do prazo.\nA multa aplicada foi de " + multa);
            }

            // Mudando a disponibilidade da roupa devolvida
            aluguel.getRoupa().setDisponibilidade(true);
            // Removendo o aluguel da lista
            this.alugueis.remove(aluguel);

        } else {
            System.out.println("Você não é o usuário responsável pelo aluguel dessa roupa!");
            System.out.println("Devolução cancelada!");
        }

    }

    public double emitirMulta(String dataFim) {
		LocalDate dataAtual = LocalDate.now();
		int ano = Integer.parseInt(dataFim.substring(6));
		int mes = Integer.parseInt(dataFim.substring(3, 5));
		int dia = Integer.parseInt(dataFim.substring(0, 2));

		LocalDate dataFinal = LocalDate.of(ano, mes, dia);
		Period periodo = Period.between(dataAtual, dataFinal);
		int qtdDias = periodo.getDays() + periodo.getMonths() * 30;
        
        double multa = 0;
        if (qtdDias < 0) {
            multa = (qtdDias * 1.50) * -1;
        }

		return multa;
	}

    public void exibirUsuarios(){
        for(int i = 0;i < usuariosCadastrados.size();i++){
            System.out.println("Nome: " + usuariosCadastrados.get(i).getNome());
            System.out.println("Id: " + usuariosCadastrados.get(i).getId());
            System.out.println();
        }
    }
    
    public void exibirFuncionarios(){
        for(int i = 0;i < funcionarios.size();i++){
            System.out.println("Nome: " + funcionarios.get(i).getNome());
            System.out.println("Id: " + funcionarios.get(i).getId());
            System.out.println();
        }
    }

    public void exibirAlugueis() {
		for(int i = 0; i < alugueis.size();i++){
            Aluguel aluguelVerificado = alugueis.get(i);

            System.out.println("Aluguel de Código: " + aluguelVerificado.getId());
            System.out.println("Data do Início do Aluguel: " + aluguelVerificado.getDataInicio());
            System.out.println("Data do Fim do Aluguel: " + aluguelVerificado.getDataFim());
            System.out.println("Usuário alugador: " + aluguelVerificado.getAlugador().getNome());
            System.out.println("Roupa alugada: " + aluguelVerificado.getRoupa().getNome());
            System.out.println();
        }
	}

    public void exibirRoupas() {
		for(int i = 0; i < roupas.size();i++){
            System.out.println("Nome: " + roupas.get(i).getNome());
            System.out.printf("Preço: R$%.2f\n", roupas.get(i).getPrecoInicial());
            System.out.println("Id: " + roupas.get(i).getId());
            System.out.println("Disponibilidade: " + roupas.get(i).getDisponibilidade());
            System.out.println();
        }
	}

    // Getters e Setters
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return this.usuariosCadastrados;
    }

    public void setUserCadastrados(ArrayList<Usuario> usuariosCadastrados) {
        this.usuariosCadastrados = usuariosCadastrados;
    }

    public Usuario getUsuario(String email) {
        for (Usuario usuario : this.usuariosCadastrados) {
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