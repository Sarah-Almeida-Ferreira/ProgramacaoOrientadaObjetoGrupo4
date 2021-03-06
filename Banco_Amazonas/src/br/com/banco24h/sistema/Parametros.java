package br.com.banco24h.sistema;

public interface Parametros {
	
	final String DELIMITADOR_CAMPOS = ";";
	final String TAG_COMENTARIO = "#";

	final String PATH_CARGAS = "./cargas/";
	final String PATH_RELATORIOS = "./relatorios/";
	
	final String ARQUIVO_PESSOAS = PATH_CARGAS + "pessoas.txt";
	final String ARQUIVO_CONTAS = PATH_CARGAS + "contas.txt";
	final String ARQUIVO_ESTRUTURAS = PATH_CARGAS + "estruturas.txt";
	final String ARQUIVO_OPERACOES = PATH_RELATORIOS + "operacoes.txt";
	final String ARQUIVO_RELATORIOS_PREFIX = PATH_RELATORIOS + "relatorios";
	final String ARQUIVO_RELATORIOS_SUFIX = ".txt";

	void start();
	void carregar();
	void listar();
	void iniciar();
	void descarregar();
	
}
