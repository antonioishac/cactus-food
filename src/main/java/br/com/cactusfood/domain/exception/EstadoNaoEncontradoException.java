package br.com.cactusfood.domain.exception;

/**
 * @author Antonio Ishac
 *
 */
public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 5070906291425328046L;

	public EstadoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public EstadoNaoEncontradoException(Long estadoId) {
		this(String.format("Não existe um cadastro de estado com código %d", estadoId));
	}
}
