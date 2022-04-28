package br.com.residencia.bancoamazonas.servicos;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import br.com.residencia.bancoamazonas.contas.Conta;
import br.com.residencia.bancoamazonas.dados.Dados;
import br.com.residencia.bancoamazonas.leitura.Leitor;
import br.com.residencia.bancoamazonas.menu.MenuInterativo;
import br.com.residencia.bancoamazonas.pessoas.Cliente;
import br.com.residencia.bancoamazonas.pessoas.Pessoa;

public class Login {
	private String cpf;
	private String senha;
	private boolean autenticidade = false;
	Cliente cliente = new Cliente("","","",null);
	
	public Login(String cpf, String senha) {		
		this.cpf = cpf;
		this.senha = senha;
	}
	
	public void fazerLogin() {
		autenticarUsuario();	
		if(autenticidade == true) {
			MenuInterativo.menuCliente(cliente);
			} else {
				System.out.println("Usuário e senha incorretos.");
			} 	
		}

	public void autenticarUsuario() {
		for(int i = 0;  i < Dados.getClientes().size(); i++) {
			if(this.cpf.equals(Dados.getClientes().get(i).getCpf())
				&& this.senha.equals(Dados.getClientes().get(i).getSenha())) {
				cliente = Dados.getClientes().get(i);
				autenticidade = true;
			} 
		}
	}
}	
	
//	public int pesquisarIndiceUsuario(){
//		boolean achou = false;
//		int indice = -1;
//		do{
//			indice++;
//		} while ((achou = false) && (indice < Pessoa.getTotalPessoas()));
//		if(achou = true){
//			return indice;
//		}
//	}
//	
//	public boolean verificaSeEhUsuario() {
//		
//	}

