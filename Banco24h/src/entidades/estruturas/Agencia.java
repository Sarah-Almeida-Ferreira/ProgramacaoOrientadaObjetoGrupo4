package entidades.estruturas;

import entidades.Estrutura;

public class Agencia extends Estrutura{
	
	private int numeroAgencia = 0;
	private int idRegiao = 0;
	private String endereco = "";
	
	public Agencia(EnumTipoEstrutura tipoEstrutura, int id, int numeroAgencia, int idRegiao, String endereco) {
		super(tipoEstrutura, id);
		this.numeroAgencia=numeroAgencia;
		this.idRegiao=idRegiao;
		this.endereco=endereco;
	}

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public int getIdRegiao() {
		return idRegiao;
	}

	public String getEndereco() {
		return endereco;
	}

}
