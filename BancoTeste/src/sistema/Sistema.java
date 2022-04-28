package sistema;
import java.util.Date;
import java.util.Random;

import entidades.Conta;
import entidades.Pessoa;

public class Sistema implements Parametros{	
	
	public void start() {
		carregar();
		listar();
		iniciar();
		descarregar();
	}
	
	public void carregar() {
		Pessoa.Carregar(Parametros.ARQUIVO_PESSOAS);
		Conta.Carregar(Parametros.ARQUIVO_CONTAS);
	}
	
	public void listar() {
		System.out.println("Listagem de Pessoas");
		System.out.println(Pessoa.listarPessoas());
		System.out.println();
		System.out.println("Listagem de Contas");
		System.out.println(Conta.listarContas());
		System.out.println();
	}

	public void descarregar() {
		Relatorio.descarregar(Parametros.ARQUIVO_RELATORIOS);
	}

	public void iniciar() {        
		popularLog();
	}

	private void popularLog() {//método descartável //TODO Excluir método
		Random gerador = new Random();
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
	}
	
}
