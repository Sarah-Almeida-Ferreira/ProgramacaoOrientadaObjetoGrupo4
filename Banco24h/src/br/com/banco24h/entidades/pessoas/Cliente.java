package br.com.banco24h.entidades.pessoas;

import java.util.ArrayList;

import br.com.banco24h.entidades.Conta;
import br.com.banco24h.entidades.Pessoa;
import br.com.banco24h.enums.EnumPessoa;

public class Cliente extends Pessoa {
	
	private ArrayList<Conta> contas = new ArrayList<>();

	public Cliente(EnumPessoa tipoPessoa, int id, String nome, String cpf, String senha) {
		super(tipoPessoa, id , nome, cpf, senha);
	}

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void addConta(Conta conta) {
		this.contas.add(conta);
	}

	public String listarContas() {
		String saida = "";
		for(Conta conta: this.contas) {
			saida += ("".equals(saida)?"":", ");
			saida += conta.getTipoConta().getDescricaoPrimeiraMaiuscula()+"<numero="+conta.getNumeroConta()+", agencia="+conta.getAgencia().getNumeroAgencia()+"/"+conta.getAgencia().getRegional().getNomeRegiao()+", banco="+conta.getAgencia().getRegional().getBanco().getNomeBanco()+">";
		}
		return "contas("+saida+")";
	}

}
