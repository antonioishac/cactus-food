package br.com.cactusfood.estudo.execapijava8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import br.com.cactusfood.estudo.model.Pessoa;

public class ApiStreamJava8 {

	public static void main(String[] args) {

		// List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,0);

		// Implementacao tradicional
//		for (Integer n: list) {
//			System.out.println(n);
//		}

		// Implementacao com expressao lambda e streamAPI
//		list.forEach(c -> System.out.println(c));

		List<Pessoa> listaPessoas = Arrays.asList(new Pessoa("Antonio", 37),
				new Pessoa("Keli", 36),
				new Pessoa("Bianca", 19),
				new Pessoa("Ana Paula", 15),
				new Pessoa("Ana Laura", 15),
				new Pessoa("Pedro", 13));

		Stream<Pessoa> streamPessoa = listaPessoas.stream();

//		Integer somaIdade = streamPessoa.filter(p -> p.getNome().startsWith("A")).mapToInt(p -> p.getIdade()).sum();
//
//		Integer maiorIdade = streamPessoa.mapToInt(p -> p.getIdade()).max().getAsInt();
//
//		Integer menorIdade = streamPessoa.mapToInt(p -> p.getIdade()).min().getAsInt();

		IntSummaryStatistics staticPessoa = streamPessoa.filter(p -> p.getNome().startsWith("A")).mapToInt(p -> p.getIdade()).summaryStatistics();

		System.out.println(staticPessoa.getSum());
		System.out.println(staticPessoa.getMax());
		System.out.println(staticPessoa.getMin());

		IntStream intStream = listaPessoas.stream().mapToInt(p -> p.getIdade());
		Double mediaIdade = intStream.average().getAsDouble();
		System.out.println("Media: " + mediaIdade);

		// covertendo para list do tipo pessoa.
		List<Pessoa> listPessoa = listaPessoas.stream()
				.filter(p -> p.getNome()
				.startsWith("A"))
				.collect(Collectors.toList());


	}

}
