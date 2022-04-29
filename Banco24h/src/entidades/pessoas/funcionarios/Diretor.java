package entidades.pessoas.funcionarios;

import entidades.pessoas.Funcionario;

public class Diretor extends Funcionario {

	public Diretor(EnumTipoPessoa tipoPessoa, int id, String nome, String cpf, String senha, int idLotacao) {
		super(tipoPessoa, id , nome, cpf, senha, idLotacao);
	}

}
