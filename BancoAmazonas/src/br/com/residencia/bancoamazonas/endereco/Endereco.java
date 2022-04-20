package br.com.residencia.bancoamazonas.endereco;

public class Endereco {

	private String rua;
	private Integer numeroCasa;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	
	
//  Métodos Públicos:
	
	public void mudarEndereco() {
		
	}
	
	
	
	
//  Métodos Especiais:
	
	public Endereco(String rua, Integer numeroCasa, String complemento, String bairro, String cidade, String uf,
			String cep) {
		super();
		this.rua = rua;
		this.numeroCasa = numeroCasa;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public Integer getNumeroCasa() {
		return numeroCasa;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getCep() {
		return cep;
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", numeroCasa=" + numeroCasa + ", complemento=" + complemento + ", bairro="
				+ bairro + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + "]";
	}
	
	

}
