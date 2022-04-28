package br.com.residencia.bancoamazonas.menu;

import java.util.Scanner;

import br.com.residencia.bancoamazonas.contas.Conta;
import br.com.residencia.bancoamazonas.enuns.TipoPessoa;
import br.com.residencia.bancoamazonas.pessoas.Cliente;
import br.com.residencia.bancoamazonas.servicos.Login;

public class MenuInterativo {
	public static void iniciarMenu() {
		String cpf;
		String senha;
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite cpf");
			cpf = sc.next();
		System.out.println("Digite senha");
			senha = sc.next();

		Login login = new Login(cpf, senha);
		
		login.fazerLogin();
	}

	public static void menuCliente(Cliente cliente) {
		String operacao;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escolha a opera��o:\n[1] Saque\n[2] Dep�sito\n[3] Transfer�ncia\n[4] Verificar saldo\n[5] Relat�rio de tributa��o");
			operacao = sc.next();
		
		switch(operacao) {
			case "1":
				System.out.println("sacar");
				break;
			case "2":
				System.out.println("depositar");
				break;
			case "3":
				System.out.println("transferir");
				break;
			case "4":
				System.out.println("saldo");
				break;
			case "5":
				System.out.println("Relatorio tributa��o");
				break;
			default:
				System.out.println("Opera��o inv�lida!");
 		}
		
	}
	
	
//	public void menuFuncionario () {
//		imprimirMenu();
//		int escolha = 1;
//		switch (escolha ) {
//		case 1:
//			relatorioContas();
//		break;
//		case 2:
//			condicional verifica se � diretor ou presidente
//			relatorioClientes();
//		break;
//		case 3:
//			condicional verifica se � presidente
//			relatorioCapital();
//			break;
//		}
//		}

//	public void imprimirMenu() {
//		if (this.tipoPessoa.equals(TipoPessoa.CLIENTE))
//		{
//			System.out.println("");
//		}
		
//	}
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
}
