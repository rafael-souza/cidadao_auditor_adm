package br.net.proex.controller.exception;

import br.net.proex.commons.AppException;

public class AppLoginNegadoException  extends AppException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AppLoginNegadoException() {
		setMessage("Login e/ou senha incorretos!");
	}
	
}
