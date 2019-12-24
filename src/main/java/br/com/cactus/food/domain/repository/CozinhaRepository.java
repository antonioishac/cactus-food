package br.com.cactus.food.domain.repository;

import java.util.List;

import br.com.cactus.food.domain.model.Cozinha;

public interface CozinhaRepository {

	List<Cozinha> listar();
	Cozinha buscar(Long id);
	Cozinha salvar(Cozinha cozinha);
	void remover(Cozinha cozinha);

}
