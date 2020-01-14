package br.com.cactusfood.domain.exception;

/**
 * @author Antonio Ishac
 *
 */
public class RestauranteNaoEncontradoException extends EntidadeNaoEncontradaException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -439724935533911247L;

	public RestauranteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public RestauranteNaoEncontradoException(Long restauranteId) {
		this(String.format("Não existe um cadastro de restaurante com código %d", restauranteId));
	}

}
