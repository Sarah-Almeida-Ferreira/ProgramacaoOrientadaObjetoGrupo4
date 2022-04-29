package entidades.pessoas.funcionarios;

import entidades.pessoas.Funcionario;

public class Gerente extends Funcionario {

	public Gerente(EnumTipoPessoa tipoPessoa, int id, String nome, String cpf, String senha, int idLotacao) {
		super(tipoPessoa, id , nome, cpf, senha, idLotacao);
	}

}
