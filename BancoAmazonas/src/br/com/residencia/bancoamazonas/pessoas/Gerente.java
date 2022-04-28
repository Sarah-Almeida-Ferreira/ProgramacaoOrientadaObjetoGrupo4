package br.com.residencia.bancoamazonas.pessoas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.com.residencia.bancoamazonas.contas.Conta;

public class Gerente extends Funcionario {

	private Integer numeroAgencia;
	private static List<Cliente> clientes = new ArrayList<>();

//	Metodos Publicos:


//  Metodos Especiais:	
	
	public Gerente(String nome, String CPF, String senha, String tipoPessoa, String salario, String cargo) {
		// TODO Auto-generated constructor stub
	}

	public void chamarFuncao() {
	Conta.getTotalDeContas();
	}
	
	
	

}
