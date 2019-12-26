package br.com.cactus.food.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = -6372606416934636743L;

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

}
