package br.com.devinhouse.controller;

import java.util.Iterator;

import javax.annotation.security.RolesAllowed;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomUserAttrController {

	@RolesAllowed("escrita")
	@GetMapping(path = "/users")
	public ResponseEntity<String> getUser(Authorization auth) {

		return ResponseEntity.ok("Hello User");
	}

	// @RolesAllowed("admin")
	@GetMapping(path = "/admin")
	public ResponseEntity<String> getAdmin(@RequestHeader String Authorization) {

		return ResponseEntity.ok(Authorization);
	}

}
