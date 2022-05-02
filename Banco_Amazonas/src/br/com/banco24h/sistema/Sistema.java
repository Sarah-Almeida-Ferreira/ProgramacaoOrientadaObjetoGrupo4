package br.com.banco24h.sistema;
import br.com.banco24h.entidades.Conta;
import br.com.banco24h.entidades.Estrutura;
import br.com.banco24h.entidades.Pessoa;

public class Sistema implements Parametros{	
	
	@Override
	public void start() {
		carregar();
		//listar();
		iniciar();
		descarregar();
	}
	
	@Override
	public void carregar() {
		Estrutura.Carregar(Parametros.ARQUIVO_ESTRUTURAS);
		Pessoa.Carregar(Parametros.ARQUIVO_PESSOAS);
		Conta.Carregar(Parametros.ARQUIVO_CONTAS);
	}
	
	@Override
	public void listar() {
		System.out.println("Listagem de Pessoas");
		System.out.println(Pessoa.listarPessoas());
		System.out.println();
		System.out.println("Listagem de Contas");
		System.out.println(Conta.listarContas());
		System.out.println();
		System.out.println("Listagem de Estruturas");
		System.out.println(Estrutura.listarEstruturas());
		System.out.println();
	}

	@Override
	public void descarregar() {
		Relatorio.descarregar(Parametros.ARQUIVO_RELATORIOS);
	}

	@Override
	public void iniciar() { 
		try {
			new Menu().fluxo();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//testeOperacoesConta();
		//popularLog();
	}
	
}
