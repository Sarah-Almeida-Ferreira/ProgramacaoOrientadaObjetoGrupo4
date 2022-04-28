package br.com.residencia.bancoamazonas.leitura;

import java.io.BufferedReader;import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.residencia.bancoamazonas.contas.ContaCorrente;
import br.com.residencia.bancoamazonas.contas.ContaPoupanca;
import br.com.residencia.bancoamazonas.dados.Dados;
import br.com.residencia.bancoamazonas.enuns.TipoPessoa;
import br.com.residencia.bancoamazonas.pessoas.Cliente;
import br.com.residencia.bancoamazonas.pessoas.Diretor;
import br.com.residencia.bancoamazonas.pessoas.Gerente;
import br.com.residencia.bancoamazonas.pessoas.Presidente;

public class Leitor {
	
	private String caminhoArquivo;
	private FileReader arquivo;
	private BufferedReader lerArquivo;
	
	public List<Cliente> lerArquivoClientes (String caminhoArquivo) {
		List<Cliente> clientes = new ArrayList<>();
		try {
			arquivo = new FileReader(caminhoArquivo);
			lerArquivo = new BufferedReader(arquivo);
			
			for (String linha = lerArquivo.readLine(); linha != null; linha = lerArquivo.readLine()) {
				String[] campo = linha.split(";");
				String nome = campo[0];
				String cpf = campo[1];
				String senha = campo[2];
				Cliente cliente = new Cliente(nome, cpf, senha, TipoPessoa.CLIENTE);
				clientes.add(cliente);
			}
			
			arquivo.close();
			lerArquivo.close(); 
		} catch (Exception e) {
			System.out.println("ERRO");
		}
		return clientes;
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