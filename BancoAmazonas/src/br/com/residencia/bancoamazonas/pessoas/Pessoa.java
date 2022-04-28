package br.com.residencia.bancoamazonas.pessoas;

import java.time.LocalDate;

import br.com.residencia.bancoamazonas.enuns.TipoPessoa;

public abstract class Pessoa {

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + ", tipoPessoa=" + tipoPessoa + "]";
	}

	private String nome;
	private String cpf;
	private String senha;
	private String tipoPessoa;

// Metodos Publicos:

	public void fazerAniversario() {

	}

	public Pessoa(String tipoPessoa, String nome, String cpf, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.tipoPessoa = tipoPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

//	Metodos Especiais:

}
