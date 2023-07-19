package com.classes;

public class Usuario {

	private int id;
	private String nome;
	private String email;
	private String senha;

	public Usuario(String nome, int id, String email, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String novoNome) {
		this.nome = novoNome;
	}

	public int getId() {
		return id;
	}

	public void setId(int novoId) {
		this.id = novoId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String novoEmail) {
		this.email = novoEmail;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String novaSenha) {
		this.senha = novaSenha;
	}

	public String toString() {
		return "Usuario [nome=" + nome + ", id=" + id + ", email=" + email + ", senha=" + senha + "]";
	}

}
