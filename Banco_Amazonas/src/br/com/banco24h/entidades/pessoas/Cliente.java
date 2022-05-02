package br.com.banco24h.entidades.pessoas;

import br.com.banco24h.entidades.Conta;
import br.com.banco24h.entidades.Pessoa;
import br.com.banco24h.enums.EnumConta;
import br.com.banco24h.enums.EnumPessoa;

public class Cliente extends Pessoa {
	
	private Conta conta = null;
	private EnumConta tipoConta;

	public Cliente(EnumPessoa tipoPessoa, int id, String nome, String cpf, String senha) {
		super(tipoPessoa, id , nome, cpf, senha);
	}

	public EnumConta getTipoConta() {
		return tipoConta;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta=conta;
		this.tipoConta=conta.getTipoConta();
	}

	public String imprimirConta() {
		String saida = "";
		saida += conta.getTipoConta().getDescricaoPrimeiraMaiuscula()+"<numero="+conta.getNumeroConta()+", agencia="+conta.getAgencia().getNumeroAgencia()+"/"+conta.getAgencia().getRegional().getNomeRegiao()+", banco="+conta.getAgencia().getRegional().getBanco().getNomeBanco()+">";
		return "conta("+saida+")";
	}

}
