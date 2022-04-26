package br.com.residencia.bancoamazonas.contas;

import java.time.LocalDate;

import br.com.residencia.bancoamazonas.enuns.TipoConta;

public abstract class Conta {

	private String cpfTitular;
	private String numeroConta;
	private Integer numeroAgencia;
	private Double saldo;
	private LocalDate dataAbertura;
	private Boolean status;

// Métodos Públicos
	public boolean fecharConta() {
		return this.status = false;

	}

	public void sacar() {

	}

	public void depositar() {

	}
	
	public void transferir() {
		
	}

	public boolean verificarSaldo() {
		return this.saldo > 0 ? true : false;
		
	}

	
//  Métodos Especiais:	

}
