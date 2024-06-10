package org.maaProxyBack.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.maaProxyBack.model.ResponseCustom;
import org.maaProxyBack.model.User;
import org.maaProxyBack.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserLogController {
	private UserService service;

	public UserLogController(UserService service) {
		this.service = service;
	}

	@PostMapping("signin")
	public ResponseEntity<ResponseCustom> signIn(@RequestBody @Valid User user) {
		ResponseCustom response = new ResponseCustom();

		if (this.service.signin(user) != null && "manager".equals(this.service.signin(user).getRole())) {
			response.setStatusCode("200");
			response.setMessage("valid credentials for manager");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		else if (this.service.signin(user) != null && "advisor".equals(this.service.signin(user).getRole())) {
			response.setStatusCode("200");
			response.setMessage("valid credentials for advisor");
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} else {

			response.setStatusCode("401");
			response.setMessage("invalid credentials");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}

	}

	@PostMapping("createUser")
	public User createUser(@RequestBody @Valid User user) {
		return service.save(user);
	}

}
