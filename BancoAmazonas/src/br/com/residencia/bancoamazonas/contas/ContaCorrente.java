package br.com.residencia.bancoamazonas.contas;

import br.com.residencia.bancoamazonas.enuns.TipoConta;

public final class ContaCorrente extends Conta {

	
	public ContaCorrente(Double saldo) {
		super(saldo);
		
	}

	private TipoConta tipoConta = TipoConta.CORRENTE;
	
	
	//colocar o tipo de conta

}
