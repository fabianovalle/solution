package br.com.solution.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.solution.constants.RaceConstants;
import br.com.solution.dto.RaceDto;

public class DateUtil {

	public String somarTempo(List<RaceDto> populateRaceDto) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(RaceConstants.TIME_MASK);
		long totalTime = 0;
		Calendar result = Calendar.getInstance();
		for (RaceDto raceDto : populateRaceDto) {
			String tempoDeVolta = raceDto.getTempoVolta();
			Date date = sdf.parse(tempoDeVolta);
			totalTime += date.getTime();
		}
		result.setTimeInMillis(totalTime);
		return sdf.format(result.getTime());
	}

}
