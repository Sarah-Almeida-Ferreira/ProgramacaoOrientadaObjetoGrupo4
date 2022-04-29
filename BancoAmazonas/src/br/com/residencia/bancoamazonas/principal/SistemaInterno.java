package br.com.residencia.bancoamazonas.principal;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import br.com.residencia.bancoamazonas.leitura.Leitor;
import br.com.residencia.bancoamazonas.menu.MenuInterativo;

public class SistemaInterno {

	public static void main(String[] args) throws IOException, ParseException {
		Scanner sc = new Scanner(System.in);
		MenuInterativo.menuCliente(sc);
		sc.close();
		
		
		
//		
//		clientes.forEach(cliente ->System.out.println(cliente));
//		
//		for(int i = 0; i < clientes.size(); i++) {
//			System.out.println(clientes.get(i));
//		}

// Servicos.login();
//		Conta conta1 = new ContaCorrente();
//		Conta conta2 = new ContaCorrente();
//		Conta conta3 = new ContaCorrente();
//		Gerente gerente = new Gerente();
//		
//			
//		
//		
//		Conta.getTotalDeContas();
//		System.out.println(Conta.getTotalDeContas());

	}

}
