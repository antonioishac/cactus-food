package br.com.cactusfood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntidadeNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = -6372606416934636743L;

	public EntidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

}
