package br.com.fiap.exceptions;

public class CommitException extends Exception {

	private static final long serialVersionUID = -619672453719267689L;

	public CommitException() {
		super();
	}

	public CommitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CommitException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommitException(String message) {
		super(message);
	}

	public CommitException(Throwable cause) {
		super(cause);
	}
	
}
