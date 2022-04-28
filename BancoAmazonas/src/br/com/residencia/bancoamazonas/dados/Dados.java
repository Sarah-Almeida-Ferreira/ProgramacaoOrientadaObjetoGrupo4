package br.com.residencia.bancoamazonas.dados;

import java.util.ArrayList;
import java.util.List;

import br.com.residencia.bancoamazonas.agencias.Agencia;
import br.com.residencia.bancoamazonas.contas.Conta;
import br.com.residencia.bancoamazonas.leitura.Leitor;
import br.com.residencia.bancoamazonas.pessoas.Cliente;
import br.com.residencia.bancoamazonas.pessoas.Diretor;
import br.com.residencia.bancoamazonas.pessoas.Gerente;
import br.com.residencia.bancoamazonas.pessoas.Presidente;

public class Dados {

	private static List<Cliente> clientes = new ArrayList<>();
	private static List<Diretor> diretores = new ArrayList<>();
	private static List<Presidente> presidentes = new ArrayList<>();
	private static List<Gerente> gerentes = new ArrayList<>();
	private static List<Conta> contas = new ArrayList<>();
	private static List<Agencia> agencias = new ArrayList<>();
	
	public static List<Cliente> getClientes() {
		return clientes;
	}

	public static void setClientes() {
		Dados.clientes.add(new Cliente(Leitor.getCampos(0), Leitor.getCampos(1), Leitor.getCampos(2), Leitor.getCampos(3)));
	}

	public static void setDiretores() {
		Dados.diretores.add(new Diretor(Leitor.getCampos(0), Leitor.getCampos(1), Leitor.getCampos(2), Leitor.getCampos(3), Leitor.getCampos(4), Leitor.getCampos(5)));
	}

	public static void setPresidentes() {
		Dados.presidentes.add(new Presidente(Leitor.getCampos(0), Leitor.getCampos(1), Leitor.getCampos(2), Leitor.getCampos(3), Leitor.getCampos(4), Leitor.getCampos(5)));
	}
	
	public static void setGerentes() {
		Dados.gerentes.add(new Gerente (Leitor.getCampos(0), Leitor.getCampos(1), Leitor.getCampos(2), Leitor.getCampos(3), Leitor.getCampos(4), Leitor.getCampos(5)));
	}

	public static void setContas(List<Conta> contas) {
		Dados.contas = contas;
	}
	
	public static void setAgencias(List<Agencia> agencias) {
		Dados.agencias = agencias;
	}
    	
}
