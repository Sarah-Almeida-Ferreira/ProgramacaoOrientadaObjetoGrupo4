package br.com.residencia.bancoamazonas.pessoas;

import java.time.LocalDate;

import br.com.residencia.bancoamazonas.enuns.TipoPessoa;

public abstract class Pessoa {

	private static final int TAMANHO_CPF = 11;
	private static final int TAMANHO_CNPJ = 14;
	
	private String nome;
	private String cpf;
	private String telefone;
	private String endereco;
	private LocalDate dataNascimento;
	private TipoPessoa tipoPessoa;
	
// Métodos Públicos:

	public void fazerAniversario() {
		
	}
	
	public void setCadastroNacional(String cadastroNacional) {
		if (cadastroNacional == null || cadastroNacional.isEmpty()) {
			throw new RuntimeException("CPF nao pode ser nulo ou vazio");
		}
		
		if (cadastroNacional.length() == TAMANHO_CPF) {
			tipoPessoa = TipoPessoa.CLIENTE;
		}
		else if (cadastroNacional.length() == TAMANHO_CNPJ) {
			tipoPessoa = TipoPessoa.FUNCIONARIO;
		} else {
			throw new RuntimeException("Documento invalido para cadastro nacional de pessoa fisica ou juridica");
		}
		
		this.cpf = cadastroNacional;
	}
	
	private void setCadastroNacional(String cadastroNacional, TipoPessoa tipoPessoa) {
		this.cpf = cadastroNacional;
		this.tipoPessoa = tipoPessoa;
	}

//	Métodos Especiais:
	
	public void Pessoa() {
		
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	
	
	
}
