package br.com.residencia.bancoamazonas.leitura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import br.com.residencia.bancoamazonas.contas.ContaCorrente;
import br.com.residencia.bancoamazonas.contas.ContaPoupanca;
import br.com.residencia.bancoamazonas.dados.Dados;
import br.com.residencia.bancoamazonas.enuns.TipoPessoa;
import br.com.residencia.bancoamazonas.pessoas.Cliente;
import br.com.residencia.bancoamazonas.pessoas.Diretor;
import br.com.residencia.bancoamazonas.pessoas.Gerente;
import br.com.residencia.bancoamazonas.pessoas.Presidente;

public class Leitor {
	
	public static void carregarPessoas() {
		BufferedReader arquivo = null;
		try {
			arquivo = new BufferedReader(new FileReader("./cargas/base_pessoa.txt"));
	        String linha;
	        String[] campos;
	        while((linha = arquivo.readLine()) != null){
	            campos = linha.split(Parametros.DELIMITADOR_CAMPOS);
	            String tipoPessoa = campos[0];
	            String nome = campos[1];
	            String cpf = campos[2];
	            String senha = campos[3];
	            Double salario = Double.parseDouble(campos[4]);
	            String numeroAgencia = campos[5];
	            
	            switch (tipoPessoa) {
					case Parametros.TAG_CLIENTE:
						Dados.addPessoa(new Cliente(tipoPessoa, nome, cpf, senha));
						break;
					case Parametros.TAG_PRESIDENTE:
						Dados.addPessoa(new Presidente(tipoPessoa, nome, cpf, senha, salario));
						break;
					case Parametros.TAG_DIRETOR:
						Dados.addPessoa(new Diretor(tipoPessoa, nome, cpf, senha, salario));
						break;
					case Parametros.TAG_GERENTE:
						Dados.addPessoa(new Gerente(tipoPessoa, nome, cpf, senha, salario, numeroAgencia));
						break;
					default:
			            System.out.println("#Erro#Tipo de pessoa não identificado");
			            continue;
				}
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
        if (arquivo!=null) {
			try {
				arquivo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}
	
	
//	static String linha;
//	static String[] campos; 
//	
//	public static String indentificarTipoObjeto() {
//		String tipoObjeto = campos[0];
//		return tipoObjeto;
//	}
//	
//	public static String getCampos(int posicao) {
//		return campos[posicao];
//	}
//		
//	public static void criarObjeto() {
//		switch (indentificarTipoObjeto()) {
//			case Parametros.TAG_CLIENTE:
//				Dados.setClientes();
//					break;
//			case Parametros.TAG_PRESIDENTE:
//				Dados.setPresidentes();
//				break;
//			case Parametros.TAG_DIRETOR:
//				Dados.setDiretores();
//				break;
//			case Parametros.TAG_GERENTE:
//				Dados.setGerentes();
//				break;
//			default:
//		       	System.out.println("#Erro# Tipo de objeto não identificado");
//		      }
//           }
//		
//	public static void carregarDados(String nomeArquivo) { 
//		BufferedReader arquivo = null;
//			
//		try {
//			arquivo = new BufferedReader(new FileReader(nomeArquivo));
//	        while((linha = arquivo.readLine()) != null){
//	            campos = linha.split(;);
//	            indentificarTipoObjeto();
//	            criarObjeto();
//	            } 
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//        if (arquivo!=null) {
//			try {
//				arquivo.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//        }
//	}
//	
//	
//	
//
//	public static void listarPessoas() {
//		System.out.println("Listagem de Pessoas");
//		System.out.println(clientes.get);
//        System.out.println();
//	}
//
//	public static void listarContas() {
//		System.out.println("Listagem de Contas");
//		System.out.println(Dados.listarContas());
//        System.out.println();
//	}
//
//	
//	
		
}