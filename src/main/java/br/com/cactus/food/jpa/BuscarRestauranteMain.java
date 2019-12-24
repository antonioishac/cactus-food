package br.com.cactus.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.cactus.food.CactusfoodApiApplication;
import br.com.cactus.food.domain.model.Restaurante;
import br.com.cactus.food.domain.repository.RestauranteRepository;

public class BuscarRestauranteMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(CactusfoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);


		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

		Restaurante restaurante = restauranteRepository.buscar(1L);
		System.out.printf("%s - %f - %s ", restaurante.getNome(), restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());

	}

}
