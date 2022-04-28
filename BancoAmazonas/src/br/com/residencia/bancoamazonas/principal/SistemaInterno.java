package br.com.residencia.bancoamazonas.principal;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.residencia.bancoamazonas.enuns.TipoPessoa;
import br.com.residencia.bancoamazonas.leitura.Leitor;
import br.com.residencia.bancoamazonas.pessoas.Cliente;
import br.com.residencia.bancoamazonas.servicos.Login;

public class SistemaInterno {

	public static void main(String[] args) throws IOException, ParseException {
		
		Cliente cliente1 = new Cliente("sarah", "12345678910", "7440", TipoPessoa.CLIENTE);
		
		Scanner sc = new Scanner (System.in);
		String cpf;
		String senha;
		
		System.out.println("Digite cpf");
			cpf = sc.next();
		System.out.println("Digite senha");
			senha = sc.next();
		
		Login login = new Login(cpf, senha);
		
		login.fazerLogin();
		
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
