package br.com.banco24h.sistema;

import java.util.Scanner;

import br.com.banco24h.entidades.Conta;
import br.com.banco24h.entidades.Pessoa;
import br.com.banco24h.entidades.contas.Poupanca;
import br.com.banco24h.entidades.estruturas.Banco;
import br.com.banco24h.entidades.pessoas.Cliente;
import br.com.banco24h.entidades.pessoas.funcionarios.Diretor;
import br.com.banco24h.entidades.pessoas.funcionarios.Gerente;
import br.com.banco24h.entidades.pessoas.funcionarios.Presidente;
import br.com.banco24h.enums.EnumConta;
import br.com.banco24h.enums.EnumPessoa;

public class Menu {

	private static Scanner op = new Scanner(System.in);

	private static Pessoa pessoaLogada = null;
	private static String login = "";
	private static String senha = "";
	private static EnumPessoa tipoPessoa;

	public void fluxo(){
		int opMenuClienteOuFuncionario = -1;
		while ((menuBoasVindas() != 0) && (opMenuClienteOuFuncionario != 0)) {
			while ((opMenuClienteOuFuncionario = menuClienteOuFuncionario()) != 0) {
				if (opMenuClienteOuFuncionario == 1) {
					menuLoginCliente();
				} else if (opMenuClienteOuFuncionario == 2) {
					menuLoginFuncionario();
				} else {
					System.out.println("Opcao nao identificada! Tente novamente.");
				}
				if ((Menu.login == null) || (!"".equals(Menu.login))) {
					pessoaLogada = Pessoa.validarLoginPessoa();
				}
				if (pessoaLogada != null) {
					System.out.println("\nPessoa Logada: " + pessoaLogada.getNome() + " ("+pessoaLogada.getTipoPessoa()+")\n");
					if (pessoaLogada.getTipoPessoa() == EnumPessoa.CLIENTE) {
						menuCliente();
					} else {
						menuFuncionario();
					}
				} else {
					System.out.println("Usu�rio e senha incorretos! Tente novamente.");
					fluxo();
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

			if (((Cliente)pessoaLogada).getTipoConta() == EnumConta.CORRENTE) {
				System.out.println("[5]\tTributos Conta-Corrente");
			} else if (((Cliente)pessoaLogada).getTipoConta() == EnumConta.POUPANCA) {
				System.out.println("[5]\tSimulacao Poupanca");
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
				if (((Cliente)pessoaLogada).getTipoConta() == EnumConta.CORRENTE) {
					menuTributos(((Cliente)pessoaLogada).getConta());
				} else if (((Cliente)pessoaLogada).getTipoConta() == EnumConta.POUPANCA) {
					menuSimulacaoPoupanca((Poupanca)((Cliente)pessoaLogada).getConta());
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

		System.out.printf("Saldo disponivel R$ %.2f", conta.getSaldo(), "\n");
	}

	public static void menuSaque(Conta conta) {

		System.out.println("\n============ MENU SAQUE ============\n");
		System.out.println("Digite o valor a ser sacado: ");
		double valorSacado = op.nextDouble();
			if (conta.sacar(valorSacado)) {
				Log.addLogOperacao("SAQUE: conta="+conta.getId()+" valorSacado="+String.format("%.2f", valorSacado));
				System.out.println("Seu novo saldo e de R$ " + conta.getSaldo());
			}
	}

	public void menuDeposito(Conta conta) {
		System.out.println("\n============ MENU DEPOSITO ============\n");
		System.out.println("Digite o valor a ser depositado: ");
		double valorDepositado = op.nextDouble();
		if (conta.depositar(valorDepositado)) {
			Log.addLogOperacao("DEPOSITO: conta="+conta.getId()+" valorDepositado="+String.format("%.2f", valorDepositado));
			System.out.println("Seu novo saldo e de R$ " + conta.getSaldo());
		}
	}

	public void menuTransferencia(Conta conta) {
		System.out.println("\n============ MENU TRANSFERENCIA ============\n");
		System.out.println("Digite o valor a ser transferido: ");
		double valorTransferido = op.nextDouble();
		System.out.println("Digite o numero da Conta destino: ");
		int contaDestino = op.nextInt();
		if (conta.transferir(Conta.getContaById(contaDestino), valorTransferido)) {
			Log.addLogOperacao("TRANSFERENCIA: contaOrigem="+conta.getId()+" contaDestino="+contaDestino+ " valorTransferido="+String.format("%.2f", valorTransferido));
			System.out.println("Seu novo saldo e de R$ " + conta.getSaldo());
			//System.out.println("O saldo da nova conta e de R$ " + Conta.getContaById(contaDestino).getSaldo());
		}
	}

	public void menuTributos(Conta conta) {
		System.out.println("\n============ MENU TRIBUTOS ============\n");

		System.out.println("********** Tabela de Precos **********");
		System.out.printf("\nTaxa por Saque: R$ %.2f", Conta.getTAXA_SAQUE());
		System.out.printf("\nTaxa por Deposito: R$ %.2f", Conta.getTAXA_DEPOSITO());
		System.out.printf("\nTaxa por Transferencia: R$ %.2f", Conta.getTAXA_TRANSFERENCIA(), "\n");
		System.out.println("\n**************************************\n");

		System.out.printf("Valor Total de Tributos: R$ %.2f", conta.getTotalTributos(), "\n\n");
	}

	public void menuSimulacaoPoupanca(Poupanca poupanca) {
		System.out.println("\n============ MENU SIMULACAO POUPANCA ============\n");
		System.out.println("Digite o valor a ser aplicado: ");
		double capitalInicial = op.nextDouble();
		System.out.println("Digite a quantidade de meses da aplicacao: ");
		int tempoDaAplicacao = op.nextInt();

		poupanca.simulacaoPupanca(capitalInicial, tempoDaAplicacao);
		System.out.printf("\nSeu rendimento em %d meses sera de %.2f", tempoDaAplicacao, poupanca.getRendimento());
		System.out.printf("\nResultando em um montante de R$ %.2f", poupanca.getMontante(), "\n");
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
			System.out.println("Ola, " + pessoaLogada.getNome() + ".");
			System.out.println("Escolha uma opcao abaixo");
			System.out.println("[1]\tRelatorio do numero de contas da agencia");
			System.out.println("[2]\tSair");
			o = op.nextInt();
			switch (o) {
				case 1:
					((Gerente)pessoaLogada).relatorioContasDaAgencia();
					break;
				case 2:
					return;
				default:
					System.out.println("Opcao nao identificada! Tente novamente.");
					menuGerente();
			}
		}while (o != 6);
	}

	private void menuDiretor() {
		int o;
		do {
			System.out.println("Ola, " + pessoaLogada.getNome() + "!");
			System.out.println("Escolha uma opcao abaixo");
			System.out.println("[1]\tRelatorio do numero de contas da regiao: ");
			System.out.println("[2]\tRelatorio de clientes do banco: ");
			System.out.println("[3]\tSair: ");
			o = op.nextInt();
			switch (o) {
				case 1:
					((Diretor)pessoaLogada).relatorioContasRegiao(((Diretor) pessoaLogada).getRegional());
					break;
				case 2:
					Banco.listagemClientesBanco(((Diretor)pessoaLogada).getRegional().getBanco(), pessoaLogada);
					break;
				case 3:
					return;
				default:
					System.out.println("Opcao nao identificada! Tente novamente.");
			}
		}while (o != 3);
	}

	private void menuPresidente() {
		int o;
		do {
			System.out.println("====== Menu Presidente ======");
			System.out.println();
			System.out.println("Ola, " + pessoaLogada.getNome() + "!");
			System.out.println();
			System.out.println("Escolha uma opcao abaixo");
			System.out.println("[1]\tRelatorio do numero de contas do banco: ");
			System.out.println("[2]\tRelatorio de clientes do banco: ");
			System.out.println("[3]\tValor total do capital armazenado no banco: ");
			System.out.println("[4]\tSair: ");
			o = op.nextInt();
			switch (o) {
				case 1:
					Presidente.relatorioContasBanco(((Presidente) pessoaLogada).getBanco(), pessoaLogada);
					break;
				case 2:
					Banco.listagemClientesBanco(((Presidente) pessoaLogada).getBanco(), pessoaLogada);
					break;
				case 3:
					Presidente.relatorioCapitalBanco(((Presidente) pessoaLogada).getBanco(), pessoaLogada);
					break;
				case 4:
					return;
				default:
					System.out.println("Opcao nao identificada! Tente novamente.");
			}
		}while (o != 4);
	}

	public static Pessoa getPessoaLogada() {
		return pessoaLogada;
	}

	
}