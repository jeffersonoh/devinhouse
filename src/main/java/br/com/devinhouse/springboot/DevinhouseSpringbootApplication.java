package br.com.devinhouse.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DevinhouseSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevinhouseSpringbootApplication.class, args);
	}

}
