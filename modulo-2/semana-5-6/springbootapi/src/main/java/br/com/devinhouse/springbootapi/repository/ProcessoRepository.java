package br.com.devinhouse.springbootapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.devinhouse.springbootapi.dto.ProcessoDTO;
import br.com.devinhouse.springbootapi.mock.ProcessoMock;

@Repository
public class ProcessoRepository {

	@Autowired
	private ProcessoMock processoMock;

	public List<ProcessoDTO> findAllProcessos() {
		return processoMock.getAllProcessos();
	}
}
