package br.com.residencia.bancoamazonas.pessoas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.com.residencia.bancoamazonas.contas.Conta;

public class Gerente extends Funcionario {

	private Integer numeroAgencia;
	

//	Metodos Publicos:


//  Metodos Especiais:	
	
	public void chamarFuncao() {
	Conta.getTotalDeContas();
	}
	
	
	

}
