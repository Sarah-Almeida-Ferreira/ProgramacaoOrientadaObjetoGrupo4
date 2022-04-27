package sistema;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Finalizador {
	
	public static void gerarRelatorio() {
        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Parametros.ARQUIVO_RELATORIOS)))) {
			br.write(Log.getLog());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
