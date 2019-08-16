package br.com.solution.model;

import java.util.ArrayList;
import java.util.List;

public class Race {

	private List<RaceDetails> raceDetails = new ArrayList<RaceDetails>();
	private String qdeVoltasCompletadas;
	private String tempoTotalProva;

	public List<RaceDetails> getRaceDetails() {
		return raceDetails;
	}

	public void setRaceDetails(List<RaceDetails> raceDetails) {
		this.raceDetails = raceDetails;
	}

	public String getQdeVoltasCompletadas() {
		return qdeVoltasCompletadas;
	}

	public void setQdeVoltasCompletadas(String qdeVoltasCompletadas) {
		this.qdeVoltasCompletadas = qdeVoltasCompletadas;
	}

	public String getTempoTotalProva() {
		return tempoTotalProva;
	}

	public void setTempoTotalProva(String tempoTotalProva) {
		this.tempoTotalProva = tempoTotalProva;
	}

	@Override
	public String toString() {
		return "Race [raceDetails=" + raceDetails + ", qdeVoltasCompletadas=" + qdeVoltasCompletadas
				+ ", tempoTotalProva=" + tempoTotalProva + "]";
	}

}
