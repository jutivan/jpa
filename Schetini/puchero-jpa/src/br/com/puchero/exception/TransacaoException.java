package br.com.puchero.exception;

public class TransacaoException extends Exception {

	private static final long serialVersionUID = -6156225232430761716L;

	public TransacaoException() {
		super();
	}

	public TransacaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TransacaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public TransacaoException(String message) {
		super(message);
	}

	public TransacaoException(Throwable cause) {
		super(cause);
	}

}
