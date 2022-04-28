package sistema;
import java.util.ArrayList;

import contas.Conta;
import pessoas.Pessoa;

public class Dados {
	
	private static ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	private static ArrayList<Conta> contas = new ArrayList<Conta>();
	
	public static void addPessoa(Pessoa pessoa) {
		Dados.pessoas.add(pessoa);
	}
	
	public static void addConta(Conta conta) {
		Dados.contas.add(conta);
	}
	
	public static int getQuantidadePessoas() {
		return pessoas.size();
	}

	public static int getQuantidadeContas() {
		return contas.size();
	}
	
	public static String listarPessoas() {
		String saida = "";
		int i = 1;
		for(Pessoa pessoa: pessoas) {
			saida += (saida==""?"":"\n");
			saida += ""+(i++)+"-"+pessoa.getNome()+"("+pessoa.getTipoPessoa()+")";
		}
		return saida;
	}

	public static String listarContas() {
		String saida = "";
		int i = 1;
		for(Conta conta: contas) {
			saida += (saida==""?"":"\n");
			saida += ""+(i++)+"-"+conta.getNumeroConta()+"("+conta.getTipoConta()+")";
		}
		return saida;
	}

}
