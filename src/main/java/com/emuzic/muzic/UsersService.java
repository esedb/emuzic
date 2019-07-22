package com.emuzic.muzic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.emuzic.muzic.entitybeans.Users;

import lombok.Data;


@Data
@Component
public class UsersService {
	@Autowired
	UserRepository u_repo;
	
	public Long saveUser(Users user) {
		String password = user.getPassword();
		//password = new BCryptPasswordEncoder().encode(password);
		user.setPassword(password);
		u_repo.save(user);
		return 0L;		
	}
	public Users updateUser(Users user) {
		String email = user.getEmail();
		user = u_repo.findByEmail(email);
		if(user == null) {
			
		}
		return user;
		
	}
	
}
