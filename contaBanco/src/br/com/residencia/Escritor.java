package br.com.residencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Escritor {

	public static void escritor(String path) throws IOException {

		String PATH_BASICO = "./temp/";
		String EXTENSAO = ".txt";

		Scanner sc = new Scanner(System.in);
		System.out.println("Diga o nome do Arquivo a ser gerado: ");
		String nome = sc.next();

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + path + EXTENSAO));

		String linha = "";

		linha = sc.nextLine();
		System.out.println("");
		linha = sc.nextLine();
		buffWrite.append(linha + "\n");

		buffWrite.close();
		sc.close();
	}
}
