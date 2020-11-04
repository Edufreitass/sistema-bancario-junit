package com.udemy.junit.negocio;

/**
 * Exceção a ser lançada quando a idade de um possivel novo cliente nao for aceita.
 * 
 * @author Eduardo Freitas
 */
public class IdadeNaoPermitidaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public static String MSG_IDADE_INVALIDA = "A idade do cliente precisa estar entre 18 e 65 anos.";
	
	public IdadeNaoPermitidaException(String msg) {
		super(msg);
	}

}
