package model;

public class MovimentoMensal {
	private String data;
	private Double valorEntrada;
	private Double valorSaida;
	private Double saldo;

	public MovimentoMensal() {
	}

	public MovimentoMensal(String data, Double valorSaida, Double valorEntrada) {
		this.data = data;
		this.valorEntrada = valorEntrada;
		this.valorSaida = valorSaida;
	}
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Double getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(Double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public Double getValorSaida() {
		return valorSaida;
	}

	public void setValorSaida(Double valorSaida) {
		this.valorSaida = valorSaida;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	
}
