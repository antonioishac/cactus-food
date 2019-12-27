package br.com.cactus.food.estudo.service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.cactus.food.estudo.model.Banco;

public class AntecipacaoDTO {

	private Banco banco;

	private LocalDateTime dataAntecipacao;

	private BigDecimal valorAntecipacao;

	public AntecipacaoDTO(Banco banco, LocalDateTime dataAntecipacao, BigDecimal valorAntecipacao) {
		this.banco = banco;
		this.dataAntecipacao = dataAntecipacao;
		this.valorAntecipacao = valorAntecipacao;
	}

	/**
	 * @return the banco
	 */
	public Banco getBanco() {
		return banco;
	}

	/**
	 * @param banco the banco to set
	 */
	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	/**
	 * @return the dataAntecipacao
	 */
	public LocalDateTime getDataAntecipacao() {
		return dataAntecipacao;
	}

	/**
	 * @param dataAntecipacao the dataAntecipacao to set
	 */
	public void setDataAntecipacao(LocalDateTime dataAntecipacao) {
		this.dataAntecipacao = dataAntecipacao;
	}

	/**
	 * @return the valorAntecipacao
	 */
	public BigDecimal getValorAntecipacao() {
		return valorAntecipacao;
	}

	/**
	 * @param valorAntecipacao the valorAntecipacao to set
	 */
	public void setValorAntecipacao(BigDecimal valorAntecipacao) {
		this.valorAntecipacao = valorAntecipacao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((banco == null) ? 0 : banco.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AntecipacaoDTO other = (AntecipacaoDTO) obj;
		if (banco == null) {
			if (other.banco != null)
				return false;
		} else if (!banco.equals(other.banco))
			return false;
		return true;
	}



}
