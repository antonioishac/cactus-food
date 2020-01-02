package br.com.cactusfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cactusfood.domain.exception.EntidadeNaoEncontradaException;
import br.com.cactusfood.domain.model.Cozinha;
import br.com.cactusfood.domain.model.Restaurante;
import br.com.cactusfood.domain.repository.CozinhaRepository;
import br.com.cactusfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(()-> new EntidadeNaoEncontradaException(
						String.format("Nao foi encontrado a cozinha com o codigo %d", cozinhaId)));

		restaurante.setCozinha(cozinha);
		return restauranteRepository.save(restaurante);
	}
}