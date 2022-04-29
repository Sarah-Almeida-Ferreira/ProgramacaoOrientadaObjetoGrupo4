package br.com.residencia.bancoamazonas.dados;

import java.util.*;

import br.com.residencia.bancoamazonas.agencias.Agencia;
import br.com.residencia.bancoamazonas.contas.Conta;
import br.com.residencia.bancoamazonas.pessoas.Pessoa;


public class Dados {

	private static ArrayList<Pessoa> pessoas = new ArrayList<>();
	private static ArrayList<Conta> contas = new ArrayList<>();
	private static ArrayList<Agencia> agencias = new ArrayList<>();
	
	public static void addPessoa(Pessoa pessoa) {
		Dados.pessoas.add(pessoa);
	}
	
	public static void addConta(Conta conta) {
		Dados.contas.add(conta);
	}
	
	public static void addAgencia(Agencia agencia) {
		Dados.agencias.add(agencia);
	}

	public static void imprimir() {
		System.out.println(pessoas);
	}
	
	public static boolean fazerLogin() {
		Scanner sc = new Scanner(System.in);
        System.out.println("Digite o seu cpf/login: ");
        String loginEntrada;
        loginEntrada = sc.next();

        System.out.println("Digite a sua senha para entrar: ");
        String senhaEntrada;
        senhaEntrada = sc.next();

        for (int i = 0; i < pessoas.size(); i++) {
            if (loginEntrada.equalsIgnoreCase(pessoas.get(i).getCpf())
                    && senhaEntrada.equalsIgnoreCase(pessoas.get(i).getSenha())) {
                System.out.println("Login efetuado com sucesso! Seja bem-vindo(a), " + pessoas.get(i).getNome());
                return true;
            }

        }
        System.out.println("Andre certo com sucesso!");
        return false;
    }
}
	

