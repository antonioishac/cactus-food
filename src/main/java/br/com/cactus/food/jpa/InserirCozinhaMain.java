package br.com.cactus.food.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.cactus.food.CactusfoodApiApplication;
import br.com.cactus.food.domain.model.Cozinha;
import br.com.cactus.food.domain.repository.CozinhaRepository;

public class InserirCozinhaMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new SpringApplicationBuilder(CactusfoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);


		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Brasileira");

		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Japonesa");

		cozinhaRepository.salvar(cozinha1);
		cozinhaRepository.salvar(cozinha2);

	}

}
