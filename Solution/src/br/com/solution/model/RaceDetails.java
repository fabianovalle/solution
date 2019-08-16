package br.com.solution.model;

public class RaceDetails {

	private String posicaoChegada;
	private String codigoPiloto;
	private String nomePiloto;

	public String getPosicaoChegada() {
		return posicaoChegada;
	}

	public void setPosicaoChegada(String posicaoChegada) {
		this.posicaoChegada = posicaoChegada;
	}

	public String getCodigoPiloto() {
		return codigoPiloto;
	}

	public void setCodigoPiloto(String codigoPiloto) {
		this.codigoPiloto = codigoPiloto;
	}

	public String getNomePiloto() {
		return nomePiloto;
	}

	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}

	@Override
	public String toString() {
		return "RaceDetails [posicaoChegada=" + posicaoChegada + ", codigoPiloto=" + codigoPiloto + ", nomePiloto="
				+ nomePiloto + "]";
	}

}
