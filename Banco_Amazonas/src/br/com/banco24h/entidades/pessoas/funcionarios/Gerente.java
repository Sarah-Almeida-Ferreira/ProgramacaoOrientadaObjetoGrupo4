package br.com.banco24h.entidades.pessoas.funcionarios;

import java.util.Scanner;

import br.com.banco24h.entidades.Estrutura;
import br.com.banco24h.entidades.Pessoa;
import br.com.banco24h.entidades.estruturas.Agencia;
import br.com.banco24h.entidades.pessoas.Funcionario;
import br.com.banco24h.enums.EnumPessoa;
import br.com.banco24h.sistema.Log;
import br.com.banco24h.sistema.Menu;
import br.com.banco24h.sistema.Parametros;

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
		String saida = "";
		int o;	
		do {
			System.out.println("== Relatorio do numero de contas da sua agencia ==");
			saida += "== Relatorio do numero de contas da agencia "+this.getAgencia().getNumeroAgencia()+"/"+this.getAgencia().getRegional().getNomeRegiao()+"-"+this.getAgencia().getRegional().getBanco().getNomeBanco()+" ==\n";
			System.out.println();
			System.out.println("Numero de contas: " + Pessoa.getQuantidadeContasAgenciaGerente((Gerente)Menu.getPessoaLogada()));
			saida += "Numero de contas: " + Pessoa.getQuantidadeContasAgenciaGerente((Gerente)Menu.getPessoaLogada())+"\n";
			System.out.println();
			System.out.println("Digite [0] para retornar: ");
			o = op.nextInt();
		} while(o != 0);
		String nomeArqRelatorio = Parametros.ARQUIVO_RELATORIOS_PREFIX+"_"+this.getTipoPessoa().getDescricaoPrimeiraMaiuscula()+"_"+Log.getDateTimeTag()+Parametros.ARQUIVO_RELATORIOS_SUFIX;;
		Log.addLogRelatorio(saida);
		Log.descarregarLogRelatorio(nomeArqRelatorio);
	}

}
