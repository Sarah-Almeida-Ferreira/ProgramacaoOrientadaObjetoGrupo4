package entidades.estruturas;

import entidades.Estrutura;

public class Regional extends Estrutura{
	
	private String nomeRegiao = "";
	private int idBanco = 0;

	public Regional(EnumTipoEstrutura tipoEstrutura, int id, String nomeRegiao, int idBanco) {
		super(tipoEstrutura, id);
		this.nomeRegiao=nomeRegiao;
		this.idBanco=idBanco;
	}

	public String getNomeRegiao() {
		return nomeRegiao;
	}

	public int getIdBanco() {
		return idBanco;
	}

}
