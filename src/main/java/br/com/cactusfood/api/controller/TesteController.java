package br.com.cactusfood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cactusfood.domain.model.Cozinha;
import br.com.cactusfood.domain.model.Restaurante;
import br.com.cactusfood.domain.repository.CozinhaRepository;
import br.com.cactusfood.domain.repository.RestauranteRepository;

@RestController
@RequestMapping("/teste")
public class TesteController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	@GetMapping("/cozinhas/por-nome")
	public List<Cozinha> cozinhasPorNome(String nome) {
		return cozinhaRepository.findByNomeContaining(nome);
	}

	@GetMapping("/cozinhas/unica-por-nome")
	public Optional<Cozinha> cozinhaPorNome(String nome) {
		return cozinhaRepository.findByNome(nome);
	}

	@GetMapping("/cozinhas/exists")
	public boolean cozinhaExists(String nome) {
		return cozinhaRepository.existsByNome(nome);
	}

	@GetMapping("/restaurantes/por-taxa-frete")
	public List<Restaurante> restaurantesPorTaxaFrete(
			BigDecimal taxaInicial, BigDecimal taxaFinal) {
		return restauranteRepository.queryByTaxaFreteBetween(taxaInicial, taxaFinal);
	}

	@GetMapping("/restaurantes/por-nome")
	public List<Restaurante> restaurantesPorTaxaFrete(
			String nome, Long cozinhaId) {
		return restauranteRepository.consultarPorNome(nome, cozinhaId);
	}

	@GetMapping("/restaurantes/primeiro-por-nome")
	public Optional<Restaurante> restaurantePrimeiroPorNome(String nome) {
		return restauranteRepository.findFirstRestauranteByNomeContaining(nome);
	}

	@GetMapping("/restaurantes/top2-por-nome")
	public List<Restaurante> restaurantesTop2PorNome(String nome) {
		return restauranteRepository.findTop2ByNomeContaining(nome);
	}

	@GetMapping("/restaurantes/count-por-cozinha")
	public int restaurantesCountPorCozinha(Long cozinhaId) {
		return restauranteRepository.countByCozinhaId(cozinhaId);
	}

}