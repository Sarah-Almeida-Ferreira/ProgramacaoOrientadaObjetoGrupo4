package br.com.residencia;

public class BancoAmazonas {

	public static void main(String[] args) {
		
		Cliente cliente1[]  = new Cliente [7];
		Conta contaBanco[] = new Conta [7]; 
		
		
		
		
		
		
				
//		c[0] = new Cliente ("Wanderson", "123547890", "Rua das Pedras", 900);
//		c[1] = new Cliente ("Sarah Ferreira Almeida", "9875634", "Rua dos Voodoos", 1000);
//		c[2] = new Cliente ("Theo Bittencourt", "1297831289", "Rua das flechas", 900);
//		c[3] = new Cliente ("Andre", "129837123", "Monte Olimpo", 900);
//		c[4] = new Cliente ("Patrick", "123123123", "Rua das Aguas", 900);
//		c[5] = new Cliente ("Pereira", "102938123", "Rua das Pontas", 1.99);
//		c[6] = new Cliente ("Aline", "102378128", "Rua Joao", 900);
		
		
//		c[0].imprimirCliente();
//		c[1].imprimirCliente();
//		c[2].imprimirCliente();
//		c[3].imprimirCliente();
//		c[4].imprimirCliente();
//		c[5].imprimirCliente();
//		c[6].imprimirCliente();		
		
		Conta conta = new Conta(001, "Joao", 250);
		Conta conta2 = new Conta(002, "Maria", 900);
		System.out.println("Saldo anterior: "+conta.getSaldo());
		System.out.println("Saldo anterior: "+conta2.getSaldo());
		//conta2.sacar(150.00);
		conta.transferir(100, conta2);
		
		System.out.println("Saldo atual conta 1: "+conta.getSaldo());
		System.out.println("Saldo atual conta 2: "+conta2.getSaldo());
		//conta2.depositar(200, conta);
	}

}
