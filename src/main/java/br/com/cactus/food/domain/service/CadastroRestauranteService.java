package br.com.cactus.food.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cactus.food.domain.exception.EntidadeNaoEncontradaException;
import br.com.cactus.food.domain.model.Cozinha;
import br.com.cactus.food.domain.model.Restaurante;
import br.com.cactus.food.domain.repository.CozinhaRepository;
import br.com.cactus.food.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);

		if (cozinha == null) {
			throw new EntidadeNaoEncontradaException(
					String.format("Nao foi encontrado a cozinha com o codigo %d", cozinhaId));

		}
		restaurante.setCozinha(cozinha);
		return restauranteRepository.salvar(restaurante);
	}

//	public Restaurante atualizar(Long id, Restaurante restaurante) {
//		Restaurante restauranteAtual = restauranteRepository.buscar(id);
//
//		// verifica se o restaurante eiste
//		if (restaurante == null) {
//			throw new EntidadeNaoEncontradaException(
//					String.format("Restaurante com o codigo %d nao foi encontado.", id));
//		}
//
//		// se o restaurante eiste, verificamos se a cozinha eiste dentro do payload da requisicao
//		Cozinha cozinha = cozinhaRepository.buscar(restaurante.getCozinha().getId());
//		if (cozinha == null) {
//			throw new EntidadeNaoEncontradaException(
//					String.format("Nao foi encontrado a cozinha com o codigo %d", restaurante.getCozinha().getId()));
//		}
//		return null;
//	}
}
