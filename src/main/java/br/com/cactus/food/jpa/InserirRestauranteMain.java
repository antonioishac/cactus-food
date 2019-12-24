package br.com.cactus.food.jpa;

import java.math.BigDecimal;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import br.com.cactus.food.CactusfoodApiApplication;
import br.com.cactus.food.domain.model.Restaurante;
import br.com.cactus.food.domain.repository.RestauranteRepository;

public class InserirRestauranteMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(CactusfoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);

		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("Restaurante Brasileira");
		restaurante1.setTaxaFrete(new BigDecimal("0.15"));

		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("Restaurante Japones");
		restaurante2.setTaxaFrete(new BigDecimal("0.17"));

		restauranteRepository.salvar(restaurante1);
		restauranteRepository.salvar(restaurante2);
	}
}