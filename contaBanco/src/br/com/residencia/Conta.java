package br.com.residencia;

public class Conta {
	
	private String tipo;
	private int numConta;
	private int agencia;
	private String nomeCliente;
	private double saldo = 0;
	private boolean status;
	
//  Métodos Públicos:
	
//	public void abrirConta(String tipoConta) {
//			this.setTipo(tipoConta);
//			this.setStatus(true);
//			if (tipoConta.equals("CC")) {
//				this.setSaldo(50);
//			}else if (tipoConta.equals("CP")) {
//				this.setSaldo(150);
//			}
//			System.out.println("Conta aberta com sucesso!");
//		}
//	
//	public void fecharConta() {
//			if (this.getSaldo() > 0) {
//				System.out.println("Conta nao pode ser fechada porque ainda tem valores");
//			}else if (this.getSaldo() < 0) {
//				System.out.println("Conta nao pode ser fechada pois há débito.");
//			}else {
//				this.setStatus(false);
//				System.out.println("Conta fechada com sucesso!");
//			}
//		}
		
	public boolean sacar(double valor) {
		
		if (this.saldo < valor) {
			return false;
		
		} else {
			double novoSaldo = this.saldo - valor;
			this.saldo = novoSaldo;
			return true;
		}
		
	}
	
	public boolean transferir(double valor, Conta contaDestino) {
			sacar(valor);
			contaDestino.depositar(valor);
			return true;
		
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}

	
//  Métodos Especiais:
	
	public Conta(String tipo, int numConta, int agencia, String nomeCliente, double saldo, boolean status) {
		
		this.tipo = tipo;
		this.numConta = numConta;
		this.agencia = agencia;
		this.nomeCliente = nomeCliente;
		this.saldo = saldo;
		this.status = status;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
		
}
