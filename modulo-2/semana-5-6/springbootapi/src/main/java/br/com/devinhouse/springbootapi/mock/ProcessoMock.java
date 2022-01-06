package br.com.devinhouse.springbootapi.mock;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.devinhouse.springbootapi.dto.ProcessoDTO;

@Component
public class ProcessoMock implements Serializable {

	private static final long serialVersionUID = 1838934594260766206L;

	public List<ProcessoDTO> getAllProcessos() {

		List<ProcessoDTO> listProcessos = new ArrayList<ProcessoDTO>();

		int qtdProcessos = 20;

		for (int i = 0; i < qtdProcessos; i++) {

			ProcessoDTO dto = new ProcessoDTO();
			dto.setCdAssunto(i+1);
			dto.setCdInteressado(i+1);
			dto.setDescricao("Processo " + (i + 1 ) + "de testes DEV In House ");
			dto.setDescricaoAssunto("Assunto " + (i + 1 ) + " de testes DEV In House ");
			dto.setNmInteressado("Jão Antonio ::: " + i);
			dto.setNuAnoProcesso(i <=10 ? "2020" : "2021");
			dto.setNuProcesso(i+1);
			dto.setSgOrgaoProcesso("SOFT");
			dto.setChaveProcesso(dto.getSgOrgaoProcesso() + " " + dto.getNuProcesso() + "/" + dto.getNuAnoProcesso());

			listProcessos.add(dto);
		}

		return listProcessos;
	}

}
