package br.com.residencia;

import java.util.Locale;

public class Cliente {
	
	private String nome;
	private String cpf;
	private String endereco;
	private double renda;
	
	public Cliente(String nome, String cpf, String endereco, double renda) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.renda = renda;
	}
	
	public String getNome() {
		return nome;
		
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}
	
	public void imprimirCliente() {
		System.out.println("--------- CONTA AMAZONAS ---------");
		System.out.println("Nome cliente: " + this.nome);
		System.out.println("CPF: " + this.cpf);
		System.out.println("Endereco: " + this.endereco);
		System.out.printf(Locale.ITALIAN, "Renda: R$ %.2f%n", this.renda);
	}
	
	
}
