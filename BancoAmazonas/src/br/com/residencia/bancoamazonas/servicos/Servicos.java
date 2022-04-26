package br.com.residencia.bancoamazonas.servicos;

import br.com.residencia.bancoamazonas.contas.ContaCorrente;

public class Servicos {
	public static void imprimirTestes() {
		ContaCorrente conta1 = new ContaCorrente(4000.0);
		ContaCorrente conta2 = new ContaCorrente(2000.0);
		System.out.println("Valor antes de sacar: " + conta1.getSaldo());
		conta1.sacar(000);
		System.out.println("Valor depois de sacar: " + conta1.getSaldo());
		conta1.depositar(10);
		System.out.println("Valor depois de depositar " + conta1.getSaldo());
		conta1.transferir(5000, conta2);
		System.out.println("Valor da conta 1 após transferência: " + conta1.getSaldo()
				+ "\nValor da conta 2 após transferência " + conta2.getSaldo());
	}
}
