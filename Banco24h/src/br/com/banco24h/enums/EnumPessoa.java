package br.com.banco24h.enums;

public enum EnumPessoa {
	
	CLIENTE("Corrente","corrente"),
	GERENTE("Gerente","gerente"),
	DIRETOR("Diretor","diretor"),
	PRESIDENTE("Presidente","presidente");

    private String descricaoprimeiraMaiuscula;
	private String descricaoMinuscula;

    EnumPessoa(String descricaoprimeiraMaiuscula, String descricaoMinuscula) {
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