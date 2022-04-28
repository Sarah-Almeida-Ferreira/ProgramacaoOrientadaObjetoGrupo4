package br.com.residencia.bancoamazonas.pessoas;

import java.util.*;
import br.com.residencia.bancoamazonas.agencias.Agencia;
import br.com.residencia.bancoamazonas.enuns.TipoPessoa;

public class Diretor extends Funcionario {

	List<Agencia> agencias;
	
	public Diretor(String nome, String cpf, String senha, TipoPessoa tipoPessoa, String cargo, List<Agencia> agencias) {
		super(nome, cpf, senha, tipoPessoa, cargo);
		this.agencias = agencias;
	}

	
}
