package br.com.devinhouse.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ClienteService{

	public String formatarNomeIdade(String nome, Integer idade) {	
		
		return "nome é ::" + nome + "idade é ::" + idade;
	}
	
	
	@Scheduled(cron = "${cron.teste}")
	public void imprimeConsole () {
		
		System.out.println(" FOI!!!! ");
	}

	
}
