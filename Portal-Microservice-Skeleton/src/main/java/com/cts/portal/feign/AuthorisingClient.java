package com.cts.portal.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.portal.exception.AuthorizationException;
import com.cts.portal.model.JwtRequest;
import com.cts.portal.model.User;

@FeignClient(name = "Authorizatiion-Microservice", url = "${auth.URL}")

public interface AuthorisingClient {
    
	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws AuthorizationException;

	@PostMapping(value = "/authorize")
	public boolean authorizeTheRequest(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader);
	
	//--------------------------------------
	@PostMapping("/authorize-role")
	public boolean authorizeTheRequestIfAdmin(@RequestHeader(value = "Authorization", required = true) String requestTokenHeader);
	
    @PostMapping("/register")
	public ResponseEntity<String> craeteNewUser(@RequestBody User user);
	
}
