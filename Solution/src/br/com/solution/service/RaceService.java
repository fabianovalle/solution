package br.com.solution.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.solution.constants.RaceConstants;
import br.com.solution.dao.RaceDao;
import br.com.solution.dto.RaceDto;
import br.com.solution.model.Race;
import br.com.solution.model.RaceDetails;
import br.com.solution.util.DateUtil;

public class RaceService {

	private RaceDao dao = new RaceDao();
	private DateUtil dateUtil = new DateUtil();

	public Race calcularResultadoCorrida() {
		Race resultadoCorrida = new Race();
		List<String> carregaDadosLog = dao.carregaDadosLog();
		List<RaceDto> populateRaceDto = populateRaceDto(carregaDadosLog);
		int calcularQdeVoltasCompletadas = calcularQdeVoltasCompletadas(populateRaceDto);
		String calcularTempoTotalProva = calcularTempoTotalProva(populateRaceDto);
		List<RaceDto> calcularPosicaoChegada = calcularPosicaoChegada(populateRaceDto);
		int i = 1;

		resultadoCorrida.setQdeVoltasCompletadas(String.valueOf(calcularQdeVoltasCompletadas));
		resultadoCorrida.setTempoTotalProva(calcularTempoTotalProva);

		for (RaceDto raceDto : calcularPosicaoChegada) {
			RaceDetails RaceDetails = new RaceDetails();
			RaceDetails.setCodigoPiloto(raceDto.getCodigoPiloto());
			RaceDetails.setNomePiloto(raceDto.getPiloto());
			RaceDetails.setPosicaoChegada(String.valueOf(i));
			resultadoCorrida.getRaceDetails().add(RaceDetails);
			i++;
		}

		return resultadoCorrida;
	}

	private List<RaceDto> calcularPosicaoChegada(List<RaceDto> populateRaceDto) {
		Collections.sort(populateRaceDto, Collections.reverseOrder());
		return populateRaceDto;
	}

	private int calcularQdeVoltasCompletadas(List<RaceDto> populateRaceDto) {
		int voltasCompletadas = 0;
		for (RaceDto raceDto : populateRaceDto) {
			voltasCompletadas += Integer.parseInt(raceDto.getNumVolta());
		}
		return voltasCompletadas;
	}

	private String calcularTempoTotalProva(List<RaceDto> populateRaceDto) {
		try {
			String tempoDeProva = dateUtil.somarTempo(populateRaceDto);
			return tempoDeProva;
		} catch (ParseException e) {
			System.out.println(RaceConstants.ERRO_AO_CALCULAR_TEMPO_DE_PROVA);
		} finally {
			dateUtil = null;
		}
		return null;
	}

	private List<RaceDto> populateRaceDto(List<String> dadosLog) {
		List<RaceDto> listaRaceDto = new ArrayList<RaceDto>();
		try {

			for (String item : dadosLog) {
				RaceDto raceDto = new RaceDto();
				String[] header = item.split(RaceConstants.REGEX);
				raceDto.setHora(header[0]);
				raceDto.setCodigoPiloto(header[1]);
				raceDto.setNumVolta(header[4]);
				raceDto.setPiloto(header[3]);
				raceDto.setTempoVolta(header[5]);
				raceDto.setVelocidadeMediaVolta(header[6]);
				listaRaceDto.add(raceDto);
			}

		} catch (Exception e) {
			System.out.println(RaceConstants.ERRO_AO_POPULAR_RACEDTO);
		}
		return listaRaceDto;
	}

}
