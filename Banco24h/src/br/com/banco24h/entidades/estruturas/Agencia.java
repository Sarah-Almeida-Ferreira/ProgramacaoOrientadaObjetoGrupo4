package br.com.banco24h.entidades.estruturas;

import java.util.ArrayList;

import br.com.banco24h.entidades.Conta;
import br.com.banco24h.entidades.Estrutura;
import br.com.banco24h.entidades.pessoas.funcionarios.Gerente;
import br.com.banco24h.enums.EnumEstrutura;

public class Agencia extends Estrutura{
	
	private int numeroAgencia = 0;
	private int idRegiao = 0;
	private String endereco = "";
	private Regional regional = null;
	private Gerente gerente = null;

	private ArrayList<Conta> contas = new ArrayList<>();
	
	public Agencia(EnumEstrutura tipoEstrutura, int id, int numeroAgencia, int idRegional, String endereco) {
		super(tipoEstrutura, id);
		this.numeroAgencia=numeroAgencia;
		this.idRegiao=idRegional;
		this.endereco=endereco;
		this.regional=Estrutura.getRegionalById(idRegional);
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

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public void addConta(Conta conta) {
		this.contas.add(conta);
	}

	public ArrayList<Conta> getContas(){
		return this.contas;
	}

	public String listarContas() {
		String saida = "";
		for(Conta conta: this.contas) {
			saida += ("".equals(saida)?"":", ");
			saida += conta.getId();
		}
		return "contas("+saida+")";
	}

}
