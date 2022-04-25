package br.com.residencia.bancoamazonas.pessoas;

import java.util.Date;

import javax.management.RuntimeErrorException;

import br.com.residencia.bancoamazonas.endereco.Endereco;
import br.com.residencia.bancoamazonas.enuns.TipoPessoa;

public abstract class Pessoa {

	private static final int TAMANHO_CPF = 11;
	private static final int TAMANHO_CNPJ = 14;
	
	private String nome;
	private String genero;
	private String estadoCivil;
	private String cadastroNacional;
	private String telefone;
	private Endereco endereco;
	private String email;
	private Date dataNascimento;
	private TipoPessoa tipoPessoa;

// Métodos Públicos:

	public void fazerAniversario() {

	}
	
	public void setCadastroNacional(String cadastroNacional) {
		if (cadastroNacional == null || cadastroNacional.isEmpty()) {
			throw new RuntimeException("CPF não pode ser nulo ou vazio");
		}
		
		if (cadastroNacional.length() == TAMANHO_CPF) {
			tipoPessoa = TipoPessoa.FISICA;
		}
		else if (cadastroNacional.length() == TAMANHO_CNPJ) {
			tipoPessoa = TipoPessoa.JURIDICA;
		} else {
			throw new RuntimeException("Documento invalido para cadastro nacional de pessoa fisica ou juridica");
		}
		
		this.cadastroNacional = cadastroNacional;
	}
	
	private void setCadastroNacional(String cadastroNacional, TipoPessoa tipoPessoa) {
		this.cadastroNacional = cadastroNacional;
		this.tipoPessoa = tipoPessoa;
	}

//	Métodos Especiais:

	
	
}
