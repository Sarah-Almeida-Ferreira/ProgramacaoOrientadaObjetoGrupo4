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
	static Leitor leitor = new Leitor();

	private static List<Cliente> clientes = leitor.lerArquivoClientes("C:\\Users\\Lucas\\Desktop\\Serratec\\ProgramacaoOrientadaObjetoGrupo4\\BancoAmazonas\\temp\\clientes.txt");
	private static List<Diretor> diretores = new ArrayList<>();
	private static List<Presidente> presidentes = new ArrayList<>();
	private static List<Gerente> gerentes = new ArrayList<>();
	private static List<Conta> contas = new ArrayList<>();
	private static List<Agencia> agencias = new ArrayList<>();
	
	public static void addClientes(Cliente cliente) {
		clientes.add(cliente);
	}

	public static List<Cliente> getClientes() {
		return clientes;
	}

	public static List<Conta> getContas() {
		return contas;
	}
	
	

	
}
