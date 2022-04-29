package br.com.banco24h.sistema;

import java.util.Scanner;

import br.com.banco24h.entidades.Pessoa;
import br.com.banco24h.enums.EnumConta;
import br.com.banco24h.enums.EnumPessoa;
import br.com.banco24h.entidades.pessoas.Cliente;

public class Menu {
	
	private Scanner op = new Scanner(System.in);
	
	private Pessoa pessoaLogada = null;
	
	private static String login = "";
	private static String senha = "";
	private static EnumPessoa tipoPessoa;
 
	public void fluxo() {
		int opMenuClienteOuFuncionario = -1;
		while((menuBoasVindas()!=0)&&(opMenuClienteOuFuncionario!=0)) {
			while((opMenuClienteOuFuncionario = menuClienteOuFuncionario())!=0) {
				if(opMenuClienteOuFuncionario==1) {
					menuLoginCliente();
				}else if(opMenuClienteOuFuncionario==2) {
					menuLoginFuncionario();
				}else {
					menuOpcaoNaoReconhecida();
				}
				MenuImprimeInformacaoesLogin();
				if((Menu.login==null)||(!"".equals(Menu.login))) {
					pessoaLogada = Pessoa.validarLoginPessoa();
				}
				System.out.println("pessoaLogada"+pessoaLogada);
				if(pessoaLogada!=null) {
					if(pessoaLogada.getTipoPessoa()==EnumPessoa.CLIENTE) {
						menuCliente();
					}else {
						menuFuncionario();
					}
				}
				//MenuImprimeBeanLogin(beanLogin);			
			}
			menuSaida();
		}
	}
	
	private void MenuImprimeInformacaoesLogin() {
		if((Menu.login != null)&&(Menu.senha!=null)&&(Menu.tipoPessoa!=null)) {
			System.out.println("TipoPessoa="+Menu.tipoPessoa+", Login="+Menu.login+", Senha="+Menu.senha);
		}else {
			System.out.println("Login inválido");
		}
	}

	public int menuClienteOuFuncionario() {
		System.out.println("Você é cliente ou funcionário? cliente=1 funcionario=2 Sair=0");
		return op.nextInt();
	}

	public void menuLoginCliente() {
		System.out.println("Menu login cliente");
		Menu.tipoPessoa = EnumPessoa.CLIENTE;
		System.out.print("Digite seu login: ");
		Menu.login = op.next();
		System.out.print("Digite sua senha: ");
		Menu.senha = op.next();
	}

	public void menuLoginFuncionario() {
		System.out.println("Menu login funcionario");
		Menu.tipoPessoa = EnumPessoa.FUNCIONARIO;
		System.out.print("Digite seu login: ");
		Menu.login = op.next();
		System.out.print("Digite sua senha: ");
		Menu.senha = op.next();
	}

	public void menuOpcaoNaoReconhecida() {
		System.out.println("Sua opcao de escolha nao foi reconhecida pelo nosso sistema");
	}

	public void menuSaida() {
		System.out.println("Obrigado por ter usado nosso sistema");
	}

	public int menuBoasVindas() {
		System.out.println();
		System.out.println("Seja bem vindo ao nosso banco :-)");
		System.out.print("digite qualquer tecla para continuar ou zero(0) para desligar");
		String resp = op.nextLine();
		return ("0".equals(resp)?0:1);
	}

	public void menuCliente() {		
		System.out.println();
		System.out.println("Menu Cliente");
		System.out.println("escolha uma opção abaixo");
		System.out.println("1-Saldo");
		System.out.println("2-Saque");
		System.out.println("3-Deposito");
		System.out.println("4-Transferência");
		if(((Cliente)this.pessoaLogada).getTipoConta()==EnumConta.CORRENTE) {
			System.out.println("5-Tributos (conta-corrente)");
		}else if(((Cliente)this.pessoaLogada).getTipoConta()==EnumConta.CORRENTE) {
			System.out.println("5-Simulação (poupança)");
		}
		System.out.println("6-Sair");
		int o = op.nextInt();
		switch (o) {
		case 1:
			System.out.println("Menu Saldo");
			break;
		case 2:
			System.out.println("Menu Saque");
			break;
		case 3:
			System.out.println("Menu Deposito");
			break;
		case 4:
			System.out.println("Menu Transferencia");
			break;
		case 5:
			if(((Cliente)this.pessoaLogada).getTipoConta()==EnumConta.CORRENTE) {
				System.out.println("Menu Tributos (conta-corrente)");
			}else if(((Cliente)this.pessoaLogada).getTipoConta()==EnumConta.CORRENTE) {
				System.out.println("Menu Simulação (poupança)");
			}
			break;
		case 6:
			System.out.println("sair");
			break;
		default:
			System.out.println("opção não identificada");
			menuCliente();
		}
	}

	public void menuFuncionario() {		
		System.out.println("Menu Funcionario");
		if(pessoaLogada.getTipoPessoa()==EnumPessoa.PRESIDENTE) {
			menuPresidente();		
		}else if(pessoaLogada.getTipoPessoa()==EnumPessoa.DIRETOR) {
			menuDiretor();		
		}else if(pessoaLogada.getTipoPessoa()==EnumPessoa.GERENTE) {
			menuGerente();		
		}
	}

	private void menuGerente() {
		System.out.println("Menu Funcionario");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
	}

	private void menuDiretor() {
		System.out.println("Menu Diretor");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
	}

	private void menuPresidente() {
		System.out.println("Menu Presidente");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
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


}
