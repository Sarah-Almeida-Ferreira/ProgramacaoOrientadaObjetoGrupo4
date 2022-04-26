package br.com.residencia.bancoamazonas.leitura;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Escritor throws IOException {
	String nota = "nota.txt";
	
	BufferedWriter writer = new BufferedWriter(new FileWriter(nota));

	for (Lanche lanche : lanchesPedido) {
		writer.append(lanche.getNome()).append(" - ").append(lanche.getValor().toString()).append("\n");
	}
	for (Bebida bebida : bebidasPedido) {
		writer.append(bebida.getNome()).append(" - ").append(bebida.getValor().toString()).append("\n");
	}

	writer.append("Valor total - ").append(valorTotal.toString());

	writer.close();

	System.out.print("\nNota fiscal emitida!");

	scan.close();
}
