package br.com.cactusfood.estudo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.cactusfood.estudo.model.Banco;
import br.com.cactusfood.estudo.service.dto.AntecipacaoDTO;

public class AntecipacaoService {


	public static void main(String[] args) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Banco santander = new Banco("033", "Santander");
		Banco itau = new Banco("044", "Itau");
		Banco bradesco = new Banco("045", "Bradesco");
		Banco bandoBrasil = new Banco("047", "Banco do Brasil");

		LocalDateTime antSantander1 = LocalDateTime.of(2019, Month.DECEMBER, 19, 0, 0);
		BigDecimal vlrSantander1 = new BigDecimal("5000");

		LocalDateTime antSantander2 = LocalDateTime.of(2019, Month.DECEMBER, 19, 0, 0);
		BigDecimal vlrSantander2 = new BigDecimal("8000");

		LocalDateTime antSantander3 = LocalDateTime.of(2019, Month.DECEMBER, 19, 0, 0);
		BigDecimal vlrSantander3 = new BigDecimal("5500");

		LocalDateTime antItau = LocalDateTime.of(2019, Month.DECEMBER, 19, 0, 0);
		BigDecimal vlrItau = new BigDecimal("5000");

		LocalDateTime antBradesco = LocalDateTime.of(2019, Month.DECEMBER, 19, 0, 0);
		BigDecimal vlrBradesco = new BigDecimal("5000");

		LocalDateTime antBancoBrasil = LocalDateTime.of(2019, Month.DECEMBER, 19, 0, 0);
		BigDecimal vlrBancoBrasil = new BigDecimal("5000");

		AntecipacaoDTO antecipacao1 = new AntecipacaoDTO(santander, antSantander1, vlrSantander1);
		AntecipacaoDTO antecipacao2 = new AntecipacaoDTO(santander, antSantander2, vlrSantander2);
		AntecipacaoDTO antecipacao3 = new AntecipacaoDTO(santander, antSantander3, vlrSantander3);
		AntecipacaoDTO antecipacao4 = new AntecipacaoDTO(itau, antItau, vlrItau);
		AntecipacaoDTO antecipacao5 = new AntecipacaoDTO(bradesco, antBradesco, vlrBradesco);
		AntecipacaoDTO antecipacao6 = new AntecipacaoDTO(bandoBrasil, antBancoBrasil, vlrBancoBrasil);

		List<AntecipacaoDTO> listaAntecipacao = Arrays.asList(antecipacao1, antecipacao2, antecipacao3, antecipacao4, antecipacao5, antecipacao6);

		List<AntecipacaoDTO> lista = new ArrayList<AntecipacaoDTO>();

		BigDecimal somaSantander = listaAntecipacao
				.stream()
				.filter(b -> "Santander".equals(b.getBanco().getNome()))
				.map(AntecipacaoDTO::getValorAntecipacao)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		System.out.println(somaSantander);

		List<AntecipacaoDTO> listaSumarizada = new ArrayList<AntecipacaoDTO>();

		// Modo antigo
		for (AntecipacaoDTO antecipacao : listaAntecipacao) {

			if (listaSumarizada.contains(antecipacao)) {

				AntecipacaoDTO antecipacaoExistente = listaSumarizada.get(listaSumarizada.indexOf(antecipacao));

				antecipacaoExistente.setValorAntecipacao(antecipacaoExistente.getValorAntecipacao().add(antecipacao.getValorAntecipacao()));

			} else {
				listaSumarizada.add(antecipacao);
			}
		}

		//soma tudo
//		BigDecimal teste = listaAntecipacao.stream()
//			.map(AntecipacaoDTO::getValorAntecipacao)
//			.reduce(BigDecimal::add)
//			.get();
//
//		System.out.println(teste);

//		Map<String, Map<String, List<RedeCredenciadaGeolocalizacaoResponse>>> prestadorCredenciadoPontosAtendimento = prestadorCredenciado.stream()
//				.collect(Collectors.groupingBy(RedeCredenciadaGeolocalizacaoResponse::getCodigoPrestador,
//						 Collectors.groupingBy(RedeCredenciadaGeolocalizacaoResponse::getCodigoPontoAtendimento,
//								collectingAndThen(
//										toCollection(() -> new TreeSet<>(
//												comparing(RedeCredenciadaGeolocalizacaoResponse::getCodigoPrestador))),
//										ArrayList::new))));
//
//
//		List<RedeCredenciadaGeolocalizacaoResponse> pontosAtendimentos = new ArrayList<RedeCredenciadaGeolocalizacaoResponse>();
//		for(Map<String, List<RedeCredenciadaGeolocalizacaoResponse>> prestadorCredenciadoPontosMap : prestadorCredenciadoPontosAtendimento.values()) {
//			for(List<RedeCredenciadaGeolocalizacaoResponse> pontoAtendimento : prestadorCredenciadoPontosMap.values()) {
//				pontosAtendimentos.addAll(pontoAtendimento);
//			}
//		}
	}
}
