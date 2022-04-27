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
	private static int totalPessoas;
	
// Metodos Publicos:

	public void fazerAniversario() {
		totalPessoas++;
	}

	public static int getTotalPessoas() {
		return totalPessoas;
	}
	

		
	
<<<<<<< HEAD
	

//	Metodos Especiais:
		
}
