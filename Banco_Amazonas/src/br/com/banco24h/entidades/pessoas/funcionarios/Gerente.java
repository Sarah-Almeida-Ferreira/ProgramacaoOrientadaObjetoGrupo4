package br.com.banco24h.entidades.pessoas.funcionarios;

import java.util.Scanner;

import br.com.banco24h.entidades.Estrutura;
import br.com.banco24h.entidades.Pessoa;
import br.com.banco24h.entidades.estruturas.Agencia;
import br.com.banco24h.entidades.pessoas.Funcionario;
import br.com.banco24h.enums.EnumPessoa;
import br.com.banco24h.sistema.Menu;

public class Gerente extends Funcionario {
	
	private Agencia agencia = null;
	private Scanner op = new Scanner(System.in);

	public Gerente(EnumPessoa tipoPessoa, int id, String nome, String cpf, String senha, int idAgencia) {
		super(tipoPessoa, id , nome, cpf, senha, idAgencia);
		this.agencia=Estrutura.getAgenciaById(idAgencia);
	}

	public Agencia getAgencia() {
		return agencia;
	}
	
	public void relatorioContasDaAgencia() {
		int o;	
		do {
			System.out.println("== Relatório do número de contas da sua agência ==");
			System.out.println();
			System.out.println("Número de contas: " + Pessoa.getQuantidadeContasAgenciaGerente((Gerente)Menu.getPessoaLogada()));
			System.out.println();
			System.out.println("Digite [0] para retornar: ");
			o = op.nextInt();
		} while(o != 0);
	}

}
