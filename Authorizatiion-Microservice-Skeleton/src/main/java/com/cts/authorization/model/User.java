package com.cts.authorization.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	@Size(min = 3, max = 50)
//	@Pattern(regexp="^[a-zA-Z0-9]{3}",message="length must be 3")
	private String userName;
	
	private String password;
	
}
