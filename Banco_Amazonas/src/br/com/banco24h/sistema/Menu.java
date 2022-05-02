package br.com.banco24h.sistema;

import java.util.Scanner;

import br.com.banco24h.entidades.Conta;
import br.com.banco24h.entidades.Pessoa;
import br.com.banco24h.entidades.estruturas.Banco;
import br.com.banco24h.entidades.estruturas.Regional;
import br.com.banco24h.enums.EnumConta;
import br.com.banco24h.enums.EnumPessoa;
import br.com.banco24h.entidades.pessoas.Cliente;
import br.com.banco24h.entidades.pessoas.funcionarios.Diretor;
import br.com.banco24h.entidades.pessoas.funcionarios.Gerente;
import br.com.banco24h.entidades.pessoas.funcionarios.Presidente;

public class Menu {

	private Scanner op = new Scanner(System.in);

	private Pessoa pessoaLogada = null;
	private double totalTributo = 0;
	private static String login = "";
	private static String senha = "";
	private static EnumPessoa tipoPessoa;

	public void fluxo() throws Exception {
		int opMenuClienteOuFuncionario = -1;
		while ((menuBoasVindas() != 0) && (opMenuClienteOuFuncionario != 0)) {
			while ((opMenuClienteOuFuncionario = menuClienteOuFuncionario()) != 0) {
				if (opMenuClienteOuFuncionario == 1) {
					menuLoginCliente();
				} else if (opMenuClienteOuFuncionario == 2) {
					menuLoginFuncionario();
				} else {
					menuOpcaoNaoReconhecida();
				}
				if ((Menu.login == null) || (!"".equals(Menu.login))) {
					pessoaLogada = Pessoa.validarLoginPessoa();
				}
				if (pessoaLogada != null) {
					System.out.println("pessoaLogada" + pessoaLogada);
					if (pessoaLogada.getTipoPessoa() == EnumPessoa.CLIENTE) {
						menuCliente();
					} else {
						menuFuncionario();
					}
				} else {
					System.out.println("Usuário e senha incorretos! Tente novamente.");
				}
			}
			menuSaida();
		}
	}

	public int menuClienteOuFuncionario() {
		System.out.println("\n\nSelecione a opcao desejada:\n\n[1]\tCliente\n[2]\tFuncionario\n[0]\tSair");
		return op.nextInt();
	}

	public void menuLoginCliente() {
		System.out.println("\n============ LOGIN CLIENTES ============\n");
		Menu.tipoPessoa = EnumPessoa.CLIENTE;
		System.out.print("Digite seu login: ");
		Menu.login = op.next();
		System.out.print("\nDigite sua senha: ");
		Menu.senha = op.next();
	}

	public void menuLoginFuncionario() {
		System.out.println("\n============ LOGIN FUNCIONARIOS ============\n");
		Menu.tipoPessoa = EnumPessoa.FUNCIONARIO;
		System.out.print("Digite seu login: ");
		Menu.login = op.next();
		System.out.print("Digite sua senha: ");
		Menu.senha = op.next();
	}

	public void menuOpcaoNaoReconhecida() {
		System.out.println("\n\nSua opcao de escolha nao foi reconhecida pelo nosso sistema.");
	}

	public void menuSaida() {
		System.out.println("\n\nObrigado por ter usado nosso sistema!");
	}

	public int menuBoasVindas() {
		System.out.println();
		System.out.println("=============== SEJA BEM VINDO AO NOSSO BANCO :-) ===============");
		System.out.print("\nPressione [Enter] para entrar ou [0] para sair do nossa aplicacao");
		String resp = op.nextLine();
		return ("0".equals(resp) ? 0 : 1);
	}

	public void menuCliente() {
		Conta conta = ((Cliente) pessoaLogada).getConta();
		int o;

		do {
			System.out.println("\n============ MENU CLIENTE ============\n" + "Escolha uma opcao abaixo:\n\n"
					+ "[1]\tSaldo\n" + "[2]\tSaque\n" + "[3]\tDeposito\n" + "[4]\tTransferencia");

			if (((Cliente) this.pessoaLogada).getTipoConta() == EnumConta.CORRENTE) {
				System.out.println("[5]\tTributos Conta-Corrente");
			} else if (((Cliente) this.pessoaLogada).getTipoConta() == EnumConta.POUPANCA) {
				System.out.println("[5]\tSimulação Poupanca");
			}
			System.out.println("[6]\tSair");
			o = op.nextInt();
			switch (o) {
			case 1:
				menuSaldo(conta);
				break;
			case 2:
				menuSaque(conta);
				break;
			case 3:
				menuDeposito(conta);
				break;
			case 4:
				menuTransferencia(conta);
				break;
			case 5:
				if (((Cliente) this.pessoaLogada).getTipoConta() == EnumConta.CORRENTE) {
					menuTributos();
				} else if (((Cliente) this.pessoaLogada).getTipoConta() == EnumConta.POUPANCA) {
					menuSimulacaoPoupanca();
				}
				break;
			case 6:
				System.out.println("Sair");
				break;
			default:
				System.out.println("Opcao nao identificada!");
				menuCliente();

			}
		} while (o != 6);
	}

