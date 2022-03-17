/** ## Regra de Negócio
 * 
 * O valor de cada aluguel será: (preçoRoupa + (R$15,00 * quantidade de semanas))
 * Caso o usuário devolva uma roupa em uma data que ultrapasse "dataFim", o mesmo receberá uma multa que vale (R$1,50 * quantidade de dias atrasados)
*/

package com.classes;
import com.classes.roupas.*;

public class Aluguel {

	private int id;
	private String dataInicio;
	private String dataFim;
	private Roupa roupa;
	private double valorAluguel;
	private Usuario alugador;

	// Ent -> "Entrada"
	public Aluguel(int idEnt, String dataInicioEnt, String dataFimEnt, Roupa roupaEnt, double valorAluguelEnt, Usuario alugadorEnt) {

		this.id = idEnt;
		this.dataInicio = dataInicioEnt;
		this.dataFim = dataFimEnt;
		this.roupa = roupaEnt;
		this.valorAluguel = valorAluguelEnt;
		this.alugador = alugadorEnt;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public Roupa getRoupa() {
		return roupa;
	}

	public void setRoupa(Roupa roupa) {
		this.roupa = roupa;
	}

	public double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public Usuario getAlugador() {
		return alugador;
	}

	public void setAlugador(Usuario alugador) {
		this.alugador = alugador;
	}

	public String toString() {
		return "Aluguel [id = " + id + ", Data de início = " + dataInicio + ", Data final = " + dataFim + ", Valor do aluguel = " + valorAluguel + ", alugador = " + alugador + "]";
	}

}
