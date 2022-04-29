package br.com.residencia.bancoamazonas.pessoas;

public abstract class Funcionario extends Pessoa {
	private Double salario;
	
	public Funcionario(String tipoPessoa, String nome, String cpf, String senha, Double salario) {
		super(tipoPessoa, nome, cpf, senha);
		this.salario = salario;
	}
	
	
// Métodos Públicos
	
	
}
