package br.com.banco24h.enums;

public enum EnumEstrutura {
	
	//TODO trocar EnumTipoEstrutura por EnumEstrutura
	
	BANCO("Banco","banco"),
	REGIONAL("Regional","regional"),
	AGENCIA("Agencia","agencia");

    private String descricaoprimeiraMaiuscula;
	private String descricaoMinuscula;

    EnumEstrutura(String descricaoprimeiraMaiuscula, String descricaoMinuscula) {
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