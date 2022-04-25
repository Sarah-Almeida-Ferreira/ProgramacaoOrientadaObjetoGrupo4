package br.com.residencia.bancoamazonas.pessoas;

import java.util.Date;

import br.com.residencia.bancoamazonas.endereco.Endereco;

public class Cliente extends Pessoa {

	private Integer idCliente;
	private Integer idGerente;
	private String numCartao; //ver com o pessoal

// Métodos Públicos:
	
	public void setEndereco(String endereco) {
		if (endereco == null || endereco.isEmpty()) {
			throw new RuntimeException("endereco não pode ser nulo");
		}
	}
	
	
	
	
//  Métodos Especiais:

}
