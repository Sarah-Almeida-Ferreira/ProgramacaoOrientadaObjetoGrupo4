package br.com.residencia.bancoamazonas.pessoas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.com.residencia.bancoamazonas.contas.Conta;
import br.com.residencia.bancoamazonas.enuns.TipoPessoa;

public class Gerente extends Funcionario {

	private Integer numeroAgencia;

	public Gerente(String nome, String cpf, String senha, TipoPessoa tipoPessoa, String cargo, Integer numeroAgencia) {
		super(nome, cpf, senha, tipoPessoa, cargo);
		this.numeroAgencia = numeroAgencia;
	}
	
//	Metodos Publicos:
	

//  Metodos Especiais:	
	
		
	
	

}
