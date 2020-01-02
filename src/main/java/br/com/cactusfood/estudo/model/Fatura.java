package br.com.cactusfood.estudo.model;

import java.math.BigDecimal;

public class Fatura {

	private String email;
	private BigDecimal valor;
	private double valorFatura;

	public Fatura(String email, BigDecimal valor, double valorFatura) {
		this.email = email;
		this.valor = valor;
		this.valorFatura = valorFatura;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public double getValorFatura() {
		return valorFatura;
	}

	public void setValorFatura(double valorFatura) {
		this.valorFatura = valorFatura;
	}

	@Override
	public String toString() {
		return "Email de cobrança: " + email + " com o valor da fatura: " + valor;
	}

//	A logica de comparação com compareTo é :
//	Se a > b : a.compareTo(b) > 0
//	Se a < b : a.compareTo(b) < 0
//	Se a = b : a.compareTo(b) = 0
//	Se a >= b : a.compareTo(b) >= 0
//	Se a <= b : a.compareTo(b) <= 0

	public Boolean verificaFatura() {
		return valor.compareTo(new BigDecimal("250.0")) > 0 ? Boolean.TRUE : Boolean.FALSE;
	}
}
