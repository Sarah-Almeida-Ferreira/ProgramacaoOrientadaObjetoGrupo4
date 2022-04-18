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
		
	public static void leitor(String path)throws IOException{
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
		String linha = "";
		while(true){
			linha = buffRead.readLine();
			if(linha !=null){
				String[] objeto = linha.split(";");
				System.out.println();
//				for(int i = 0; i < objeto.length; i++) {
//					System.out.println(objeto[i]);
//				}
//				Conta conta = new Conta(objeto[0], objeto[1], objeto[2], objeto[3], objeto[4], objeto[5]);
			}
			else{
				break;
			}
		}
		buffRead.close();
	}
	
	public static void escritor()throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Escreva o nome do arquivo: ");
		String nome = sc.next();
		
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO));
		String linha = "";
		
		System.out.println("Escreva algo");
		linha = sc.nextLine();
		sc.close();
		buffWrite.append(linha + "\n");
		buffWrite.close();
	}
}

