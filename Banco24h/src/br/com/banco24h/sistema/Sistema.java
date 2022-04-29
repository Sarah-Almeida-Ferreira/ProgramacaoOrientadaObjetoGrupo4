package br.com.banco24h.sistema;
import java.util.Date;
import java.util.Random;

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
		new Menu().fluxo();
		//testeOperacoesConta();
		//popularLog();
	}

	private void testeOperacoesConta() {
		System.out.println("Teste opera��es conta");
		Conta contaA = Conta.getContaById(2001);
		System.out.println("ContaA: "+contaA.getId());
		System.out.println("saldoA: "+contaA.getSaldo());
		double valor = 100.10d;
		System.out.println("dep�sitoA: "+valor);
		try {
			Conta.depositar(contaA, valor);
			Log.addLog("Deposito: conta: "+contaA.getId()+" valor="+String.format("%.2f", valor));
		} catch (Exception e) {
			System.out.println("#Erro#"+e.getMessage());
		}
		System.out.println("saldoA: "+contaA.getSaldo());
		System.out.println();
		Conta contaB = Conta.getContaById(2002);
		System.out.println("ContaB: "+contaB.getId());
		System.out.println("saldoB: "+contaB.getSaldo());
		System.out.println("TransferenciaA->B: contaOrigem="+contaA.getId()+" contaDestino="+contaB.getId()+" valor="+valor);
		try {
			Conta.transferir(contaA, contaB, valor);
			Log.addLog("Transferencia: contaAOrigem: "+contaA.getId()+" contaDestino: "+contaB.getId()+" valor="+String.format("%.2f", valor));
		} catch (Exception e) {
			System.out.println("#Erro#"+e.getMessage());
		}
		System.out.println("saldoA: "+contaA.getSaldo());
		System.out.println("saldoB: "+contaB.getSaldo());
		try {
			Conta.sacar(contaA, valor);
		} catch (Exception e) {
			System.out.println("#Erro#"+e.getMessage());
		}
		System.out.println();
		System.out.println("sacarB: "+valor);
		try {
			Conta.sacar(contaB, valor);
			Log.addLog("Saque: contaA: "+contaB.getId()+" valor="+String.format("%.2f", valor));
		} catch (Exception e) {
			System.out.println("#Erro#"+e.getMessage());
		}
		System.out.println("saldoB: "+contaB.getSaldo());
	}

	private void popularLog() {//m�todo descart�vel //TODO Excluir m�todo
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
