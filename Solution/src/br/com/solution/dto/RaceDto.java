package br.com.solution.dto;

public class RaceDto implements Comparable<RaceDto> {

	private String hora;
	private String piloto;
	private String codigoPiloto;
	private String numVolta;
	private String tempoVolta;
	private String velocidadeMediaVolta;

	public String getCodigoPiloto() {
		return codigoPiloto;
	}

	public void setCodigoPiloto(String codigoPiloto) {
		this.codigoPiloto = codigoPiloto;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	public String getNumVolta() {
		return numVolta;
	}

	public void setNumVolta(String numVolta) {
		this.numVolta = numVolta;
	}

	public String getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(String tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	public String getVelocidadeMediaVolta() {
		return velocidadeMediaVolta;
	}

	public void setVelocidadeMediaVolta(String velocidadeMediaVolta) {
		this.velocidadeMediaVolta = velocidadeMediaVolta;
	}

	@Override
	public int compareTo(RaceDto raceDto) {
		return this.getNumVolta().compareTo(raceDto.getNumVolta());
	}

	@Override
	public String toString() {
		return "RaceDto [hora=" + hora + ", piloto=" + piloto + ", codigoPiloto=" + codigoPiloto + ", numVolta="
				+ numVolta + ", tempoVolta=" + tempoVolta + ", velocidadeMediaVolta=" + velocidadeMediaVolta + "]";
	}

}
