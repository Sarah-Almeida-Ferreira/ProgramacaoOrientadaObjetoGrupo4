package br.com.banco24h.entidades.pessoas.funcionarios;

import br.com.banco24h.entidades.Estrutura;
import br.com.banco24h.entidades.estruturas.Banco;
import br.com.banco24h.entidades.pessoas.Funcionario;
import br.com.banco24h.enums.EnumPessoa;

public class Presidente extends Funcionario {
	
	private Banco banco = null;

	public Presidente(EnumPessoa tipoPessoa, int id, String nome, String cpf, String senha, int idLotacao) {
		super(tipoPessoa, id , nome, cpf, senha, idLotacao);
		this.banco=Estrutura.getBancoById(idLotacao);
	}

	public Banco getBanco() {
		return banco;
	}

}
