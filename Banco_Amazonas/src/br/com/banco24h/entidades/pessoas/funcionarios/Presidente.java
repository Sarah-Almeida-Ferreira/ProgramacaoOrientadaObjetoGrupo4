package br.com.banco24h.entidades.pessoas.funcionarios;

import java.util.Scanner;

import br.com.banco24h.entidades.Estrutura;
import br.com.banco24h.entidades.Pessoa;
import br.com.banco24h.entidades.estruturas.Banco;
import br.com.banco24h.entidades.pessoas.Funcionario;
import br.com.banco24h.enums.EnumPessoa;
import br.com.banco24h.sistema.Menu;

public class Presidente extends Funcionario {
	
	private Banco banco = null;
	private static Scanner op = new Scanner(System.in);

	public Presidente(EnumPessoa tipoPessoa, int id, String nome, String cpf, String senha, int idLotacao) {
		super(tipoPessoa, id , nome, cpf, senha, idLotacao);
		this.banco=Estrutura.getBancoById(idLotacao);
	}

	public Banco getBanco() {
		return banco;
	}
	
	public static void relatorioCapitalBanco(Banco banco) {
		int o;
		do {
		System.out.println("== Relatório capital acumulado do banco " + banco.getNomeBanco() + "==\n");
		System.out.println("Capital do banco em R$: " + String.format("%.2f", Pessoa.getCapitalTotalBanco(banco)));
		System.out.println();
		System.out.println("Digite [0] para retornar.");
		o = op.nextInt();
		} while (o != 0);
	}
	
	public static void relatorioContasBanco(Banco banco) {
		int o;
		do {
			System.out.println("== Relatório número de contas do banco " + banco.getNomeBanco()+"==\n");
			System.out.println("Número de contas: " + Pessoa.getQuantidadeContas_BancoPresidente((Presidente)Menu.getPessoaLogada()));
			System.out.println();
			System.out.println("Digite [0] para retornar. ");
			o = op.nextInt();
		} while(o != 0);
	}

}
