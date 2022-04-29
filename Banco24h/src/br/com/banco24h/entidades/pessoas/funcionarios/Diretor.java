package br.com.banco24h.entidades.pessoas.funcionarios;

import br.com.banco24h.entidades.Estrutura;
import br.com.banco24h.entidades.estruturas.Regional;
import br.com.banco24h.entidades.pessoas.Funcionario;
import br.com.banco24h.enums.EnumPessoa;

public class Diretor extends Funcionario {
	
	private Regional regional = null;

	public Diretor(EnumPessoa tipoPessoa, int id, String nome, String cpf, String senha, int idRegional) {
		super(tipoPessoa, id , nome, cpf, senha, idRegional);
		this.regional=Estrutura.getRegionalById(idRegional);
	}

	public Regional getRegional() {
		return regional;
	}

}
