package br.com.banco24h.sistema;

import java.util.Scanner;

import br.com.banco24h.beans.BeanLogin;
import br.com.banco24h.enums.EnumPessoa;

public class Menu {
	
	private Scanner op = new Scanner(System.in);
	
	public void fluxo() {
		int opMenuClienteOuFuncionario = 0;
		BeanLogin beanLogin = null;
		while((opMenuClienteOuFuncionario = menuClienteOuFuncionario())!=0) {
			if(opMenuClienteOuFuncionario==1) {
				beanLogin = menuLoginCliente();
			}else if(opMenuClienteOuFuncionario==2) {
				beanLogin = menuLoginFuncionario();
			}else {
				menuOpcaoNaoReconhecida();
			}
			MenuImprimeBeanLogin(beanLogin);			
		}
		menuSaida();		
	}
	
	private void MenuImprimeBeanLogin(BeanLogin beanLogin) {
		if(beanLogin != null) {
			System.out.println("TipoPessoa="+beanLogin.getTipoPessoa()+", Login="+beanLogin.getLogin()+", Senha="+beanLogin.getSenha());
		}else {
			System.out.println("Login inv�lido");
		}
	}

	public int menuClienteOuFuncionario() {
		System.out.println("Voc� � cliente ou funcion�rio? cliente=1 funcionario=2 Sair=0");
		return op.nextInt();
	}

	public BeanLogin menuLoginCliente() {
		BeanLogin beanLogin = new BeanLogin();
		System.out.println("Menu login cliente");
		beanLogin.setTipoPessoa(EnumPessoa.CLIENTE);
		System.out.print("Digite seu login: ");
		beanLogin.setLogin(op.next());
		System.out.print("Digite sua senha: ");
		beanLogin.setSenha(op.next());
		return beanLogin;
	}

	public BeanLogin menuLoginFuncionario() {
		BeanLogin beanLogin = new BeanLogin();
		System.out.println("Menu login funcionario");
		beanLogin.setTipoPessoa(EnumPessoa.FUNCIONARIO);
		System.out.print("Digite seu login: ");
		beanLogin.setLogin(op.next());
		System.out.print("Digite sua senha: ");
		beanLogin.setSenha(op.next());
		return beanLogin;
	}

	public void menuOpcaoNaoReconhecida() {
		System.out.println("Sua opcao de escolha nao foi reconhecida pelo nosso sistema");
	}

	public void menuSaida() {
		System.out.println("Obrigado por ter usado nosso sistema");
	}

}
