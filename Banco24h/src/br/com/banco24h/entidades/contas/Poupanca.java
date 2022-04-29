package br.com.banco24h.entidades.contas;

import br.com.banco24h.entidades.Conta;
import br.com.banco24h.enums.EnumConta;

public class Poupanca extends Conta {

	private int aniversario;

	public Poupanca(EnumConta tipoConta, int id, int numeroConta, int idAgencia, int idPessoa, int aniversario) {
		super(tipoConta, id, numeroConta, idAgencia, idPessoa);
		this.setAniversario(aniversario);
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}

}
