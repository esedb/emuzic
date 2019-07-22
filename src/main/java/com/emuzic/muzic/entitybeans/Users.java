package com.emuzic.muzic.entitybeans;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter 
@Setter 
@Entity
@NoArgsConstructor
@Table(name="users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
		
	@Column(name= "username", nullable = false, unique =true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name="country")
	private String country;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone")
	private String phone;

}
