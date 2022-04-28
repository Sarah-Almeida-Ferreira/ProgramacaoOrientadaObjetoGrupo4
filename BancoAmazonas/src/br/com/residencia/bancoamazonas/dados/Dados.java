package br.com.residencia.bancoamazonas.dados;

import java.util.ArrayList;
import br.com.residencia.bancoamazonas.agencias.Agencia;
import br.com.residencia.bancoamazonas.contas.Conta;
import br.com.residencia.bancoamazonas.leitura.Leitor;
import br.com.residencia.bancoamazonas.pessoas.Cliente;
import br.com.residencia.bancoamazonas.pessoas.Diretor;
import br.com.residencia.bancoamazonas.pessoas.Gerente;
import br.com.residencia.bancoamazonas.pessoas.Pessoa;
import br.com.residencia.bancoamazonas.pessoas.Presidente;

public class Dados {

	private static ArrayList<Pessoa> pessoas = new ArrayList<>();
	private static ArrayList<Conta> contas = new ArrayList<>();
	private static ArrayList<Agencia> agencias = new ArrayList<>();
	
	public static void addPessoa(Pessoa pessoa) {
		Dados.pessoas.add(pessoa);
	}
	
	public static void addConta(Conta conta) {
		Dados.contas.add(conta);
	}
	
	public static void addAgencia(Agencia agencia) {
		Dados.agencias.add(agencia);
	}

	
}
