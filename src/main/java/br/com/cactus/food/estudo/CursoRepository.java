package br.com.cactus.food.estudo;

import java.util.Arrays;
import java.util.List;

import br.com.cactus.food.estudo.model.Curso;
import br.com.cactus.food.estudo.model.Periodo;

public class CursoRepository {

	public List<Curso> listaDeCursos() {
		Curso java8 = new Curso("Java 8", 120, Periodo.NOTURNO);
		Curso java8D = new Curso("Java 8", 120, Periodo.MANHA);
		Curso pyton = new Curso("Pyton", 200, Periodo.MANHA);
		Curso javaScript = new Curso("Java Script", 80, Periodo.NOTURNO);
		Curso angular = new Curso("Angular", 50, Periodo.NOTURNO);
		Curso angularJs = new Curso("Angular JS", 100, Periodo.NOTURNO);

		List<Curso> cursos = Arrays.asList(java8, java8D, pyton, javaScript, angular, angularJs);

		return cursos;
	}

}
