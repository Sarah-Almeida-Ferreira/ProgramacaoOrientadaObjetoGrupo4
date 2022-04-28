import sistema.Finalizador;
import sistema.Inicializador;
import sistema.Sistema;

public class Main {

	public static void main(String[] args) {
		Inicializador.CarregarPessoas();
		Inicializador.listarPessoas();
		Inicializador.CarregarContas();
		Inicializador.listarContas();
		Sistema.realizaOperacoes();
		Finalizador.gerarRelatorio();
	}

}
