package br.com.residencia.bancoamazonas.servicos;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import br.com.residencia.bancoamazonas.contas.Conta;
import br.com.residencia.bancoamazonas.leitura.Leitor;
import br.com.residencia.bancoamazonas.menu.MenuInterativo;
import br.com.residencia.bancoamazonas.pessoas.Cliente;
import br.com.residencia.bancoamazonas.pessoas.Pessoa;

public class Login {
	private String cpf;
	private String senha;
		
	public Login(String cpf, String senha) {		
		this.cpf = cpf;
		this.senha = senha;
	}
	
	public void fazerLogin() {
		Leitor leitor = new Leitor();
		final String CAMINHO_BASE_AGENCIA = ".\temp\base_agencia.txt";
		final String CAMINHO_BASE_PESSOA = ".\temp\base_pessoa.txt";
		final String CAMINHO_ARQUIVO_CONTA = ".\temp\base_conta.txt";
		
		List<Pessoa> clientes = leitor.lerArquivoClientes(CAMINHO_BASE_PESSOA);

		for(int i = 0; i < clientes.size(); i++) {
			if(this.cpf.equals(clientes.get(i).getCpf())
				&& this.senha.equals(clientes.get(i).getSenha())) {
				MenuInterativo.menuCliente(clientes.get(i));
			}
		} 
		System.out.println("Usu�rio e senha incorretos.");
		
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
}
