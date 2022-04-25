package br.com.residencia.bancoamazonas.principal;

import java.util.ArrayList;
import java.util.List;

import br.com.residencia.bancoamazonas.endereco.Endereco;
import br.com.residencia.bancoamazonas.pessoas.Funcionario;
import br.com.residencia.bancoamazonas.pessoas.Gerente;

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
		
		
		//Gerente gerente1 = new Gerente();
		
		//System.out.println(gerente1.getBonificacao());
		
		Funcionario funcionario1 = new Gerente();
		System.out.println(funcionario1.getBonificacao());
		Funcionario funcionario2 = new Funcionario();
		System.out.println(funcionario2.getBonificacao());
		
	
		
		
//		for (int i = 0; i < agencias.size(); i++) {
//			System.out.println(agencias.get(i));
//			if (idDiretor.get(i) == idAgencia.get(i)) {
//				
//			}
//		}

		
		
	}

}
