package br.com.banco24h.sistema;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Log {

	private static final StringBuilder logOperacao = new StringBuilder();
	private static final StringBuilder logRelatorio = new StringBuilder();
	
	public static void addLogOperacao(String registro) {
		Log.logOperacao.append(registro+"\n");
	}

	public static void addLogRelatorio(String registro) {
		Log.logRelatorio.append(registro+"\n");
	}

	public static String getLogOperacao() {
		return Log.logOperacao.toString();
	}

	public static String getLogRelatorio() {
		return Log.logRelatorio.toString();
	}

	public static void descarregarLogOperacao(String pathArquivo) {
        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathArquivo)))) {
			br.write(Log.getLogOperacao());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void descarregarLogRelatorio(String pathArquivo) {
        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathArquivo)))) {
			br.write(Log.getLogRelatorio());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
