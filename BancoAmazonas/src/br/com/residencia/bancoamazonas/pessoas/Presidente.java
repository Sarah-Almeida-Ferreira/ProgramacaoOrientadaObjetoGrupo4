package br.com.residencia.bancoamazonas.pessoas;

import java.util.ArrayList;
import java.util.List;


public class Presidente extends Funcionario {

	Integer idPresidente;
	List<Diretor> diretores = new ArrayList<>();
	
	public void reuniao() {
		System.out.println("Em que pe estamos?");
	}
	
	
	
}
