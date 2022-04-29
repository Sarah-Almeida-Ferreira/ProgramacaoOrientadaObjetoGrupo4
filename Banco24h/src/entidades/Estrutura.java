package entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import entidades.estruturas.Banco;
import entidades.estruturas.Regional;
import entidades.estruturas.Agencia;
import sistema.Parametros;

public abstract class Estrutura {
	
	private static HashMap<Integer, Estrutura> estruturas = new HashMap<>();
	
	public enum EnumTipoEstrutura {BANCO, REGIONAL, AGENCIA};
	
	private EnumTipoEstrutura tipoEstrutura;
	private int id = 0;
	
	protected Estrutura(EnumTipoEstrutura tipoEstrutura, int id) {
		this.tipoEstrutura=tipoEstrutura;
		this.id=id;
	}
	
	public EnumTipoEstrutura getTipoEstrutura() {
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
			if(e.getTipoEstrutura()==EnumTipoEstrutura.BANCO) {
				saida += ", nomeBanco="+((Banco)e).getNomeBanco();
				saida += ","+((Banco)e).listarRegionais();
			}else if(e.getTipoEstrutura()==EnumTipoEstrutura.REGIONAL) {
				saida += ", nomeRegiao="+((Regional)e).getNomeRegiao();
				saida += ", Banco="+((Regional)e).getBanco().getNomeBanco();
				saida += ","+((Regional)e).listarAgencias();
			}else if(e.getTipoEstrutura()==EnumTipoEstrutura.AGENCIA) {
				saida += ", numeroAgencia="+((Agencia)e).getNumeroAgencia();
				saida += ", Banco="+((Agencia)e).getRegional().getBanco().getNomeBanco();
				saida += ", Regional="+((Agencia)e).getRegional().getNomeRegiao();
				saida += ", endereco="+((Agencia)e).getEndereco();
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
	        while((linha = arquivo.readLine()) != null){
	        	if(!linha.startsWith(Parametros.TAG_COMENTARIO)) {
		            campos = linha.split(Parametros.DELIMITADOR_CAMPOS);
		            if(campos.length>=1) tipoEstrutura = campos[0];
		            if(campos.length>=2) id = Integer.valueOf(campos[1]); 
	            	if (tipoEstrutura.toUpperCase().equals(EnumTipoEstrutura.BANCO.name())) {
			            if(campos.length>=3) nomeBanco = campos[2]; 
						Estrutura.addEstrutura(new Banco(EnumTipoEstrutura.BANCO, id, nomeBanco));
	            	}else if (tipoEstrutura.toUpperCase().equals(EnumTipoEstrutura.REGIONAL.name())) {
			            if(campos.length>=3) nomeRegiao = campos[2]; 
			            if(campos.length>=4) idBanco = Integer.valueOf(campos[3]); 
						Estrutura.addEstrutura(new Regional(EnumTipoEstrutura.REGIONAL, id, nomeRegiao, idBanco));
	            	}else if (tipoEstrutura.toUpperCase().equals(EnumTipoEstrutura.AGENCIA.name())) {
			            if(campos.length>=3) numeroAgencia = Integer.valueOf(campos[2]); 
			            if(campos.length>=4) idRegiao = Integer.valueOf(campos[3]); 
			            if(campos.length>=5) endereco = campos[4]; 
						Estrutura.addEstrutura(new Agencia(EnumTipoEstrutura.AGENCIA, id, numeroAgencia, idRegiao, endereco));
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

	public static Banco associarBanco(int idBanco, Regional regional) {
		Banco b = (Banco)Estrutura.estruturas.get(idBanco);
		b.associarRegional(regional);
		return b;
	}

	public static Regional associarRegional(int idRegional, Agencia agencia) {
		Regional r = (Regional)Estrutura.estruturas.get(idRegional);
		r.associarAgencia(agencia);
		return r;
	}

}
