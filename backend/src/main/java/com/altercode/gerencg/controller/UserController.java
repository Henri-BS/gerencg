package com.altercode.gerencg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.altercode.gerencg.dto.UserDTO;
import com.altercode.gerencg.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/auth")
	public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO user) {
		UserDTO newUser = userService.saveUser(user);
		return new ResponseEntity<UserDTO>(newUser, HttpStatus.CREATED);
	}
}
