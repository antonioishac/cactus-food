package br.com.cactus.food.estudo;

/**
 * @author Antonio Ishac
 *
 */
public class ComparatorLambda {

//	public static void main(String[] args) {
//
//		// Minha Lista
//		List<String> filhos = new ArrayList<>();
//		filhos = Arrays.asList("Bianca", "Ana Paula", "Ana Laura", "Pedro");
//		System.out.println(filhos);
//
//		// Utilizando minha classe com o metodo de comparacao que definimos
//		ComparatorPorTamanho comparador = new ComparatorPorTamanho();
//		filhos.sort(comparador);
//		System.out.println(filhos);
//
//		//Evoluindo o comparator sem a implementacao da nossa classe de comparacao
//		filhos.sort( (s1, s2) -> {
//			if (s1.length() < s2.length())
//				return -1;
//			if (s1.length() > s2.length())
//				return 1;
//			return 0;
//		});
//
//		//Melhorando a implementacao acima,
//		//Conhecendo a API do Java, podemos ver que há um método que compara dois inteiros e retorna negativo/positivo/zero
//		//dependendo se o primeiro for menor/maior/igual ao segundo. É o Integer.compare
//		filhos.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
//
//		//imprimindo utilizando lambda
//		filhos.forEach(f -> System.out.println(f));
//
//	}
}
