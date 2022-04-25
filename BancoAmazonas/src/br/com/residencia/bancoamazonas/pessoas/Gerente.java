package br.com.residencia.bancoamazonas.pessoas;

import java.util.Date;

import br.com.residencia.bancoamazonas.endereco.Endereco;

public class Gerente extends Funcionario {

	private Integer idGerente;
	private Integer idAgencia;

//	Métodos Públicos:

	@Override
	public Double getBonificacao() {
		return super.getBonificacao() + this.salario * 0.05;
		//return this.salario * 0.15;
	}

//  Métodos Especiais:	
	
	
	
	
	

}
