package br.com.residencia.bancoamazonas.pessoas;

public class Funcionario extends Pessoa {

	protected Integer idFuncionario;
	private String senha;
	private String login;
	public Double salario = 1789.67;
	protected String cargo;
	
// Métodos públicos
	
	public Double getBonificacao() {
		return this.salario * 0.10;
	}
	
	
	
	
}
