package br.com.banco24h.entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.com.banco24h.entidades.contas.Corrente;
import br.com.banco24h.entidades.contas.Poupanca;
import br.com.banco24h.entidades.estruturas.Agencia;
import br.com.banco24h.entidades.pessoas.Cliente;
import br.com.banco24h.enums.EnumConta;
import br.com.banco24h.sistema.Parametros;

public abstract class Conta {
	
	private static Map<Integer, Conta> contas = new HashMap<>();
	
	private EnumConta tipoConta;
	private int id = 0;
	private int numeroConta = 0;
	private int idAgencia = 0;
	private int idCliente = 0;
	private double saldo = 0d;

	private Agencia agencia = null;
	private Cliente cliente = null;

	protected Conta(EnumConta tipoConta, int id, int numeroConta, int idAgencia, int idCliente, double saldo) {
		this.tipoConta=tipoConta;
		this.id=id;
		this.numeroConta=numeroConta;
		this.idAgencia=idAgencia;
		this.idCliente=idCliente;
		this.agencia=Estrutura.getAgenciaById(idAgencia);
		this.cliente=Pessoa.getClienteById(idCliente);
		this.saldo=saldo;
	}
	
	public EnumConta getTipoConta() {
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

	public int getIdCliente() {
		return idCliente;
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
			saida += ", Agencia("+c.getAgencia().getNumeroAgencia()+"/"+c.getAgencia().getEndereco()+")";
			saida += ", Cliente("+c.getCliente().getNome()+")";
			saida += ", saldo="+String.format("%.2f", c.getSaldo());			
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
        	double saldo = 0d;
        	Corrente corrente;
        	Poupanca poupanca;
	        while((linha = arquivo.readLine()) != null){
	        	if(!linha.startsWith(Parametros.TAG_COMENTARIO)) {
		            campos = linha.split(Parametros.DELIMITADOR_CAMPOS);
		            if(campos.length>=1) tipoConta = campos[0];
		            if(campos.length>=2) id = Integer.valueOf(campos[1]); 
		            if(campos.length>=3) numeroConta = Integer.valueOf(campos[2]); 
		            if(campos.length>=4) idAgencia = Integer.valueOf(campos[3]); 
		            if(campos.length>=5) idPessoa = Integer.valueOf(campos[4]); 
		            if(campos.length>=6) saldo = Double.valueOf(campos[5]); 
	            	if (tipoConta.toUpperCase().equals(EnumConta.CORRENTE.name())) {
			            corrente = new Corrente(EnumConta.CORRENTE, id, numeroConta, idAgencia, idPessoa, saldo);
						Conta.addConta(corrente);
						corrente.getAgencia().addConta(corrente);
						corrente.getCliente().setConta(corrente);
	            	}else if (tipoConta.toUpperCase().equals(EnumConta.POUPANCA.name())) {
			            poupanca = new Poupanca(EnumConta.POUPANCA, id, numeroConta, idAgencia, idPessoa, saldo);
						Conta.addConta(poupanca);
						poupanca.getAgencia().addConta(poupanca);
						poupanca.getCliente().setConta(poupanca);
	            	}else{
	            		System.out.println("#Erro#Tipo de conta não identificado: "+tipoConta);
					}
	            	tipoConta = "";
	            	id = 0;
	            	numeroConta = 0;
	            	idAgencia = 0; 
	            	idPessoa = 0; 
	            	saldo = 0d;
	            	corrente = null;
	            	poupanca = null;
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

	public Agencia getAgencia() {
		return agencia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double novoSaldo) {
		this.saldo = novoSaldo;
	}

	public static double sacar(Conta conta, double valorSacado) throws Exception {
		if (conta.getSaldo() < valorSacado) throw new Exception("Não há saldo disponível");
		conta.setSaldo(conta.getSaldo()-valorSacado);
		return valorSacado;
	}

	public static void depositar(Conta conta, double valorDepositado) throws Exception {
		if(valorDepositado<0) throw new Exception("O Valor a ser depositado não pode ser negativo");
		conta.setSaldo(conta.getSaldo()+valorDepositado);
	}

	public static void transferir(Conta contaOrigem, Conta contaDestino, double valorTransferido) throws Exception {
		if(valorTransferido<0) throw new Exception("O Valor a ser tranferido não pode ser negativo");
		double valorSacado = Conta.sacar(contaOrigem, valorTransferido);
		Conta.depositar(contaDestino, valorSacado);
	}

	public static Conta getContaById(int idConta) {
		return (Conta)Conta.contas.get(idConta);
	}

}
