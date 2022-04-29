package br.com.banco24h.entidades.contas;

import br.com.banco24h.entidades.Conta;
import br.com.banco24h.enums.EnumConta;

public class Corrente extends Conta {
	
	private int limite = 0;

	public Corrente(EnumConta tipoConta, int id, int numeroConta, int idAgencia, int idCliente, int limite) {
		super(tipoConta, id, numeroConta, idAgencia, idCliente);
		this.setLimite(limite);
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}

}
