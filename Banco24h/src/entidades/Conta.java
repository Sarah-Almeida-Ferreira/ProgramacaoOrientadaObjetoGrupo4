package entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import entidades.contas.Corrente;
import entidades.contas.Poupanca;
import sistema.Parametros;

public abstract class Conta {
	
	private static HashMap<Integer, Conta> contas = new HashMap<>();
	
	public enum EnumTipoConta {CORRENTE, POUPANCA};
	
	private EnumTipoConta tipoConta;
	private int id = 0;
	private int numeroConta = 0;
	private int idAgencia = 0;
	private int idPessoa = 0;
	
	protected Conta(EnumTipoConta tipoConta, int id, int numeroConta, int idAgencia, int idPessoa) {
		this.tipoConta=tipoConta;
		this.id=id;
		this.numeroConta=numeroConta;
		this.idAgencia=idAgencia;
		this.idPessoa=idPessoa;
	}
	
	public EnumTipoConta getTipoConta() {
		return tipoConta;
	}

	public int getId() {
		return this.id;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public int getIdAgencia() {
		return idAgencia;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public static void addConta(Conta conta) {
		Conta.contas.put(conta.id, conta);
	}
	
	public static int getQuantidadeContas() {
		return contas.size();
	}
	
	public static String listarContas() {
		String saida = "";
		Conta c;
		for (int idConta : contas.keySet()) {
			c = contas.get(idConta);
			saida += (saida==""?"":"\n");
			saida += c.getTipoConta().name()+"(";
			saida += "idConta="+idConta;
			saida += ", numeroConta= "+c.getNumeroConta();
			saida += ", idAgencia="+c.getIdAgencia();
			saida += ", idPessoa="+c.getIdPessoa();
			if(c.getTipoConta()==EnumTipoConta.CORRENTE) {
				saida += ", limite="+((Corrente)c).getLimite();
			}else if(c.getTipoConta()==EnumTipoConta.POUPANCA) {
				saida += ", aniversario="+((Poupanca)c).getAniversario();
			}
			saida += ")";
		}
		return saida;
	}

	public static void Carregar(String pathArquivo) {
		BufferedReader arquivo = null;
		try {
			arquivo = new BufferedReader(new FileReader(pathArquivo));
	        String linha;
	        String[] campos;
        	String tipoConta = "";
        	int id = 0; 
        	int numeroConta = 0; 
        	int idAgencia = 0; 
        	int idPessoa = 0;
        	int limite = 0; 
        	int aniversario = 0; 
	        while((linha = arquivo.readLine()) != null){
	        	if(!linha.startsWith(Parametros.TAG_COMENTARIO)) {
		            campos = linha.split(Parametros.DELIMITADOR_CAMPOS);
		            if(campos.length>=1) tipoConta = campos[0];
		            if(campos.length>=2) id = Integer.valueOf(campos[1]); 
		            if(campos.length>=3) numeroConta = Integer.valueOf(campos[2]); 
		            if(campos.length>=4) idAgencia = Integer.valueOf(campos[3]); 
		            if(campos.length>=5) idPessoa = Integer.valueOf(campos[4]); 
	            	if (tipoConta.toUpperCase().equals(EnumTipoConta.CORRENTE.name())) {
			            if(campos.length>=6) limite = Integer.valueOf(campos[5]); 
						Conta.addConta(new Corrente(EnumTipoConta.CORRENTE, id, numeroConta, idAgencia, idPessoa, limite));
	            	}else if (tipoConta.toUpperCase().equals(EnumTipoConta.POUPANCA.name())) {
			            if(campos.length>=6) aniversario = Integer.valueOf(campos[5]); 
						Conta.addConta(new Poupanca(EnumTipoConta.POUPANCA, id, numeroConta, idAgencia, idPessoa, aniversario));
	            	}else{
	            		System.out.println("#Erro#Tipo de conta não identificado: "+tipoConta);
					}
	            	tipoConta = "";
	            	id = 0;
	            	numeroConta = 0;
	            	idAgencia = 0; 
	            	idPessoa = 0; 
	            	limite = 0;
	            	aniversario = 0;
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

}
