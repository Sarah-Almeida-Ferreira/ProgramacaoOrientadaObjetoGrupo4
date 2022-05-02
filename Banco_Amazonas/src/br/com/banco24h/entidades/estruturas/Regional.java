package br.com.banco24h.entidades.estruturas;

import java.util.ArrayList;

import br.com.banco24h.entidades.Estrutura;
import br.com.banco24h.entidades.pessoas.funcionarios.Diretor;
import br.com.banco24h.enums.EnumEstrutura;

public class Regional extends Estrutura{
	
	private String nomeRegiao = "";
	private int idBanco = 0;
	private Banco banco = null;
	private Diretor diretor = null;
	private ArrayList<Agencia> agencias = new ArrayList<>();

	public Regional(EnumEstrutura tipoEstrutura, int id, String nomeRegiao, int idBanco) {
		super(tipoEstrutura, id);
		this.nomeRegiao=nomeRegiao;
		this.idBanco=idBanco;
		this.banco=Estrutura.getBancoById(idBanco);
	}

	public String getNomeRegiao() {
		return this.nomeRegiao;
	}

	public int getIdBanco() {
		return this.idBanco;
	}

	public void addAgencia(Agencia agencia) {
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
			saida += agencia.getNumeroAgencia()+"/"+agencia.getEndereco();
		}
		return " agencias("+saida+")";
	}

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}
	
}
