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
    private String validaEntrada(String message, Scanner sc) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine();
        } while (value.equals(""));

        return value;
    }

    private void addRoupa(String tipoRoupa, String nomeRoupa, boolean disponibilidadeRoupa, String corRoupa, double precoInicialRoupa) {
        Roupa r;
        switch (tipoRoupa) {
            case "Vestido":
                r = new Vestido(this.roupas.size(), nomeRoupa, corRoupa, disponibilidadeRoupa, precoInicialRoupa);
                break;

            case "Terno":
                r = new Terno(this.roupas.size(), nomeRoupa, corRoupa, disponibilidadeRoupa, precoInicialRoupa);
                break;

            case "Pajem":
                r = new Pajem(this.roupas.size(), nomeRoupa, corRoupa, disponibilidadeRoupa, precoInicialRoupa);
                break;

            case "Calca":
                r = new Calca(this.roupas.size(), nomeRoupa, corRoupa, disponibilidadeRoupa, precoInicialRoupa);
                break;

            case "BermudaShort":
                r = new BermudaShort(this.roupas.size(), nomeRoupa, corRoupa, disponibilidadeRoupa, precoInicialRoupa);
                break;

            default:
                r = new Camisa(this.roupas.size(), nomeRoupa, corRoupa, disponibilidadeRoupa, precoInicialRoupa);
                break;
        }

        this.roupas.add(r);
    }

    public boolean checaEmail(String email) {

        int indexOfArroba = email.indexOf("@");

		// Verificando se existe um @ no email informado
		if (indexOfArroba == -1) {
			return false;
		}

		// Obtendo o domínio
		String dominio = email.substring(indexOfArroba);

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

    public void cadastrar(Scanner sc) {
		System.out.println("Comece seu cadastro para poder alugar as roupas da nossa loja!\n");

		// Leitura do nome do usuário
		String username = validaEntrada("Digite o seu nome completo: ", sc);
        // Leitura da Senha
        String senha = validaEntrada("Digite uma senha válida: ", sc);

		// Leitura do email
        String email;
        do {
            System.out.print("Digite um e-mail válido para contato: ");
            email = sc.nextLine();
        } while (email.equals("") || checaEmail(email) == false);

        // Cadastrando um Usuário ou Funcionário baseado no domínio do seu email
        if (email.endsWith("@gerencia.com.br")) {

            // Leitura da função do funcionário da loja
            String funcao = validaEntrada("Digite a sua função dentro da loja: ", sc);

            // Criando um Funcionario
            FuncionarioLoja funcionario = new FuncionarioLoja(username, this.funcionarios.size(), email, senha, funcao);
            this.funcionarios.add(funcionario);
        } else {
            // Criando um Usuário
            Usuario user = new Usuario(username, this.usuariosCadastrados.size(), email, senha);
            this.usuariosCadastrados.add(user);
        }

	}

    public void cadastrarRoupa(Scanner sc) {
        String nome = validaEntrada("Digite o nome da roupa: ", sc);

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

        String cor = validaEntrada("Digite a cor da roupa: ", sc);

		System.out.print("Digite o preço da da roupa: ");
		double precoInicial = sc.nextDouble();

		boolean disponibilidade = true;

        addRoupa(tipo, nome, disponibilidade, cor, precoInicial);
	}

    public boolean verificarUsuario(int idUser){
        if (idUser < 0) {
            return false;
        }
        for (Usuario usuariosCadastrado : this.usuariosCadastrados) {
            if (usuariosCadastrado.getId() == idUser) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarRoupa(int idRoupa){
        if (idRoupa < 0) {
            return false;
        }
        for (int i = 0; i < this.roupas.size(); i++){
            if (this.roupas.get(i).getId() == idRoupa){
                return true;
            }
        }
        return false;
    }

    public boolean verificarFuncionario(int idFunc){
        if (idFunc < 0) {
            return false;
        }
        for (int i = 0; i < this.funcionarios.size(); i++){
            if (this.funcionarios.get(i).getId() == idFunc){
                return true;
            }
        }
        return false;
    }

    public boolean verificarAluguel(int idAluguel) {
        if (idAluguel < 0) {
            return false;
        }
		for (int i = 0; i < this.alugueis.size(); i++) {
			if (this.alugueis.get(i).getId() == idAluguel) {
                return true;
            }
		}
		return false;
	}

    public void removerUsuario(int idUser) {
        for (int i = 0; i < this.usuariosCadastrados.size(); i++) {
            if (this.usuariosCadastrados.get(i).getId() == idUser){
                this.usuariosCadastrados.remove(i);
            }
        }
    }

    public void removerFuncionario(int idFunc) {
        for (int i = 0; i < this.funcionarios.size(); i++) {
            if (this.funcionarios.get(i).getId() == idFunc){
                this.funcionarios.remove(i);
            }
        }
    }

    public void removerRoupa(int idRoupa){
        for (int i = 0; i < this.roupas.size(); i++){
            if (this.roupas.get(i).getId() == idRoupa){
                this.roupas.remove(i);
            }
        }
    }

    public boolean alugar(Usuario user, Scanner sc) {
        // Obtendo a roupa a ser alugada
        System.out.print("Você deseja ver a lista de Roupas cadastradas? ['S'/'N'] ");
        char escolha = sc.nextLine().toUpperCase().charAt(0);

        if (escolha == 'S') {
            System.out.println("\n=========== " + "ROUPAS" + " ===========\n");
            exibirRoupas();
        }

        System.out.print("Informe o ID da roupa a ser alugada: ");
        int idRoupa = sc.nextInt(); sc.nextLine();

        while (idRoupa != -1 && verificarRoupa(idRoupa) == false) {
            System.out.println("ID inválido. Talvez essa roupa com esse ID não esteja cadastrada no sistema.");
            System.out.print("Informe um outro ID.\nCaso queira encerrar o aluguel, digite '-1': ");
            idRoupa = sc.nextInt(); sc.nextLine();
        }

        if (idRoupa == -1) {
            return false;
        } else {
            Roupa roupaAlugada = this.getRoupas().get(idRoupa);

            if (roupaAlugada.getDisponibilidade()) {
                // Tirando a disponibilidade da roupa
                roupaAlugada.setDisponibilidade(false);
            } else {
                System.out.println("Essa roupa já está alugada!");
                return false;
            }

            // Obtendo a quantidade de semanas que o usuário deseja alugar a roupa
            System.out.print("\nPor quantas semanas você quer alugar a roupa? (R$ 15.00 por semana): ");
            int quantSemanas = sc.nextInt(); sc.nextLine();

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
            System.out.printf("Preço final do aluguel: R$%.2f\n", precoAluguel);
            // Criando o aluguel
            Aluguel aluguel = new Aluguel(this.getAlugueis().size(), dataInicioAluguel, dataFimAluguel, roupaAlugada, precoAluguel, user);

            alugueis.add(aluguel);

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

            // Mudando a disponibilidade da roupa devolvida
            aluguel.getRoupa().setDisponibilidade(true);
            // Removendo o aluguel da lista
            this.alugueis.remove(aluguel);

            if (multa == 0) {
                System.out.println("Devolução concluída no prazo!\nMuito obrigado por alugar na nossa loja.");
            } else {
                System.out.printf("Oh-Ow, devolução feita fora do prazo.\nA multa aplicada foi de R$%.2f\n", multa);
            }
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
        for (Usuario usuariosCadastrado : usuariosCadastrados) {
            System.out.println("Nome: " + usuariosCadastrado.getNome());
            System.out.println("Id: " + usuariosCadastrado.getId());
            System.out.println();
        }
    }

    public void exibirFuncionarios(){
        for (FuncionarioLoja funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Id: " + funcionario.getId());
            System.out.println("Função: " + funcionario.getFuncao());
            System.out.println();
        }
    }

    public void exibirAlugueis() {
        for (Aluguel alguelAtual : alugueis) {
            System.out.println("Aluguel de Código: " + alguelAtual.getId());
            System.out.println("Data do Realização do Aluguel: " + alguelAtual.getDataInicio());
            System.out.println("Data do Fim do Aluguel: " + alguelAtual.getDataFim());
            System.out.println("Usuário alugador: " + alguelAtual.getAlugador().getNome());
            System.out.println("Roupa alugada: " + alguelAtual.getRoupa().getNome());
            System.out.println();
        }
	}

    public void exibirRoupas() {
        for (Roupa roupa : roupas) {
            System.out.println("Nome: " + roupa.getNome());
            System.out.printf("Preço: R$%.2f\n", roupa.getPrecoInicial());
            System.out.println("Id: " + roupa.getId());
            System.out.println("Disponibilidade: " + roupa.getDisponibilidade());
            System.out.println();
        }
	}

    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Roupa> getRoupas() {
        return roupas;
    }

    public void setRoupas(ArrayList<Roupa> roupas) {
        this.roupas = roupas;
    }

    public ArrayList<Usuario> getUserCadastrados() {
        return usuariosCadastrados;
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
        return funcionarios;
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
        return alugueis;
    }

    public void setAlugueis(ArrayList<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

}
