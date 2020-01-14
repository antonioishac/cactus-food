package br.com.cactusfood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Antonio Ishac
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NegocioException extends RuntimeException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 859154729198338836L;

	public NegocioException(String mensagem) {
		super(mensagem);
	}

	public NegocioException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
