package br.com.solution.main;
import java.text.ParseException;

import br.com.solution.model.Race;
import br.com.solution.service.RaceService;

public class Solution {

	public static void main(String[] args) throws ParseException {
		RaceService raceService = new RaceService();
		Race calcularResultadoCorrida = raceService.calcularResultadoCorrida();
		System.out.println(calcularResultadoCorrida);
	}

}
