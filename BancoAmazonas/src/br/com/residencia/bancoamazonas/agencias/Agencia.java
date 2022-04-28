package br.com.residencia.bancoamazonas.agencias;

public class Agencia {

	private String numeroAgencia;
	private String regiao;
	
	public Agencia(String numeroAgencia, String regiao) {
		super();
		this.numeroAgencia = numeroAgencia;
		this.regiao = regiao;
	}

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public String getRegiao() {
		return regiao;
	}
	
}
