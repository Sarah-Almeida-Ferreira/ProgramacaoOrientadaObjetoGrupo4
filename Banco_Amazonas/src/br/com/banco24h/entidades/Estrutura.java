package br.com.banco24h.entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import br.com.banco24h.entidades.estruturas.Agencia;
import br.com.banco24h.entidades.estruturas.Banco;
import br.com.banco24h.entidades.estruturas.Regional;
import br.com.banco24h.enums.EnumEstrutura;
import br.com.banco24h.sistema.Parametros;

public abstract class Estrutura {
	
	private static Map<Integer, Estrutura> estruturas = new HashMap<>();
	
	//public enum EnumTipoEstrutura {BANCO, REGIONAL, AGENCIA};
	
	private EnumEstrutura tipoEstrutura;
	private int id = 0;
	
	protected Estrutura(EnumEstrutura tipoEstrutura, int id) {
		this.tipoEstrutura=tipoEstrutura;
		this.id=id;
	}
	
	public EnumEstrutura getTipoEstrutura() {
		return tipoEstrutura;
	}

	public int getId() {
		return this.id;
	}

	public static void addEstrutura(Estrutura conta) {
		Estrutura.estruturas.put(conta.id, conta);
	}
	
	public static int getQuantidadeEstruturas() {
		return estruturas.size();
	}
	
	public static String listarEstruturas() {
		String saida = "";
		Estrutura e;
		for (int idEstrutura : estruturas.keySet()) {
			e = estruturas.get(idEstrutura);
			saida += (saida==""?"":"\n");
			saida += e.getTipoEstrutura().name()+"(";
			saida += "idEstrutura="+idEstrutura;
			if(e.getTipoEstrutura()==EnumEstrutura.BANCO) {
				saida += ", nomeBanco="+((Banco)e).getNomeBanco();
				saida += ", "+((Banco)e).listarRegionais();
				saida += ", Presidente="+((Banco)e).getPresidente().getNome();
			}else if(e.getTipoEstrutura()==EnumEstrutura.REGIONAL) {
				saida += ", nomeRegiao="+((Regional)e).getNomeRegiao();
				saida += ", Banco="+((Regional)e).getBanco().getNomeBanco();
				saida += ","+((Regional)e).listarAgencias();
				saida += ", Diretor="+((Regional)e).getDiretor().getNome();
			}else if(e.getTipoEstrutura()==EnumEstrutura.AGENCIA) {
				saida += ", numeroAgencia="+((Agencia)e).getNumeroAgencia();
				saida += ", Banco="+((Agencia)e).getRegional().getBanco().getNomeBanco();
				saida += ", Regional="+((Agencia)e).getRegional().getNomeRegiao();
				saida += ", endereco="+((Agencia)e).getEndereco();
				saida += ","+((Agencia)e).listarContas();
			}
			saida += ")";
		}
		return saida;
	}

	public static void Carregar(String pathArquivo) {
		BufferedReader arquivo = null;
		try {
			arquivo = new BufferedReader(new FileReader(pathArquivo));
	        String linha;
	        String[] campos;
        	String tipoEstrutura = "";
        	int id = 0;
        	String nomeBanco = "";
        	String nomeRegiao = "";
        	int idBanco = 0;
        	int numeroAgencia = 0;
        	int idRegiao = 0;
        	String endereco = "";
        	Banco banco;
        	Regional regional;
        	Agencia agencia;
	        while((linha = arquivo.readLine()) != null){
	        	if(!linha.startsWith(Parametros.TAG_COMENTARIO)) {
		            campos = linha.split(Parametros.DELIMITADOR_CAMPOS);
		            if(campos.length>=1) tipoEstrutura = campos[0];
		            if(campos.length>=2) id = Integer.valueOf(campos[1]); 
	            	if (tipoEstrutura.toUpperCase().equals(EnumEstrutura.BANCO.name())) {
			            if(campos.length>=3) nomeBanco = campos[2];
			            banco = new Banco(EnumEstrutura.BANCO, id, nomeBanco);
						Estrutura.addEstrutura(banco);
	            	}else if (tipoEstrutura.toUpperCase().equals(EnumEstrutura.REGIONAL.name())) {
			            if(campos.length>=3) nomeRegiao = campos[2]; 
			            if(campos.length>=4) idBanco = Integer.valueOf(campos[3]);
			            regional = new Regional(EnumEstrutura.REGIONAL, id, nomeRegiao, idBanco);
						Estrutura.addEstrutura(regional);
						regional.getBanco().addRegional(regional);
	            	}else if (tipoEstrutura.toUpperCase().equals(EnumEstrutura.AGENCIA.name())) {
			            if(campos.length>=3) numeroAgencia = Integer.valueOf(campos[2]); 
			            if(campos.length>=4) idRegiao = Integer.valueOf(campos[3]); 
			            if(campos.length>=5) endereco = campos[4];
			            agencia = new Agencia(EnumEstrutura.AGENCIA, id, numeroAgencia, idRegiao, endereco);
						Estrutura.addEstrutura(agencia);
						agencia.getRegional().addAgencia(agencia);
	            	}else{
	            		System.out.println("#Erro#Tipo de conta não identificado: "+tipoEstrutura);
					}
	            	tipoEstrutura = "";
	            	id = 0;
	            	nomeBanco = "";
	            	nomeRegiao = "";
	            	idBanco = 0;
	            	numeroAgencia = 0;
	            	idRegiao = 0;
	            	endereco = "";
	            	banco = null;
	            	regional = null;
	            	agencia = null;
	        	}
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
        if (arquivo!=null) {
			try {
				arquivo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}

	public static Banco getBancoById(int idBanco) {
		return (Banco)Estrutura.estruturas.get(idBanco);
	}

	public static Regional getRegionalById(int idRegional) {
		return (Regional)Estrutura.estruturas.get(idRegional);
	}

	public static Agencia getAgenciaById(int idAgencia) {
		return (Agencia)Estrutura.estruturas.get(idAgencia);
	}

}
