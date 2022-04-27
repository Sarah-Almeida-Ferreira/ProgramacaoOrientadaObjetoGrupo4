package contas;

public abstract class Conta {
	
	private String tipoConta = "";
	private int numeroConta = 0;
	
	public Conta(String tipoConta, int numeroConta) {
		this.tipoConta=tipoConta;
		this.numeroConta=numeroConta;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}

	public String getTipoConta() {
		return tipoConta;
	}

}
