package br.com.cactus.food.estudo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.cactus.food.estudo.model.Curso;

public class StudyStream {

	public static void main(String[] args) {

		CursoRepository repository = new CursoRepository();

		List<Curso> cursos = repository.listaDeCursos();

//		cursos.stream()
//			.filter(c -> c.getAlunos() >= 100)
//			.map(c -> c.getAlunos())
//			.forEach(System.out::println);

//		List<Curso> cursoFiltro = cursos.stream()
//				.filter(c -> c.getNome().contains("Java"))
//				.collect(Collectors.toList());
//
//		cursoFiltro.forEach(c -> System.out.println(c.getNome() + " - " + c.getPeriodo()));

		Set<Curso> cursosrSet = cursos.stream()
				.filter(c -> c.getNome().contains("Java"))
				.collect(Collectors.toSet());

		cursosrSet.forEach(c -> System.out.println(c.getNome() + " - " + c.getPeriodo()));

		Map<Integer, List<Curso>> cursosGroupBy = cursos.stream()
				.collect(Collectors.groupingBy(Curso::getAlunos));


//		cursos.forEach(c -> System.out.println(c.getAlunos()));

	}

}
