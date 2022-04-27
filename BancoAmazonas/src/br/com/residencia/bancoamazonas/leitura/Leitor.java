package br.com.residencia.bancoamazonas.leitura;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.residencia.bancoamazonas.pessoas.Cliente;

public class Leitor {

	public static final String PATH_BASICO = "./temp/";
	public static final String EXTENSAO = ".txt";

	static List<Cliente> clientes = new ArrayList<>();

	String txtCliente = "txtCliente.txt";

	public static void leitor(String txtCliente) throws IOException {
	BufferedReader leitor = new BufferedReader(new FileReader(PATH_BASICO + txtCliente + EXTENSAO));

	String linha = "";

	while(true)
	{
		linha = leitor.readLine();
		if (linha != null) {
			String[] vetor = linha.split(";");
			if (vetor[0].equalsIgnoreCase("Cliente")) {

				clientes.add(new Cliente(vetor[1], (vetor[2])));

			}
		} else {
			break;
		}

	}
	leitor.close();
}}
