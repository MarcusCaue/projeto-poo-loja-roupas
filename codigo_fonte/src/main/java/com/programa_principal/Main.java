package com.programa_principal;

import com.classes.*;
import com.classes.roupas.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Main {

    public Aluguel alugar() {
        /* 
         * import java.util.Scanner;
         * import java.util.Calendar;
         * import java.text.SimpleDateFormat;
         * 
        */

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
    }

    public static void main(String[] args) {

    }
}
