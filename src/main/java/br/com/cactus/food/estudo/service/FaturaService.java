package br.com.cactus.food.estudo.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import br.com.cactus.food.estudo.model.Fatura;

public class FaturaService {

	/**
	 * Metodo que retorna uma representacao de uma lista de faturas simulando os dados de um banco de dados.
	 *
	 * @return List<Fatura>
	 */
	public static List<Fatura> faturas() {
		return Arrays.asList(
				new Fatura("antonioishac@gmail.com", new BigDecimal(500.0), 500),
				new Fatura("kfishac@gmail.com", new BigDecimal(750.0), 250),
				new Fatura("anapaulaishac@gmail.com", new BigDecimal(150.50), 300));
	}

}
