package entidades.estruturas;

import java.util.ArrayList;

import entidades.Estrutura;

public class Banco extends Estrutura{
	
	private String nomeBanco = "";
	private ArrayList<Regional> regionais = new ArrayList<>();
	

	public Banco(EnumTipoEstrutura tipoEstrutura, int id, String nomeBanco) {
		super(tipoEstrutura, id);
		this.nomeBanco=nomeBanco;
	}

	public String getNomeBanco() {
		return this.nomeBanco;
	}

	public void associarRegional(Regional regional) {
		this.regionais.add(regional);
	}

	public ArrayList<Regional> getRegionais(){
		return this.regionais;
	}

	public String listarRegionais() {
		String saida = "";
		for(Regional regional: this.regionais) {
			saida += ("".equals(saida)?"":", ");
			saida += regional.getId();
		}
		return " regionais("+saida+")";
	}
}
