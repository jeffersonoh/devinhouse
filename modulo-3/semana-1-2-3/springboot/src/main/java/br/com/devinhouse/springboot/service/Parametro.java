package br.com.devinhouse.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Parametro {
		
	@Value("${exemplo.devinhouse}")
	private String nossoParametro;

	
	public String getNossoParametro() {
		return nossoParametro;
	}

	public void setNossoParametro(String nossoParametro) {
		this.nossoParametro = nossoParametro;
	}

}
