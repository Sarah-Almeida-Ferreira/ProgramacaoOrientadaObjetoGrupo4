package br.com.residencia.bancoamazonas.principal;

import java.util.ArrayList;
import java.util.List;

import br.com.residencia.bancoamazonas.endereco.Endereco;

public class Principal {

	public static void main(String[] args) {

		List<Endereco> enderecos = new ArrayList<Endereco>();

		Endereco endereco1 = new Endereco("Rauishjdaushd", 23, "Bloco 2", "Pimenta", "Teresopolis", "RJ", "25983");
		Endereco endereco2 = new Endereco("astrolfo", 23, "Apto 345", "Tijuca", "Teresopolis", "RJ", "25983");
		enderecos.add(endereco1);
		enderecos.add(endereco2);

		// enderecos.forEach(endereco ->System.out.println(endereco));

		for (int i = 0; i < enderecos.size(); i++) {
			System.out.println(enderecos.get(i));
		}
		
		for (int i = 0; i < agencias.size(); i++) {
			System.out.println(agencias.get(i));
			if (idDiretor.get(i) == idAgencia.get(i)) {
				
			}
		}

		
		
	}

}
