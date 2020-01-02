package br.com.cactusfood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import br.com.cactusfood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> findRestauranteJpql(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

	List<Restaurante> findRestauranteSql(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

	List<Restaurante> findRestauranteCriteria(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

}
