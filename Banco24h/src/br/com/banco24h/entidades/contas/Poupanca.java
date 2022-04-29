package br.com.banco24h.entidades.contas;

import br.com.banco24h.entidades.Conta;
import br.com.banco24h.enums.EnumConta;

public class Poupanca extends Conta {

	public Poupanca(EnumConta tipoConta, int id, int numeroConta, int idAgencia, int idPessoa, double saldo) {
		super(tipoConta, id, numeroConta, idAgencia, idPessoa, saldo);
	}

}
