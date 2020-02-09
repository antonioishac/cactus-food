package br.com.cactusfood.domain.exception;

public class EntidadeEmUsoException extends NegocioException {

	private static final long serialVersionUID = -2542428659044188819L;

	public EntidadeEmUsoException(String mensagem) {
		super(mensagem);
	}

}
