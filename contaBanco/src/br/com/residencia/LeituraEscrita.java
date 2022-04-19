package br.com.residencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LeituraEscrita {

	public static final String PATH_BASICO = "./temp/";
	public static final String EXTENSAO = ".txt";

	public static void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
		String linha = "";

		while (true) {
			linha = buffRead.readLine();
			while (linha != null) {
				String[] param = linha.split(";");
				linha = buffRead.readLine();

				for (int i = 0; i < param.length; i++) {
					System.out.print(param[i] + " ");

				}
				System.out.print("\n");
			}
			break;

		}
		buffRead.close();
	}
}
