package br.com.cactusfood.estudo.controller;

import java.math.BigDecimal;
import java.util.List;

import br.com.cactusfood.estudo.model.Fatura;
import br.com.cactusfood.estudo.service.FaturaService;

public class FaturaController {

	public static void main(String[] args) {

		List<Fatura> faturas = FaturaService.faturas();

//		for(Fatura f: faturas) {
//			if (f.verificaFatura())
//				System.out.println(f);
//		}

		BigDecimal comparaValor = new BigDecimal("250.0");

		faturas.stream()
			.filter(f -> f.getValor().compareTo(new BigDecimal("250.0")) > 0);



	}

}
