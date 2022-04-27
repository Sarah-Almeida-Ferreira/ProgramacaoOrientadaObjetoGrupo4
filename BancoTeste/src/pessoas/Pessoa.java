package pessoas;

public abstract class Pessoa {
	
	private String tipoPessoa = "";
	private String nome = "";
	
	protected Pessoa(String tipoPessoa, String nome) {
		this.tipoPessoa=tipoPessoa;
		this.nome=nome;
	}
	
	public String getNome() {
		return this.nome;
	}

	public String getTipoPessoa() {
		return this.tipoPessoa ;
	};

}
