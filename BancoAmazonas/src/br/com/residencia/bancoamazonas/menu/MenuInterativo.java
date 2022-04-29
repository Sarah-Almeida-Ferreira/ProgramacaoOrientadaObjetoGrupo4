package br.com.residencia.bancoamazonas.menu;

import java.util.Scanner;

import br.com.residencia.bancoamazonas.contas.Conta;
import br.com.residencia.bancoamazonas.enuns.TipoPessoa;

public class MenuInterativo {

	public static void menuCliente(Scanner sc) {
		imprimirMenuCliente();

//		+ "\n1 - Saque"
//		+ "\n2 - Dep�sito"
//		+ "\n3 - Transfer�ncia"
//		+ "\n4 - Relat�rios"
//		+ "\n5 - Fechar conta"
//		+ "\n0 - Finalizar sess�o\n: ");
		String escolha = sc.nextLine();
		switch (escolha) {
		case "1":
			System.out.println("Qual o valor do saque?: ");
			int valorSaque = sc.nextInt();
			Conta.sacar(valorSaque);
			break;
		case "2":
			System.out.println("Qual o valor do dep�sito: ");
			int valorDeposito = sc.nextInt();
			Conta.depositar(valorDeposito);
			break;
		case "3":
			System.out.println("Qual o valor de transfer�ncia: ");
			int valorTransferencia = sc.nextInt();
			Conta.transferir(valorTransferencia, null);
			break;
		case "4":
			System.out.println("Qual relat�rio deseja ver?\n"
					+ "\n1 - Saldo"
					+ "\n2 - Relat�rio de	tributa��o"
					+ "\n3 - Relat�rio de rendimento da poupan�a"
					+ "\n4 - Retornar");
			escolha = sc.next();
			casoRelatorio(escolha);
			break;
		case "5":
			break;
		case "0":
			break;
		default:
			break;
		}
	}

	private static void casoRelatorio(String escolha) {
		switch (escolha) {
		case "1":
		//imprimirSaldo();
			break;
		case "2":
		//relatorioTributo();
			break;
		case "3":
		//rendimentoPoupanca();	
			break;
		case "4":
		System.out.println("Retornando");	
			break;
		default:
			System.out.println("Op��o inv�lida, retornando");
			break;

		}

	}

	public static void menuFuncionario() {
		imprimirMenuFuncionario();
		int escolha = 1;
		switch (escolha) {
		case 1:
//			relatorioContas();
			break;
		case 2:
//			condicional verifica se � diretor ou presidente
//			relatorioClientes();
			break;
		case 3:
//			condicional verifica se � presidente
//			relatorioCapital();
			break;
		}
	}

	private static void imprimirMenuFuncionario() {
		System.out.println("Qual opera��o deseja fazer?");

	}

	private static void imprimirMenuCliente() {
		System.out.println("Qual opera��o deseja fazer?" + "\n1 - Saque" + "\n2 - Dep�sito" + "\n3 - Transfer�ncia"
				+ "\n4 - Relat�rios" + "\n5 - Fechar conta" + "\n0 - Finalizar sess�o\n: ");

	}

//	public void imprimirMenu() {
//		if (this.tipoPessoa.equals(TipoPessoa.CLIENTE))
//		{
//			System.out.println("");
//		}

}
//	saque
//	deposito
//	transferencia
//	entrar
//	sair
//	
// RELATORIOS
// relatorio de tributação da conta corrente
// saldo o sistema imprime o saldo na tela do terminal

// relatorio poupança
// retorna um valor de rendimento da poupanca no prazo informado

// desafio
// criar classe seguro de vida q possa ser contratado pelo cliente
// onde é informado o valor que sera segurado
// no ato da contratação sera debitado 20% do valor contratado como tributo

// CASO 2
// GERENTE
// 1 movimentações e informações da conta
// a saque b deposito c transferencia para outra conta

// 2 RELATORIOS identico ao cliente

// d relatorio do numero de contas na mesma agencia que este gerente trabalhe

// CASO3
// DIRETOR
// RELATORIO COM TODOS OS NOMES CPF E AGENCIA de todos os clientes do sistema em
// ordem alfabetica

// CASO 4
// PRESIDENTE
// relatórios:
// valor total do capital armazenado no banco
