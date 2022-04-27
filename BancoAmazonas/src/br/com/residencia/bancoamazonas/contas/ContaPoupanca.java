package br.com.residencia.bancoamazonas.contas;

import br.com.residencia.bancoamazonas.enuns.TipoConta;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Double saldo) {
		super(saldo);
		// TODO Auto-generated constructor stub
	}

	private TipoConta tipoConta = TipoConta.POUPANCA;

}