	public void menuSaldo(Conta conta) {
		System.out.println("\n============ MENU SALDO ============\n");

		System.out.printf("Saldo disponível R$ %.2f", conta.getSaldo(), "\n");
	}

	public void menuSaque(Conta conta) {

		System.out.println("\n============ MENU SAQUE ============\n");
		System.out.println("Digite o valor a ser sacado: ");
		double valorSacado = op.nextDouble();
		if (((Cliente) this.pessoaLogada).getTipoConta() == EnumConta.CORRENTE) {
			if (Conta.sacar(conta, valorSacado - Conta.getTAXA_SAQUE())) {
				totalTributo += Conta.getTAXA_SAQUE();
				System.out.println("Seu novo saldo e de R$ " + conta.getSaldo());
			}

		} else {
			if (Conta.sacar(conta, valorSacado)) {
				System.out.println("Seu novo saldo e de R$ " + conta.getSaldo());
			}
		}
	}

	public void menuDeposito(Conta conta) {
		System.out.println("\n============ MENU DEPOSITO ============\n");
		System.out.println("Digite o valor a ser depositado: ");
		double valorDepositado = op.nextDouble();
		if (((Cliente) this.pessoaLogada).getTipoConta() == EnumConta.CORRENTE) {
			if (Conta.depositar(conta, valorDepositado - Conta.getTAXA_DEPOSITO())) {
				totalTributo += Conta.getTAXA_DEPOSITO();
				System.out.println("Seu novo saldo e de R$ " + conta.getSaldo());
			}
		}
		if (Conta.depositar(conta, valorDepositado)) {
			System.out.println("Seu novo saldo e de R$ " + conta.getSaldo());
		}

	}

	public void menuTransferencia(Conta conta) {
		System.out.println("\n============ MENU TRANSFERENCIA ============\n");
		System.out.println("Digite o valor a ser transferido: ");
		double valorTransferido = op.nextDouble();
		System.out.println("Digite o numero da Conta destino: ");
		int contaDestino = op.nextInt();

		if (((Cliente) this.pessoaLogada).getTipoConta() == EnumConta.CORRENTE) {
			if (Conta.transferir(conta, Conta.getContaById(contaDestino),
					valorTransferido - Conta.getTAXA_TRANSFERENCIA())) {
				totalTributo += Conta.getTAXA_TRANSFERENCIA();
				System.out.println("Seu novo saldo e de R$ " + conta.getSaldo());
				System.out.println("O saldo da nova conta e de R$ " + Conta.getContaById(contaDestino).getSaldo());
			}
		}
		if (Conta.transferir(conta, Conta.getContaById(contaDestino), valorTransferido)) {

			System.out.println("Seu novo saldo e de R$ " + conta.getSaldo());
			System.out.println("O saldo da nova conta e de R$ " + Conta.getContaById(contaDestino).getSaldo());
		}
	}

	public void menuTributos() {
		System.out.println("\n============ MENU TRIBUTOS ============\n");

		System.out.println("********** Tabela de Precos **********");
		System.out.printf("\nTaxa por Saque: R$ %.2f", Conta.getTAXA_SAQUE());
		System.out.printf("\nTaxa por Deposito: R$ %.2f", Conta.getTAXA_DEPOSITO());
		System.out.printf("\nTaxa por Transferencia: R$ %.2f", Conta.getTAXA_TRANSFERENCIA(), "\n");
		System.out.println("\n**************************************\n");

		System.out.printf("Valor Total de Tributos: R$ %.2f", totalTributo, "\n\n");
	}

	public void menuSimulacaoPoupanca() {
		System.out.println("\n============ MENU SIMULACAO POUPANCA ============\n");
		System.out.println("Digite o valor a ser aplicado: ");
		double capitalInicial = op.nextDouble();
		System.out.println("Digite a quantidade de meses da aplicacao: ");
		int tempoDaAplicacao = op.nextInt();

		final double TAXA_JUROS = 0.02d;
		if (tempoDaAplicacao < 0) {
			System.out.println("O tempo minimo de rendimento e 1 mes. Tente novamente!");
		} else {
			double rendimento = capitalInicial * TAXA_JUROS * tempoDaAplicacao;
			double montante = capitalInicial + rendimento;
			System.out.printf("\nSeu rendimento em %d dias sera de %.2f", tempoDaAplicacao, rendimento);
			System.out.printf("\nResultando em um montante de R$ %.2f", montante, "\n");
		}

	}

