package br.com.cactusfood.infrastructure;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cactusfood.domain.model.Restaurante;
import br.com.cactusfood.domain.repository.RestauranteRepositoryQueries;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {



		return null;
	}

}
