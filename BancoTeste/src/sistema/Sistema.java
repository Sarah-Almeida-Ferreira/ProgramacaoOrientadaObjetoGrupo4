package sistema;
import java.util.Date;
import java.util.Random;

public class Sistema {
	
	private static Random gerador = new Random();
	
	public static void realizaOperacoes() {        
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
		Log.addLog(String.valueOf(gerador.nextInt())+"_"+new Date());
	}

}
