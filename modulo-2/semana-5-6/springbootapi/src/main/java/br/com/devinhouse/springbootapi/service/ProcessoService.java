package br.com.devinhouse.springbootapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devinhouse.springbootapi.dto.ProcessoDTO;
import br.com.devinhouse.springbootapi.repository.ProcessoRepository;

@Service
public class ProcessoService {

	@Autowired
	private ProcessoRepository repository;

	private List<ProcessoDTO> recuperarTodosProcesso() {
		return repository.findAllProcessos();
	}

	public List<ProcessoDTO> recuperarProcessosMockados() {

		// AQUI SERIA ONDE COLOCARIAMOS AS NOSSAS REGRAS DE NEGOCIO

		return recuperarTodosProcesso();
	}

	public List<ProcessoDTO> recuperarProcessosMockados(String ano) {

		List<ProcessoDTO> todosProcessos = recuperarTodosProcesso();
		List<ProcessoDTO> listProcessoFiltrados = new ArrayList<ProcessoDTO>();

		for (ProcessoDTO processoDTO : todosProcessos) {

			if (ano.equals(processoDTO.getNuAnoProcesso())) {
				listProcessoFiltrados.add(processoDTO);
			}

		}

		return listProcessoFiltrados;
	}

	public List<ProcessoDTO> cadastrarProcesso(ProcessoDTO processo) {

		List<ProcessoDTO> todosProcessos = recuperarTodosProcesso();

		todosProcessos.add(processo);

		return todosProcessos;
	}

	public List<ProcessoDTO> atualizarProcesso(Integer nuProcesso, ProcessoDTO newProcesso) {

		List<ProcessoDTO> todosProcessos = recuperarTodosProcesso();

		for (ProcessoDTO processoDTO : todosProcessos) {

			if (nuProcesso == processoDTO.getNuProcesso()) {
				processoDTO.setDescricao(newProcesso.getDescricao());
			}

		}
		return todosProcessos;
	}

	public List<ProcessoDTO> recuperarProcessosMockadosFiltrados(Integer inicio_id, Integer final_id) {

		List<ProcessoDTO> todosProcessos = recuperarTodosProcesso();
		List<ProcessoDTO> listProcessoFiltrados = new ArrayList<ProcessoDTO>();

		for (ProcessoDTO processoDTO : todosProcessos) {

			if (processoDTO.getNuProcesso() >= inicio_id && processoDTO.getNuProcesso() <= final_id) {

				listProcessoFiltrados.add(processoDTO);
			}
		}

		return listProcessoFiltrados;
	}

	public List<ProcessoDTO> recuperarProcessosMockadosFiltradosPagePageSize(Integer page, Integer page_size) {	
		
		return recuperarProcessosMockadosFiltrados(page, page_size);
	}

	public List<ProcessoDTO> recuperarProcessosMockadosFiltradosOffSetLimit(Integer offset, Integer limit) {
		return recuperarProcessosMockadosFiltrados(offset, limit);
	}

}
