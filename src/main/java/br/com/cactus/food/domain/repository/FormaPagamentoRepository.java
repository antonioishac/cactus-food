package br.com.cactus.food.domain.repository;

import java.util.List;
import br.com.cactus.food.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {
	List<FormaPagamento> listar();
	FormaPagamento buscar(Long id);
	FormaPagamento salvar(FormaPagamento formaPagamento);
	void remover(FormaPagamento formaPagamento);
}
