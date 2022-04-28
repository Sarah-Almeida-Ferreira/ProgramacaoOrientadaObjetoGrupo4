package entidades.pessoas.funcionarios;

import entidades.pessoas.Funcionario;

public class Presidente extends Funcionario {

	public Presidente(EnumTipoPessoa tipoPessoa, int id, String nome, String cpf, String senha, int idLotacao) {
		super(tipoPessoa, id , nome, cpf, senha, idLotacao);
	}

}
