package br.com.residencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Escritor {

	public static void escritor(String path) throws IOException {

		// static final String PATH_BASICO = "./temp/";

		Scanner sc = new Scanner(System.in);
		System.out.println("Escreva osso");
		String nome = sc.next();

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(nome + path + ".txt"));
		String linha = "";

		System.out.println("Escreva isso");
		linha = sc.nextLine();
		sc.close();
		buffWrite.append(linha + "\n");
		buffWrite.close();
	}
}
