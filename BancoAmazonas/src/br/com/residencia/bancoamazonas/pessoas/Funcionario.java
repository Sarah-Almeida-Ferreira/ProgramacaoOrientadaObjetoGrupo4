package br.com.residencia.bancoamazonas.pessoas;

import br.com.residencia.bancoamazonas.enuns.TipoPessoa;

public abstract class Funcionario extends Pessoa {
	private Double salario;
	
	public Funcionario(TipoPessoa tipoPessoa, String nome, String cpf, String senha, Double salario) {
		super(tipoPessoa, nome, cpf, senha);
	}
	
	
// Métodos Públicos
	
	
}
