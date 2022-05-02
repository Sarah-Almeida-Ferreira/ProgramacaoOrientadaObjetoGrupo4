package br.com.banco24h.entidades.pessoas.funcionarios;

import br.com.banco24h.entidades.Estrutura;
import br.com.banco24h.entidades.estruturas.Agencia;
import br.com.banco24h.entidades.pessoas.Funcionario;
import br.com.banco24h.enums.EnumPessoa;

public class Gerente extends Funcionario {
	
	private Agencia agencia = null;

	public Gerente(EnumPessoa tipoPessoa, int id, String nome, String cpf, String senha, int idAgencia) {
		super(tipoPessoa, id , nome, cpf, senha, idAgencia);
		this.agencia=Estrutura.getAgenciaById(idAgencia);
	}

	public Agencia getAgencia() {
		return agencia;
	}

}
