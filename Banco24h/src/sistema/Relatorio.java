package sistema;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Relatorio {
	
	public static void descarregar(String pathArquivo) {
        try (BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathArquivo)))) {
			br.write(Log.getLog());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
