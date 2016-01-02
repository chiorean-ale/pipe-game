package exception;

public class FormatPieceException extends Exception {

	public FormatPieceException(int erreur, String msg) {
		super("" + erreur + " " + msg);
	}
}
