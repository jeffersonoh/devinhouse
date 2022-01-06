package br.com.devinhouse.springbootapi.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devinhouse.springbootapi.dto.ProcessoDTO;
import br.com.devinhouse.springbootapi.dto.ProcessoReturnResponseDTO;
import br.com.devinhouse.springbootapi.service.ProcessoService;


//TODO 6 - Implementar os status code com mensagem amigaveis em nossa API

@RestController
@RequestMapping(value = "/processos")
public class ProcessosController {
	
	@Autowired
	private ProcessoService service;

	
	//TODO 1 - Implementar versionamento em nossa API
	@RequestMapping(headers = "api-version=v1",value= "/v1"+"/consulta-json", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> recuperarListaProcessos() {
		return service.recuperarProcessosMockados();
	}
	
	//TODO 2 - Criar uma API que retorne somente os processo de 2020 usando Query string @RequestParam e o verbo GET 
	@RequestMapping(headers = "api-version=v1",value= "/v1"+"/consultas", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> recuperarListaProcessos(@RequestParam String ano ) {
	    return service.recuperarProcessosMockados(ano);
	}
	
	//TODO 3 - Criar uma API que retorne somente os processo de 2020 usando a @PathVariable e o verbo GET 
	@RequestMapping(headers = "api-version=v1",value= "/v1"+"/consulta/ano/{ano}", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> recuperarListaProcessosPath(@PathVariable String ano ) {		
		return service.recuperarProcessosMockados(ano);
	}
	
	//TODO 4 - Criar uma API que insira um processo usando o verbo "POST" e o objeto @RequestBody :
		//    {
		//        "sgOrgaoSetor":"SOFT",
		//        "nuProcesso" : 30,
		//        "nuAnoProcesso" : "2020",
		//        "cdAssunto" : 30,
		//        "descricaoAssunto": "Assunto teste 30 DEV In House",
		//        "decricao": "Processo teste 30 DEV In House",
		//        "cdInteressado": 30,
		//        "nmInteressado": "DEV In House"
		//     } 
	@RequestMapping(headers = "api-version=v1",value= "/v1"+"/cadastro/processo", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> cadastrarProcesso(@RequestBody ProcessoDTO processo ) {
		return service.cadastrarProcesso(processo);
	}
	
	//TODO 5 - Criar uma API usando o verbo "PUT" para atualizar o campo "descricao" de um processo usando a @PathVariable e o objeto @RequestBody
	//    {
	//        "descricao": "Processo teste 30 DEV In House",
	//     } 
	@RequestMapping(headers = "api-version=v1",value= "/v1"+"/update/processo/{nuProcesso}", method = PUT , consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> atualizarInfoProcesso(@PathVariable Integer nuProcesso, @RequestBody ProcessoDTO newProcesso) {
		
		return service.atualizarProcesso(nuProcesso,newProcesso);
	}

	@RequestMapping(value = "/consulta-xml", method = GET, produces = APPLICATION_XML_VALUE)
	@ResponseBody
	public ResponseEntity<ProcessoReturnResponseDTO> recuperarListaProcessosXML() {
		ProcessoReturnResponseDTO response = new ProcessoReturnResponseDTO();
		response.setProcesso(service.recuperarProcessosMockados());
		return new ResponseEntity<ProcessoReturnResponseDTO>(response, HttpStatus.OK);
	}
	
	//TODO 7 - Criar uma API que retorne de forme paginada utilizando a estrutura de "Query String" a listagem de processos de forma páginada usando a estratégia de cursor
	@RequestMapping(headers = "api-version=v1",value= "/v1"+"/consulta", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> recuperarListaProcessosFiltradosCursor(@RequestParam Integer inicio_id, @RequestParam Integer final_id ) {
		return service.recuperarProcessosMockadosFiltrados(inicio_id ,final_id);
	}
	
	//TODO 8 - Criar uma API que retorne de forme paginada utilizando a estrutura de "Query String" a listagem de processos de forma páginada usando a estratégia de Page e PageSize
	@RequestMapping(headers = "api-version=v1",value= "/v1"+"/consulta-page-size", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> recuperarListaProcessosFiltradosPagePageSize(@RequestParam Integer page, @RequestParam Integer page_size ) {
		
		return service.recuperarProcessosMockadosFiltradosPagePageSize(page ,page_size);
	}
		
	
	//TODO 9 - Criar uma API que retorne de forme paginada utilizando a estrutura de "Query String" a listagem de processos de forma páginada usando a estratégia de Offset e Limit
	@RequestMapping(headers = "api-version=v1",value= "/v1"+"/consulta-offset-limit", method = GET, produces = APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProcessoDTO> recuperarListaProcessosFiltradosOffSetLimit(@RequestParam Integer offset, @RequestParam Integer limit ) {
		
		return service.recuperarProcessosMockadosFiltradosOffSetLimit(offset ,limit);
	}

}
