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
	private int totalDeContas;

// Metodos Publicos
	public boolean fecharConta() {
		return this.status = false;

	}

	public boolean sacar(double valorSacado) {
		if (this.saldo < valorSacado) {
			return false;
		} else {
			this.saldo -= valorSacado;
			return true;
		}

	}

	public void depositar(double valorDepositado) {
		this.saldo += valorDepositado;
	}

	public boolean transferir(double valorTransferido, Conta contaDestino) {
		if (sacar(valorTransferido)) {
			contaDestino.depositar(valorTransferido);
			return true;
		}
		return false;
	}

	public boolean verificarSaldo() {
		return this.saldo > 0 ? true : false;
	}
	
	
//  Metodos Especiais:
	
	public Conta () {
		this.totalDeContas = this.totalDeContas + 1;
	}
	
	
	
	public Double getSaldo() {
		return this.saldo;
	}

public Conta(Double saldo) {
	super();
	this.saldo = saldo;
}
	
}
