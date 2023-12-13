package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.DTO.SignUpDTO;
import com.example.DTO.UserDTO;
import com.example.service.AuthService;

@RestController
public class SignUpUserController 
{
	@Autowired
	private AuthService authService;
	 
	@PostMapping("/sign-up")
    public ResponseEntity<?> signupUser(@RequestBody SignUpDTO signUpDTO) {
		
		if(authService.hasUserWithEmail(signUpDTO.getEmail()))
		{
			return new ResponseEntity<>("user already exist",HttpStatus.NOT_ACCEPTABLE);
		}
		
       UserDTO createdUser = authService.createUser(signUpDTO);
       if (createdUser == null){
           return new ResponseEntity<>("User not created, come again later!", HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

}
