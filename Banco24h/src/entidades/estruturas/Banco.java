package entidades.estruturas;

import entidades.Estrutura;

public class Banco extends Estrutura{
	
	private String nomeBanco = "";

	public Banco(EnumTipoEstrutura tipoEstrutura, int id, String nomeBanco) {
		super(tipoEstrutura, id);
		this.nomeBanco=nomeBanco;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

}
