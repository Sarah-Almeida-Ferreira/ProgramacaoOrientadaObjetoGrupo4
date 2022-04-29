package br.com.banco24h.entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.com.banco24h.entidades.pessoas.Cliente;
import br.com.banco24h.entidades.pessoas.funcionarios.Diretor;
import br.com.banco24h.entidades.pessoas.funcionarios.Gerente;
import br.com.banco24h.entidades.pessoas.funcionarios.Presidente;
import br.com.banco24h.enums.EnumPessoa;
import br.com.banco24h.sistema.Parametros;

public abstract class Pessoa {
	
	private static Map<Integer, Pessoa> pessoas = new HashMap<>();

	private EnumPessoa tipoPessoa;
	private int id;
	private String nome = "";
	private String cpf = "";
	private String senha = "";
	
	protected Pessoa(EnumPessoa tipoPessoa, int id, String nome, String cpf, String senha) {
		this.tipoPessoa=tipoPessoa;
		this.nome=nome;
		this.id=id;
		this.cpf=cpf;
		this.senha=senha;
	}
	
	public String getNome() {
		return this.nome;
	}

	public EnumPessoa getTipoPessoa() {
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
			ehFuncionario |= (p.getTipoPessoa()==EnumPessoa.GERENTE);
			ehFuncionario |= (p.getTipoPessoa()==EnumPessoa.DIRETOR);
			ehFuncionario |= (p.getTipoPessoa()==EnumPessoa.PRESIDENTE);
			if(ehFuncionario) {
				if(p.getTipoPessoa()==EnumPessoa.PRESIDENTE) {
					saida += ", Banco("+((Presidente)p).getBanco().getNomeBanco()+")";
				}else if(p.getTipoPessoa()==EnumPessoa.DIRETOR) {
					saida += ", Regional("+((Diretor)p).getRegional().getNomeRegiao()+")";
				}else if(p.getTipoPessoa()==EnumPessoa.GERENTE) {
					saida += ", Agencia("+((Gerente)p).getAgencia().getNumeroAgencia()+"/"+((Gerente)p).getAgencia().getEndereco()+")";
				}

			}else if(p.getTipoPessoa()==EnumPessoa.CLIENTE) {
				saida += ", "+((Cliente)p).listarContas();
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
        	Cliente cliente;
        	Presidente presidente;
        	Diretor diretor;
        	Gerente gerente;
	        while((linha = arquivoFonte.readLine()) != null){
	        	if(!linha.startsWith(Parametros.TAG_COMENTARIO)) {
		            campos = linha.split(Parametros.DELIMITADOR_CAMPOS);
	            	if(campos.length>=1) tipoPessoa = campos[0];
	            	if(campos.length>=2) id = Integer.valueOf(campos[1]); 
	            	if(campos.length>=3) nome = campos[2]; 
	            	if(campos.length>=4) cpf = campos[3]; 
	            	if(campos.length>=5) senha = campos[4]; 
	            	if(campos.length>=6) idLotacao = Integer.valueOf(campos[5]); 
	            	if (tipoPessoa.toUpperCase().equals(EnumPessoa.CLIENTE.name())) {
	            		cliente = new Cliente(EnumPessoa.CLIENTE, id, nome, cpf, senha);
						Pessoa.addPessoa(cliente);
	            	} else if (tipoPessoa.toUpperCase().equals(EnumPessoa.PRESIDENTE.name())) {
	            		presidente = new Presidente(EnumPessoa.PRESIDENTE, id, nome, cpf, senha, idLotacao);
						Pessoa.addPessoa(presidente);
						presidente.getBanco().setPresidente(presidente);
	            	} else if (tipoPessoa.toUpperCase().equals(EnumPessoa.DIRETOR.name())) {
	            		diretor = new Diretor(EnumPessoa.DIRETOR, id, nome, cpf, senha, idLotacao);
						Pessoa.addPessoa(diretor);
						diretor.getRegional().setDiretor(diretor);
	            	} else if (tipoPessoa.toUpperCase().equals(EnumPessoa.GERENTE.name())) {
	            		gerente = new Gerente(EnumPessoa.GERENTE, id, nome, cpf, senha, idLotacao);
						Pessoa.addPessoa(gerente);
						gerente.getAgencia().setGerente(gerente);
	            	} else {
		            	System.out.println("#Erro#Tipo de pessoa não identificado: "+tipoPessoa);
					}
		        	tipoPessoa = "";
		        	id = 0; 
		        	nome = ""; 
		        	cpf = "";
		        	senha = ""; 
		        	idLotacao = 0;
		        	cliente = null;
		        	presidente = null;
		        	diretor = null;
		        	gerente = null;
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
	
	public static Cliente getClienteById(int idCliente) {
		return (Cliente)Pessoa.pessoas.get(idCliente);
	}

}
