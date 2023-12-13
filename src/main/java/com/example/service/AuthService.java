package com.example.service;

import com.example.DTO.SignUpDTO;
import com.example.DTO.UserDTO;

public interface AuthService 
{
	UserDTO createUser(SignUpDTO signupDTO);

	boolean hasUserWithEmail(String email);
}
