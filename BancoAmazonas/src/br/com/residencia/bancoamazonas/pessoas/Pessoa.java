package br.com.residencia.bancoamazonas.pessoas;

import java.time.LocalDate;

import br.com.residencia.bancoamazonas.enuns.TipoPessoa;

public abstract class Pessoa {

	private String nome;
	private String cpf;
	private String senha;
	private String telefone;
	private String endereco;
	private LocalDate dataNascimento;
	private TipoPessoa tipoPessoa;

// Metodos Publicos:

	public void fazerAniversario() {

	}

//	Metodos Especiais:
	public Pessoa(String cpf, String senha) {
		super();
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public String getSenha() {
		return senha;
	}

}
