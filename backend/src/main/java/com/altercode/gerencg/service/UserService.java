package com.altercode.gerencg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.altercode.gerencg.dto.UserDTO;
import com.altercode.gerencg.entity.Authority;
import com.altercode.gerencg.entity.User;
import com.altercode.gerencg.repository.UserDetailsRepository;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthorityService authorityService;

	public UserDTO saveUser(UserDTO dto) {
		
		List<Authority> authorityList = new ArrayList<>();
		authorityList.add(authorityService.createAuthority("USER", "User role"));
		authorityList.add(authorityService.createAuthority("ADMIN", "Admin role"));
		
		User add = new User();
		add.setUserName(dto.getUserName());
		add.setFirstName(dto.getFirstName());
		add.setLastName(dto.getLastName());
		add.setPassword(passwordEncoder.encode(dto.getPassword()));
		add.setEnabled(true);
		
		return new UserDTO(userDetailsRepository.save(add));
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userDetailsRepository.findByUserName(username);
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found with userName" +username);
		}
		
		return user;
	}

}
