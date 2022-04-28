package br.com.residencia.bancoamazonas.dados;

public class Parametros {
	
	public static final String PATH_CARGAS = "./cargas/";
	public static final String PATH_RELATORIOS = "./relatorios/";
	
	public static final String ARQUIVO_PESSOAS = PATH_CARGAS + "base_pessoa.txt";
	public static final String ARQUIVO_CONTAS = PATH_CARGAS + "base_conta.txt";
	public static final String ARQUIVO_RELATORIOS = PATH_RELATORIOS + "relatorios.txt";
	
	public static final Integer QUANTIDADE_CAMPOS_PESSOAS = 4;
	public static final Integer QUANTIDADE_CAMPOS_CONTAS = 2;
	
	public static final String TAG_CLIENTE = "CLIENTE";
	public static final String TAG_PRESIDENTE = "PRESIDENTE";
	public static final String TAG_DIRETOR = "DIRETOR";
	public static final String TAG_GERENTE = "GERENTE";

	public static final String TAG_CORRENTE = "CORRENTE";
	public static final String TAG_POUPANCA = "POUPANCA";

	public static final String DELIMITADOR_CAMPOS = ";";
}