	public static String getSenha() {
		return senha;
	}

	public static String getLogin() {
		return login;
	}

	public static EnumPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void menuFuncionario() {
		// System.out.println("Menu Funcionario");
		if (pessoaLogada.getTipoPessoa() == EnumPessoa.PRESIDENTE) {
			menuPresidente();
		} else if (pessoaLogada.getTipoPessoa() == EnumPessoa.DIRETOR) {
			menuDiretor();
		} else if (pessoaLogada.getTipoPessoa() == EnumPessoa.GERENTE) {
			menuGerente();
		}
	}

	private void menuGerente() {
		int o;
		do {
		System.out.println("Olá, " + pessoaLogada.getNome() + ".");
		System.out.println("Escolha uma opção abaixo");
		System.out.println("1-Relatório do número de contas da agência");
		System.out.println("2-Sair");
		o = op.nextInt();
		switch (o) {
		case 1:
			menuRelatorioGerente_ContasAgencia();
			break;
		case 2:
			return;
		default:
			System.out.println("opção não identificada");
			menuGerente();
		}
		}while (o != 6);
	}

	public int menuRelatorioGerente_ContasAgencia() {
		System.out.println("Relatório do número de contas da sua agência: ");
		System.out.println("Número de contas: " + Pessoa.getQuantidadeContasAgenciaGerente((Gerente) pessoaLogada));
		System.out.println();
		System.out.println("Digite um número para retornar: ");
		return op.nextInt();
	}

	private void menuDiretor() {
		int o;
		do {
		System.out.println("Olá Diretor " + pessoaLogada.getNome() + ".");
		System.out.println("Escolha uma opção abaixo");
		System.out.println("1-Relatório do número de contas da região: ");
		System.out.println("2-Relatório de clientes do banco: ");
		System.out.println("3-Sair: ");
		o = op.nextInt();
		switch (o) {
		case 1:
			menuRelatorioDiretor_ContasRegiao(((Diretor) pessoaLogada).getRegional());
			break;
		case 2:
			listagemClientesBanco(((Diretor) pessoaLogada).getRegional().getBanco());
			break;
		case 3:
			break;
		default:
			System.out.println("Opção não identificada!");
			menuGerente();
		}
		}while (o != 3);
	}

	private int listagemClientesBanco(Banco banco) {
		System.out.println("Relatório de clientes do banco: " + banco.getNomeBanco());
		System.out.println(Pessoa.getRelatorioListagemClientesBanco(banco));
		System.out.println();
		System.out.println("Digite um número para retornar. ");
		return op.nextInt();
	}

	private int menuRelatorioDiretor_ContasRegiao(Regional regiao) {
		System.out.println("Relatório do número de contas da regiao: " + regiao.getNomeRegiao());
		System.out.println("Número de contas: " + Pessoa.getQuantidadeContasRegionalDiretor((Diretor) pessoaLogada));
		System.out.println();
		System.out.println("Digite um número para retornar. ");
		return op.nextInt();
	}

	private int menuRelatorioPresidente_ContasBanco(Banco banco) {
		System.out.println("Relatório número de contas do banco: " + banco.getNomeBanco());
		System.out
				.println("Número de contas: " + Pessoa.getQuantidadeContas_BancoPresidente((Presidente) pessoaLogada));
		System.out.println();
		System.out.println("Digite um número para retornar. ");
		return op.nextInt();
	}

	private void menuPresidente() {
		int o;
		do {
		System.out.println("Olá Presidente " + pessoaLogada.getNome() + ".");
		System.out.println("Escolha uma opção abaixo");
		System.out.println("1-Relatório do número de contas do banco: ");
		System.out.println("2-Relatório de clientes do banco: ");
		System.out.println("3-Valor total do capital armazenado no banco: ");
		System.out.println("4-Sair: ");
		o = op.nextInt();
		switch (o) {
		case 1:
			menuRelatorioPresidente_ContasBanco(((Presidente) pessoaLogada).getBanco());
			break;
		case 2:
			listagemClientesBanco(((Presidente) pessoaLogada).getBanco());
			break;
		case 3:
			menuRelatorioPresidente_CapitalBanco(((Presidente) pessoaLogada).getBanco());
			break;
		case 4:
			break;
		default:
			System.out.println("Opção não identificada!");
			menuGerente();
		}
		}while (o != 4);
	}

	private int menuRelatorioPresidente_CapitalBanco(Banco banco) {
		System.out.println("Relatório capital acumulado do banco: " + banco.getNomeBanco());
		System.out.println("Capital do banco em R$: " + String.format("%.2f", Pessoa.getCapitalTotalBanco(banco)));
		System.out.println();
		System.out.println("Digite um número para retornar. ");
		return op.nextInt();

	}
}