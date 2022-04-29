package br.com.banco24h.beans;

import br.com.banco24h.enums.EnumPessoa;

public class _BeanLogin {
	
	private String login = "";
	private String senha = "";
	private EnumPessoa tipoPessoa;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public EnumPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(EnumPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

}
