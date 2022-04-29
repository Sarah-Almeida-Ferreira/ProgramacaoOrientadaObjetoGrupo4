package br.com.residencia.banco24h.estruturas;

import java.util.ArrayList;

import entidades.Estrutura;

public class Regional extends Estrutura{
	
	private String nomeRegiao = "";
	private int idBanco = 0;
	private Banco banco = null;
	private ArrayList<Agencia> agencias = new ArrayList<>();

	public Regional(EnumTipoEstrutura tipoEstrutura, int id, String nomeRegiao, int idBanco) {
		super(tipoEstrutura, id);
		this.nomeRegiao=nomeRegiao;
		this.idBanco=idBanco;
		this.banco=Estrutura.associarBanco(idBanco, this);
	}

	public String getNomeRegiao() {
		return this.nomeRegiao;
	}

	public int getIdBanco() {
		return this.idBanco;
	}

	public void associarAgencia(Agencia agencia) {
		this.agencias.add(agencia);
	}

	public Banco getBanco() {
		return this.banco;
	}
	
	public ArrayList<Agencia> getAgencias(){
		return this.agencias;
	}

	public String listarAgencias() {
		String saida = "";
		for(Agencia agencia: this.agencias) {
			saida += ("".equals(saida)?"":", ");
			saida += agencia.getId();
		}
		return " agencias("+saida+")";
	}
	
}
