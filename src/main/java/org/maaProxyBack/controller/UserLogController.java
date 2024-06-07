package org.maaProxyBack.controller;

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
	    public ResponseEntity<ResponseCustom> signIn(@RequestBody @Valid User user){
	        System.out.println(user.toString() + "Controller");
	        System.out.println(this.service.signin(user) != null);
	        	if (this.service.signin(user) != null) {
		        	ResponseCustom response = new ResponseCustom();
		            response.setStatusCode("200");
		            response.setMessage("ok");
		            return ResponseEntity.status(HttpStatus.OK).body(response);

	        	} else {

		        	ResponseCustom response = new ResponseCustom();
		            response.setStatusCode("401");
		            response.setMessage("try again");
		            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	        		
	        	}

	    }

}
