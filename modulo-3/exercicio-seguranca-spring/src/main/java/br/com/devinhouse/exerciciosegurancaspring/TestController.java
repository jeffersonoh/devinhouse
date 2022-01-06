package br.com.devinhouse.exerciciosegurancaspring;

import javax.annotation.security.RolesAllowed;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RolesAllowed("user")
	@GetMapping(path = "/users")
	public ResponseEntity<String> getUser() {
		return ResponseEntity.ok("Hello User");
	}

}
