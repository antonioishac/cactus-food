package br.com.cactusfood.domain.exception;

/**
 * @author Antonio Ishac
 *
 */
public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {

	/**
	 *
	 */
	private static final long serialVersionUID = 7521933352042650057L;

	public CidadeNaoEncontradaException(String mensagem) {
		super(mensagem);
	}

	public CidadeNaoEncontradaException(Long cidadeId) {
		this(String.format("Não existe um cadastro de cidade com código %d", cidadeId));
	}

}
