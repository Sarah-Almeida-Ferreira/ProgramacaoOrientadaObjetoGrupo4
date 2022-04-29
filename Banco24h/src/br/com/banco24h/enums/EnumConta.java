package br.com.banco24h.enums;

public enum EnumConta {
	
	CORRENTE("Corrente","corrente"),
	POUPANCA("Poupança","poupança");

    private String descricaoprimeiraMaiuscula;
	private String descricaoMinuscula;

    EnumConta(String descricaoprimeiraMaiuscula, String descricaoMinuscula) {
        this.descricaoprimeiraMaiuscula = descricaoprimeiraMaiuscula;
        this.descricaoMinuscula=descricaoMinuscula;
    }
    public String getDescricaoPrimeiraMaiuscula() {
        return this.descricaoprimeiraMaiuscula;
    }
    public String getDescricaoMinuscula() {
        return this.descricaoMinuscula;
    }
}