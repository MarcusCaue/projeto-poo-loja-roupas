package com.classes;

public class Usuario {

	private String nome;
	private int id;
	private String email;
	private String senha;

	// Ent = ENTRADA
	public Usuario(String nomeEnt, int idEnt, String emailEnt, String senhaEnt) {
		this.nome = nomeEnt;
		this.id = idEnt;
		this.email = emailEnt;
		this.senha = senhaEnt;
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
