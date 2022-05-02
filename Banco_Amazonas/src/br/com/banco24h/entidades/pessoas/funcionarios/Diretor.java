package br.com.banco24h.entidades.pessoas.funcionarios;

import java.util.Scanner;

import br.com.banco24h.entidades.Estrutura;
import br.com.banco24h.entidades.Pessoa;
import br.com.banco24h.entidades.estruturas.Regional;
import br.com.banco24h.entidades.pessoas.Funcionario;
import br.com.banco24h.enums.EnumPessoa;
import br.com.banco24h.sistema.Menu;

public class Diretor extends Funcionario {
	
	private Regional regional = null;
	private Scanner op = new Scanner(System.in);

	public Diretor(EnumPessoa tipoPessoa, int id, String nome, String cpf, String senha, int idRegional) {
		super(tipoPessoa, id , nome, cpf, senha, idRegional);
		this.regional=Estrutura.getRegionalById(idRegional);
	}

	public Regional getRegional() {
		return regional;
	}

	public void relatorioContasRegiao(Regional regiao) {
		int o;
		
		do {
			System.out.println("Relatório do número de contas da regiao: " + regiao.getNomeRegiao());
			System.out.println("Número de contas: " + Pessoa.getQuantidadeContasRegionalDiretor((Diretor)Menu.getPessoaLogada()));
			System.out.println();
			System.out.println("Digite [0] para retornar. ");
			o = op.nextInt();
		} while (o != 0);
	}
	
}
