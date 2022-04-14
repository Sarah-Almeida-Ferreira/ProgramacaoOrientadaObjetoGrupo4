package br.com.residencia;

import java.util.Locale;

public class Cliente extends Pessoa {
	
	private double renda;
	private double limiteCredito;
	
	
// Métodos Especiais:
	
	public Cliente(String nome, String cpf, String endereco, double renda, double limiteCredito) {
		super(nome, cpf, endereco);
		this.renda = renda;
		this.limiteCredito = limiteCredito;
	}

	public double getRenda() {
		return renda;
	}
	
	public void setRenda(double renda) {
		this.renda = renda;
	}
	
	public double getLimiteCredito() {
		return limiteCredito;
	}
	
	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public void imprimirCliente() {
        System.out.println("--------- CONTA AMAZONAS ---------");
        System.out.println("Nome cliente: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Endereco: " + getEndereco());
        System.out.printf("Renda: R$ %.2f%n", getRenda());
        System.out.printf("Limite de Crédito: R$ %.2f%n", getLimiteCredito());
    }
	
//	public void get() {
//		System.out.println("Nao foi possivel realizar a operacao.");
//    }
}
