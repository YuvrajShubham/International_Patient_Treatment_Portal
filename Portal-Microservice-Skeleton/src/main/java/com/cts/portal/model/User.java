package com.cts.portal.model;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor

public class User {
	
	
	private int id;
	@Size(min = 3, max = 50)
	
	private String userName;
	
	private String password;
	
}
