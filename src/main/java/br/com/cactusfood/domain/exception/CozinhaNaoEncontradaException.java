package br.com.cactusfood.domain.exception;

/**
 * @author Antonio Ishac
 *
 */
public class CozinhaNaoEncontradaException extends EntidadeNaoEncontradaException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -8110587643690598675L;

	public CozinhaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public CozinhaNaoEncontradaException(Long cozinhaId) {
		this(String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
	}
}
