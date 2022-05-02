package br.com.banco24h.entidades.contas;

import br.com.banco24h.entidades.Conta;
import br.com.banco24h.enums.EnumConta;

public class Poupanca extends Conta {
	
	final double TAXA_JUROS = 0.02d;
	private double rendimento;
	private double montante;

	public Poupanca(EnumConta tipoConta, int id, int numeroConta, int idAgencia, int idPessoa, double saldo) {
		super(tipoConta, id, numeroConta, idAgencia, idPessoa, saldo);
	}
	
	public void simulacaoPupanca(double capitalInicial, int tempoDaAplicacao) {
		if (tempoDaAplicacao < 0) {
			System.out.println("O tempo minimo de rendimento e 1 mes. Tente novamente!");
		} else {
			this.rendimento = capitalInicial * TAXA_JUROS * tempoDaAplicacao;
			this.montante = capitalInicial + rendimento;
		}
	}

	public double getRendimento() {
		return rendimento;
	}

	public double getMontante() {
		return montante;
	}

}
