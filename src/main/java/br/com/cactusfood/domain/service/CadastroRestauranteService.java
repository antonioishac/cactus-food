package br.com.cactusfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cactusfood.domain.exception.RestauranteNaoEncontradoException;
import br.com.cactusfood.domain.model.Cozinha;
import br.com.cactusfood.domain.model.Restaurante;
import br.com.cactusfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CadastroCozinhaService cozinhaService;

	public Restaurante salvar(Restaurante restaurante) {

		// Atribui o código da cozinha a uma variável.
		Long cozinhaId = restaurante.getCozinha().getId();

		// Busca o objeto cozinha.
		Cozinha cozinha = cozinhaService.buscarOuFalhar(cozinhaId);

		// Atribui a cozinha a um restaurante
		restaurante.setCozinha(cozinha);

		// persiste o restaurante
		return restauranteRepository.save(restaurante);
	}

	public Restaurante buscarOuFalhar(Long restauranteId) {
		return restauranteRepository.findById(restauranteId)
			.orElseThrow(()-> new RestauranteNaoEncontradoException(restauranteId));
	}
}
