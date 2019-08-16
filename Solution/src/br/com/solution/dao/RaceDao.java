package br.com.solution.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.solution.constants.RaceConstants;

public class RaceDao {

	public List<String> carregaDadosLog() {
		BufferedReader reader = null;
		List<String> linhasArquivo = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(RaceConstants.LOG_FILE));
			String line = reader.readLine();
			line = reader.readLine();
			while (line != null) {
				linhasArquivo.add(line);
				line = reader.readLine();
			}
			reader.close();
			return linhasArquivo;
		} catch (IOException e) {
			System.out.println(RaceConstants.LOG_ERRO1);
		} finally {
			System.out.println(RaceConstants.FIM_PROCESSAMENTO);
			reader = null;
		}
		return null;
	}

}
