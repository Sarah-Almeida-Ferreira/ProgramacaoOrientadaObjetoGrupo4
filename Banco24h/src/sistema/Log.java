package sistema;

public class Log {

	private static final StringBuilder logs = new StringBuilder();
	
	public static void addLog(String registro) {
		Log.logs.append(registro+"\n");
	}

	public static String getLog() {
		return Log.logs.toString();
	}

}
