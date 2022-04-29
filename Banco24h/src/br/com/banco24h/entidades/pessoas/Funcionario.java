package br.com.banco24h.entidades.pessoas;

import br.com.banco24h.entidades.Pessoa;
import br.com.banco24h.enums.EnumPessoa;

public abstract class Funcionario extends Pessoa {
	
	private int idLotacao = 0;

	public Funcionario(EnumPessoa tipoPessoa, int id, String nome, String cpf, String senha, int idLotacao) {
		super(tipoPessoa, id , nome, cpf, senha);
		this.idLotacao=idLotacao;
	}
	
	public int getIdLotacao() {
		return this.idLotacao;
	}

}
