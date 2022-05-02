package br.com.banco24h.entidades.estruturas;

import java.util.ArrayList;
import java.util.Scanner;

import br.com.banco24h.entidades.Estrutura;
import br.com.banco24h.entidades.Pessoa;
import br.com.banco24h.entidades.pessoas.funcionarios.Presidente;
import br.com.banco24h.enums.EnumEstrutura;

public class Banco extends Estrutura{
	private static Scanner op = new Scanner(System.in);
	
	private String nomeBanco = "";
	private ArrayList<Regional> regionais = new ArrayList<>();
	private Presidente presidente = null;

	public Banco(EnumEstrutura tipoEstrutura, int id, String nomeBanco) {
		super(tipoEstrutura, id);
		this.nomeBanco=nomeBanco;
	}

	public String getNomeBanco() {
		return this.nomeBanco;
	}

	public void addRegional(Regional regional) {
		this.regionais.add(regional);
	}

	public ArrayList<Regional> getRegionais(){
		return this.regionais;
	}

	public String listarRegionais() {
		String saida = "";
		for(Regional regional: this.regionais) {
			saida += ("".equals(saida)?"":", ");
			saida += regional.getNomeRegiao();
		}
		return "regionais("+saida+")";
	}

	public Presidente getPresidente() {
		return presidente;
	}

	public void setPresidente(Presidente presidente) {
		this.presidente = presidente;
	}
	
	public static void listagemClientesBanco(Banco banco) {
		int o;	
		do {
			System.out.println("Relatório de clientes do banco: " + banco.getNomeBanco());
			System.out.println(Pessoa.getRelatorioListagemClientesBanco(banco));
			System.out.println();
			System.out.println("Digite [0] para retornar. ");
			o = op.nextInt();
		} while (o != 0);
	}
}
