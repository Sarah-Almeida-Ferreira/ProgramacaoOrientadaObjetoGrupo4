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

	
}
