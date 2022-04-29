package entidades.pessoas;

import entidades.Pessoa;

public class Cliente extends Pessoa {

	public Cliente(EnumTipoPessoa tipoPessoa, int id, String nome, String cpf, String senha) {
		super(tipoPessoa, id , nome, cpf, senha);
	}

}
