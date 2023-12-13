package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.UserRole;
import com.example.model.User;

public interface UserRepository extends JpaRepository<User,Long>
{
	 User findFirstByEmail(String email);
	 
	 User findByRole(UserRole userRole);

	User findByUserRole(UserRole admin);
}
