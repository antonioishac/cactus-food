package br.com.cactusfood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import br.com.cactusfood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}
