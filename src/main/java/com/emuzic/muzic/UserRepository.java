package com.emuzic.muzic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emuzic.muzic.entitybeans.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	Users findByEmail(String email);
	Users findByUsername(String username);
}
