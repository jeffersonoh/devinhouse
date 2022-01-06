package br.com.devinhouse.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devinhouse.springboot.service.ClienteService;
import br.com.devinhouse.springboot.service.Parametro;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@Autowired
	private Parametro parametro;

	@GetMapping(path = "/imprime-nome/{idade}/{nome}")
	@ResponseBody
	public String imprimirNome(@PathVariable String nome, @PathVariable Integer idade) {
		return service.formatarNomeIdade(nome, idade);
	}

	@GetMapping(path = "/imprime-parametro")
	@ResponseBody
	public String imprimirParametro() {
		return parametro.getNossoParametro();
	}

}
