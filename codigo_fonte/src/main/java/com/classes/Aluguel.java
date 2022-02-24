package com.classes;
import com.classes.roupas.*;

public class Aluguel {
	
	private int id;
	private String dataInicio;
	private String dataFim;
	private Roupa roupa;
	private double valorAluguel;
	private Usuario alugador;
	
	public Aluguel(int idEnt,String dataInicioEnt,String dataFimEnt,Roupa roupaEnt, double valorAluguelEnt, Usuario alugadorEnt) {
		
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
	

}
