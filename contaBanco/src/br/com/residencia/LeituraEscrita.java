package br.com.residencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LeituraEscrita {

	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";

	public static void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
		String linha = "";
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
//				String[] objeto = linha.split(";");
				System.out.println(linha);
//				for(int i = 0; i < objeto.length; i++) {
//					System.out.println(objeto[i]);
//				}
				// Conta conta = new Conta(objeto[0]);
			} else {
				break;
			}
		}
		buffRead.close();
	}
}
