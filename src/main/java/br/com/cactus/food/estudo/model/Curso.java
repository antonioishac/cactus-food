package br.com.cactus.food.estudo.model;

public class Curso {

	private String nome;
	private int alunos;
	private Periodo periodo;

	public Curso(String nome, int alunos, Periodo periodo) {
		this.nome = nome;
		this.alunos = alunos;
		this.periodo = periodo;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the alunos
	 */
	public int getAlunos() {
		return alunos;
	}
	/**
	 * @param alunos the alunos to set
	 */
	public void setAlunos(int alunos) {
		this.alunos = alunos;
	}
	/**
	 * @return the periodo
	 */
	public Periodo getPeriodo() {
		return periodo;
	}
	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Curso [nome=" + nome + ", alunos=" + alunos + ", periodo=" + periodo + "]";
	}

}