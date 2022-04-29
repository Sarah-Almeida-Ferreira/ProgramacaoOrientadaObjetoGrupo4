package entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import entidades.pessoas.Cliente;
import entidades.pessoas.Funcionario;
import entidades.pessoas.funcionarios.Diretor;
import entidades.pessoas.funcionarios.Gerente;
import entidades.pessoas.funcionarios.Presidente;
import sistema.Parametros;

public abstract class Pessoa {
	
	private static HashMap<Integer, Pessoa> pessoas = new HashMap<>();

	public enum EnumTipoPessoa {CLIENTE, GERENTE, DIRETOR, PRESIDENTE};
	
	private EnumTipoPessoa tipoPessoa;
	private int id;
	private String nome = "";
	private String cpf = "";
	private String senha = "";
	
	protected Pessoa(EnumTipoPessoa tipoPessoa, int id, String nome, String cpf, String senha) {
		this.tipoPessoa=tipoPessoa;
		this.nome=nome;
		this.id=id;
		this.cpf=cpf;
		this.senha=senha;
	}
	
	public String getNome() {
		return this.nome;
	}

	public EnumTipoPessoa getTipoPessoa() {
		return this.tipoPessoa;
	}

	public int getId() {
		return this.id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getSenha() {
		return this.senha;
	}

	public static void addPessoa(Pessoa pessoa) {
		Pessoa.pessoas.put(pessoa.id, pessoa);
	}
	
	public static int getQuantidadePessoas() {
		return pessoas.size();
	}

	public static String listarPessoas() {
		String saida = "";
		int i = 1;
		boolean ehFuncionario = false;
		Pessoa p;
		for (int idPessoa : pessoas.keySet()) {
			p = pessoas.get(idPessoa);
			saida += (saida==""?"":"\n");
			saida += p.getTipoPessoa().name()+"(";
			saida += "idPessoa="+idPessoa;
			saida += ", Nome="+p.getNome();
			saida += ", cpf="+p.getCpf();
			saida += ", senha="+p.getSenha();
			ehFuncionario = false;
			ehFuncionario |= (p.getTipoPessoa()==EnumTipoPessoa.GERENTE);
			ehFuncionario |= (p.getTipoPessoa()==EnumTipoPessoa.DIRETOR);
			ehFuncionario |= (p.getTipoPessoa()==EnumTipoPessoa.PRESIDENTE);
			if(ehFuncionario) {
				saida += ", lotacao="+((Funcionario)p).getIdLotacao();
			}
			saida += ")";
		}
		return saida;
	}

	public static void Carregar(String pathArquivo) { 
		BufferedReader arquivoFonte = null;
		try {
			arquivoFonte = new BufferedReader(new FileReader(pathArquivo));
	        String linha;
	        String[] campos;
        	String tipoPessoa = "";
        	int id = 0; 
        	String nome = ""; 
        	String cpf = ""; 
        	String senha = ""; 
        	int idLotacao = 0; 
	        while((linha = arquivoFonte.readLine()) != null){
	        	if(!linha.startsWith(Parametros.TAG_COMENTARIO)) {
		            campos = linha.split(Parametros.DELIMITADOR_CAMPOS);
	            	if(campos.length>=1) tipoPessoa = campos[0];
	            	if(campos.length>=2) id = Integer.valueOf(campos[1]); 
	            	if(campos.length>=3) nome = campos[2]; 
	            	if(campos.length>=4) cpf = campos[3]; 
	            	if(campos.length>=5) senha = campos[4]; 
	            	if(campos.length>=6) idLotacao = Integer.valueOf(campos[5]); 
	            	if (tipoPessoa.toUpperCase().equals(EnumTipoPessoa.CLIENTE.name())) {
						Pessoa.addPessoa(new Cliente(EnumTipoPessoa.CLIENTE, id, nome, cpf, senha));
	            	} else if (tipoPessoa.toUpperCase().equals(EnumTipoPessoa.PRESIDENTE.name())) {
						Pessoa.addPessoa(new Presidente(EnumTipoPessoa.PRESIDENTE, id, nome, cpf, senha, idLotacao));
	            	} else if (tipoPessoa.toUpperCase().equals(EnumTipoPessoa.DIRETOR.name())) {
						Pessoa.addPessoa(new Diretor(EnumTipoPessoa.DIRETOR, id, nome, cpf, senha, idLotacao));
	            	} else if (tipoPessoa.toUpperCase().equals(EnumTipoPessoa.GERENTE.name())) {
						Pessoa.addPessoa(new Gerente(EnumTipoPessoa.GERENTE, id, nome, cpf, senha, idLotacao));
	            	} else {
		            	System.out.println("#Erro#Tipo de pessoa não identificado: "+tipoPessoa);
					}
		        	tipoPessoa = "";
		        	id = 0; 
		        	nome = ""; 
		        	cpf = "";
		        	senha = ""; 
		        	idLotacao = 0;
	        	}
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
        if (arquivoFonte!=null) {
			try {
				arquivoFonte.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}
	

}
