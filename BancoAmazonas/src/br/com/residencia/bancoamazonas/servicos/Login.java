package br.com.residencia.bancoamazonas.servicos;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import br.com.residencia.bancoamazonas.pessoas.Pessoa;

public class Login {
	private String cpf;
	private String senha;
	private Scanner sc = new Scanner(System.in);
		
	public void login() {		
		System.out.println("Digite seu cpf:");
			cpf = sc.next();
		System.out.println("Digite sua senha:");
			senha = sc.next();
	}
	
	public boolean autenticacao() {
		return true;
	}
	
	public int pesquisarIndiceUsuario(){
		boolean achou = false;
		int indice = -1;
		do{
			indice++;
		} while ((achou = false) && (indice < Pessoa.getTotalPessoas()));
		if(achou = true){
			return indice;
		}
	}
	
	public boolean verificaSeEhUsuario() {
		
	}
}
