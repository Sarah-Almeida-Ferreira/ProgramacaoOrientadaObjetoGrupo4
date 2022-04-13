package br.com.residencia;

public class Conta {

	public int numConta;
	private String nome;
	public double saldo = 0;
	
//  Métodos Públicos:
	
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

//	Métodos Especiais:
	
	public Conta(int numConta, String nome, double saldo) {
		super();
		this.numConta = numConta;
		this.nome = nome;
		this.saldo = saldo;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	

	
		
}
