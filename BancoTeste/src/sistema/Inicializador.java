package sistema;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import contas.Corrente;
import contas.Poupanca;
import pessoas.Cliente;
import pessoas.Diretor;
import pessoas.Gerente;
import pessoas.Presidente;

public class Inicializador {
	
	public static void CarregarPessoas() {
		BufferedReader arquivo = null;
		try {
			arquivo = new BufferedReader(new FileReader(Parametros.ARQUIVO_PESSOAS));
	        String linha;
	        String[] campos;
	        while((linha = arquivo.readLine()) != null){
	            campos = linha.split(Parametros.DELIMITADOR_CAMPOS);
	            if(campos.length!=Parametros.QUANTIDADE_CAMPOS_PESSOAS) {
	            	System.out.println("#Erro#Quantidade de campos diferente do esperado");
	            	continue;
	            }else {
	            	String tipoPessoa = campos[0];
	            	String nome = campos[1]; 
	            	switch (tipoPessoa) {
						case Parametros.TAG_CLIENTE:
							Dados.addPessoa(new Cliente(tipoPessoa, nome));
							break;
						case Parametros.TAG_PRESIDENTE:
							Dados.addPessoa(new Presidente(tipoPessoa, nome));
							break;
						case Parametros.TAG_DIRETOR:
							Dados.addPessoa(new Diretor(tipoPessoa, nome));
							break;
						case Parametros.TAG_GERENTE:
							Dados.addPessoa(new Gerente(tipoPessoa, nome));
							break;
						default:
			            	System.out.println("#Erro#Tipo de pessoa não identificado");
			            	continue;
					}
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
	
	public static void CarregarContas() {
		BufferedReader arquivo = null;
		try {
			arquivo = new BufferedReader(new FileReader(Parametros.ARQUIVO_CONTAS));
	        String linha;
	        String[] campos;
	        while((linha = arquivo.readLine()) != null){
	            campos = linha.split(Parametros.DELIMITADOR_CAMPOS);
	            if(campos.length!=Parametros.QUANTIDADE_CAMPOS_CONTAS) {
	            	System.out.println("#Erro#Quantidade de campos diferente do esperado");
	            	continue;
	            }else {
	            	String tipoConta = campos[0];
	            	int numeroConta = Integer.valueOf(campos[1]); 
	            	switch (tipoConta) {
						case Parametros.TAG_CORRENTE:
							Dados.addConta(new Corrente(tipoConta, numeroConta));
							break;
						case Parametros.TAG_POUPANCA:
							Dados.addConta(new Poupanca(tipoConta, numeroConta));
							break;
						default:
			            	System.out.println("#Erro#Tipo de conta não identificado");
			            	continue;
					}
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

	public static void listarPessoas() {
		System.out.println("Listagem de Pessoas");
		System.out.println(Dados.listarPessoas());
        System.out.println();
	}

	public static void listarContas() {
		System.out.println("Listagem de Contas");
		System.out.println(Dados.listarContas());
        System.out.println();
	}

}
	
