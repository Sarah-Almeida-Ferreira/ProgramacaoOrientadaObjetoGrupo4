package br.com.residencia.bancoamazonas.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.residencia.bancoamazonas.pessoas.Cliente;

public class Servicos {

	public static boolean login() {

		Scanner scan = new Scanner(System.in);

		String cpf, senha;

		System.out.println("Digite seu cpf: ");
		cpf = scan.next();
		System.out.println("Perfeito, agora digite sua senha: ");
		senha = scan.next();

		if (senha.equals(Cliente.getSenha()) && cpf.equals(cliente1.getCpf())) {
			System.out.println("Bem vindo!");
		} else {
			System.out.println("Senha invalida");
		}

		return true;

	}
	
	private void syso() {
		// TODO Auto-generated method stub

	}

	// public static void imprimirTestes() {
//		ContaCorrente conta1 = new ContaCorrente(4000.0);
//		ContaCorrente conta2 = new ContaCorrente(2000.0);
//		System.out.println("Valor antes de sacar: " + conta1.getSaldo());
//		conta1.sacar(000);
//		System.out.println("Valor depois de sacar: " + conta1.getSaldo());
//		conta1.depositar(10);
//		System.out.println("Valor depois de depositar " + conta1.getSaldo());
//		conta1.transferir(5000, conta2);
//		System.out.println("Valor da conta 1 ap�s transfer�ncia: " + conta1.getSaldo()
//				+ "\nValor da conta 2 ap�s transfer�ncia " + conta2.getSaldo());
//	}
}
