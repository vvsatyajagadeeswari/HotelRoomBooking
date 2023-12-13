package com.example.DTO;

import com.example.model.UserRole;

import lombok.Data;

@Data
public class UserDTO 
{
	private Long id;
	private String name;
	private String email;
	private UserRole userRole;
}
