package exception;

public class FormatFichierException extends Exception {
	
	public FormatFichierException(int erreur, String msg) {
		super("" + erreur + " " + msg);
	}
	
}
