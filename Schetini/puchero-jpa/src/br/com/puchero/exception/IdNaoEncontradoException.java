package br.com.puchero.exception;

public class IdNaoEncontradoException extends Exception {
	
	private static final long serialVersionUID = 4824781279499694129L;

	public IdNaoEncontradoException() {
		super();
	}

	public IdNaoEncontradoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public IdNaoEncontradoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public IdNaoEncontradoException(String arg0) {
		super(arg0);
	}

	public IdNaoEncontradoException(Throwable arg0) {
		super(arg0);
	}
	
}
