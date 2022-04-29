package entidades.estruturas;

import entidades.Estrutura;

public class Agencia extends Estrutura{
	
	private int numeroAgencia = 0;
	private int idRegiao = 0;
	private String endereco = "";
	private Regional regional = null;
	
	public Agencia(EnumTipoEstrutura tipoEstrutura, int id, int numeroAgencia, int idRegional, String endereco) {
		super(tipoEstrutura, id);
		this.numeroAgencia=numeroAgencia;
		this.idRegiao=idRegional;
		this.endereco=endereco;
		this.regional=Estrutura.associarRegional(idRegional, this);
	}

	public int getNumeroAgencia() {
		return this.numeroAgencia;
	}

	public int getIdRegiao() {
		return this.idRegiao;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public Regional getRegional() {
		return this.regional;
	}

}
