package br.com.cactusfood.domain.exception;

public class EntidadeNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = -6372606416934636743L;

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

}
