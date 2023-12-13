package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.DTO.SignUpDTO;
import com.example.DTO.UserDTO;
import com.example.model.UserRole;
import com.example.model.User;
import com.example.repository.UserRepository;

import jakarta.annotation.PostConstruct;

@Service
public class AuthServiceImp implements AuthService
{
	   @Autowired
	   private UserRepository userRepository;
	   
	   @PostConstruct
	   public void createAdminAccount()
	   {
		   User adminAccount=userRepository.findByUserRole(UserRole.ADMIN);
		   if(adminAccount==null)
		   {
			   User user=new User();
			   user.setUserRole(UserRole.ADMIN );
			   user.setEmail("jagadee@admin.com");
			   user.setName("admin");
			   user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			   userRepository.save(user);
		   }
	   }
	   @Override
	   public UserDTO createUser(SignUpDTO signupDTO) 
	   {
		   
					   User user = new User();
				       user.setName(signupDTO.getName());
					   user.setEmail(signupDTO.getEmail());
					   user.setUserRole(UserRole.USER);
					   user.setPassword(new BCryptPasswordEncoder().encode(signupDTO.getPassword()));
				       User createdUser = userRepository.save(user);
				       UserDTO userDTO = new UserDTO();
				       userDTO.setId(createdUser.getId());
				       userDTO.setEmail(createdUser.getEmail());
				       userDTO.setName(createdUser.getName());
				       userDTO.setUserRole(createdUser.getUserRole());
				       return userDTO;
	   }


	@Override
	public boolean hasUserWithEmail(String email) {
		
		return userRepository.findFirstByEmail(email)!=null;
	}
				 
		  

}
