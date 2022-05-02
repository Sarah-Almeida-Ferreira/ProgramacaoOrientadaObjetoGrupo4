package br.com.banco24h.entidades.contas;

import br.com.banco24h.entidades.Conta;
import br.com.banco24h.enums.EnumConta;

public class Corrente extends Conta {
	
	public Corrente(EnumConta tipoConta, int id, int numeroConta, int idAgencia, int idCliente, double saldo) {
		super(tipoConta, id, numeroConta, idAgencia, idCliente, saldo);
	}

}
