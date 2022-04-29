package br.com.residencia.banco24h.pessoas;

import entidades.Estrutura;
import entidades.Pessoa;

public abstract class Funcionario extends Pessoa {
	
	private Estrutura lotacao;
	private int idLotacao = 0;

	public Funcionario(EnumTipoPessoa tipoPessoa, int id, String nome, String cpf, String senha, int idLotacao) {
		super(tipoPessoa, id , nome, cpf, senha);
		this.idLotacao=idLotacao;
	}
	
	public int getIdLotacao() {
		return this.idLotacao;
	}

}
