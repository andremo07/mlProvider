package br.com.trendsoftware.mlProvider.exception;

public class AuthorizationException extends Exception {
	private static final long serialVersionUID = 8688100047490895706L;

	public AuthorizationException(String message) {
		super(message);

	}     

	public AuthorizationException(Throwable cause) {
		super(cause);
	}
}
