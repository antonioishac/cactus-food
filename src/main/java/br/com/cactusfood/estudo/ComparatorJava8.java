package br.com.cactusfood.estudo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.cactusfood.estudo.model.Book;

public class ComparatorJava8 {


	public static void main(String[] args) {

		List<Book> books = Arrays.asList(
				new Book(1L, "Antônio Ishac", "Spring Boot", new BigDecimal("200.75")),
				new Book(1L, "Antônio Ishac", "Oracle SQL", new BigDecimal("150.00")),
				new Book(1L, "Antônio Ishac", "Kubernetes", new BigDecimal("300.85")),
				new Book(1L, "Antônio Ishac", "Apacke Mesos", new BigDecimal("500.15")),
				new Book(1L, "Antônio Ishac", "Apacke Spark", new BigDecimal("100")),
				new Book(1L, "Antônio Ishac", "Apacke ECS", new BigDecimal("85.59")),
				new Book(1L, "Antônio Ishac", "AWS - EC2", new BigDecimal("1185.25")));

		// Listando todos como veio da base de dados, por exemplo...
		System.out.println("Imprimindo sem ordenação");
		books.stream().forEach(System.out::println);

		System.out.println();
		System.out.println();

		System.out.println("Imprimindo com ordenação");
		// Listando com a API Collections do Java introduzido no Java 8
		Comparator<Book> comparator =
				Comparator.comparing(Book::getId)
				.thenComparing(Book::getAuthor)
				.thenComparing(Book::getNameBook)
				.thenComparing(Book::getPrice);

		Collections.sort(books, comparator);
		books.stream().forEach(System.out::println);

	}

}
