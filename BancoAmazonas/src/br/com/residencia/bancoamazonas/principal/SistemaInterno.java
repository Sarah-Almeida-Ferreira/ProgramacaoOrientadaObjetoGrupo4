package br.com.residencia.bancoamazonas.principal;

import java.io.IOException;
import java.text.ParseException;

import br.com.residencia.bancoamazonas.contas.Conta;
import br.com.residencia.bancoamazonas.contas.ContaCorrente;

public class SistemaInterno {

	public static void main(String[] args) throws IOException, ParseException {
		
		
		Conta conta1 = new ContaCorrente();
		Conta conta2 = new ContaCorrente();
		
		System.out.println(Conta.getTotalDeContas());
		
		
	}
		
		
}
