package com.classes;

import java.util.ArrayList;

public class Usuario {

	private String nome;
	private int id;
	private String endereco;
	private ArrayList<String> tel;
	private ArrayList<String> email;
	private String senha;
	
	//Ent = ENTRADA
	public Usuario(String nomeEnt,int idEnt,String enderecoEnt,ArrayList<String> telEnt,ArrayList<String> emailEnt, String senhaEnt) {
	this.nome = nomeEnt;
	this.id = idEnt;
	this.endereco = enderecoEnt;
	this.tel = telEnt;
	this.email = emailEnt;
	this.senha = senhaEnt;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public ArrayList<String> getTel() {
		return tel;
	}

	public void setTel(ArrayList<String> tel) {
		this.tel = tel;
	}

	public ArrayList<String> getEmail() {
		return email;
	}

	public void setEmail(ArrayList<String> email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
