package br.com.residencia.bancoamazonas.principal;

import java.io.IOException;
import java.text.ParseException;
import br.com.residencia.bancoamazonas.leitura.Leitor;
import br.com.residencia.bancoamazonas.dados.Dados;

public class SistemaInterno {

	public static void main(String[] args) throws IOException, ParseException {
		
		Leitor.carregarPessoas();
		Dados.imprimir();
	}

}