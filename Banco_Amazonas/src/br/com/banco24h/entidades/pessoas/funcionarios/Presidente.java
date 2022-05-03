package br.com.banco24h.entidades.pessoas.funcionarios;

import java.util.Scanner;

import br.com.banco24h.entidades.Estrutura;
import br.com.banco24h.entidades.Pessoa;
import br.com.banco24h.entidades.estruturas.Banco;
import br.com.banco24h.entidades.pessoas.Funcionario;
import br.com.banco24h.enums.EnumPessoa;
import br.com.banco24h.sistema.Log;
import br.com.banco24h.sistema.Menu;
import br.com.banco24h.sistema.Parametros;

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
	
	public static void relatorioCapitalBanco(Banco banco, Pessoa pessoa) {
		int o;
		String saida = "";
		do {
		System.out.println("== Relatorio capital acumulado do banco " + banco.getNomeBanco() + "==\n");
		saida += "== Relatorio capital acumulado do banco " + banco.getNomeBanco() + "==\n";
		System.out.println("Capital do banco em R$: " + String.format("%.2f", Pessoa.getCapitalTotalBanco(banco)));
		saida += "Capital do banco em R$: " + String.format("%.2f", Pessoa.getCapitalTotalBanco(banco));
		System.out.println();
		System.out.println("Digite [0] para retornar.");
		o = op.nextInt();
		} while (o != 0);
		String nomeArqRelatorio = Parametros.ARQUIVO_RELATORIOS_PREFIX+"_"+pessoa.getTipoPessoa().getDescricaoPrimeiraMaiuscula()+"_"+Log.getDateTimeTag()+Parametros.ARQUIVO_RELATORIOS_SUFIX;;
		Log.addLogRelatorio(saida);
		Log.descarregarLogRelatorio(nomeArqRelatorio);
	}
	
	public static void relatorioContasBanco(Banco banco, Pessoa pessoa) {
		int o;
		String saida = "";
		do {
			System.out.println("== Relatorio numero de contas do banco " + banco.getNomeBanco()+"==\n");
			saida += "== Relatorio numero de contas do banco " + banco.getNomeBanco()+"==\n";
			System.out.println("Numero de contas: " + Pessoa.getQuantidadeContas_BancoPresidente((Presidente)Menu.getPessoaLogada()));
			saida += "Numero de contas: " + Pessoa.getQuantidadeContas_BancoPresidente((Presidente)Menu.getPessoaLogada());
			System.out.println();
			System.out.println("Digite [0] para retornar. ");
			o = op.nextInt();
		} while(o != 0);
		String nomeArqRelatorio = Parametros.ARQUIVO_RELATORIOS_PREFIX+"_"+pessoa.getTipoPessoa().getDescricaoPrimeiraMaiuscula()+"_"+Log.getDateTimeTag()+Parametros.ARQUIVO_RELATORIOS_SUFIX;;
		Log.addLogRelatorio(saida);
		Log.descarregarLogRelatorio(nomeArqRelatorio);
	}

}
