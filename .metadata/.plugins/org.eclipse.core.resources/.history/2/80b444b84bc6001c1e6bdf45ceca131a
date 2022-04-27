package br.com.residencia.bancoamazonas.leitura;

import java.io.BufferedReader;
import java.io.FileReader;

public class Leitor {
	
	BufferedReader reader = new BufferedReader(new FileReader(arquivo));
	String linha = "";
	while (true) {
		linha = reader.readLine();
		if (linha != null) {
			String[] vetor = linha.split(";");
			if (vetor[0].equalsIgnoreCase("Lanche")) {
				lanches.add(new Lanche(vetor[1], Double.parseDouble(vetor[2])));
			} else if (vetor[0].equalsIgnoreCase("Bebida")) {
				bebidas.add(new Bebida(vetor[1], Double.parseDouble(vetor[2])));
			}
		} else {
			break;
		}

	}

	reader.close();
	
	
}
