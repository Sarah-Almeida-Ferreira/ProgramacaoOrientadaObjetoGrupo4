package br.com.residencia.bancoamazonas.pessoas;

import br.com.residencia.bancoamazonas.enuns.TipoPessoa;

public abstract class Funcionario extends Pessoa {
	protected String cargo;
	public Funcionario(String nome, String cpf, String senha, TipoPessoa tipoPessoa, String cargo) {
		super(nome, cpf, senha, tipoPessoa);
	}
	
	
// Métodos Públicos
	
	
}
