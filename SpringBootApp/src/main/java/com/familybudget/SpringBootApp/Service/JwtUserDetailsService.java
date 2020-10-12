package com.familybudget.SpringBootApp.Service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.familybudget.SpringBootApp.model.user;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	UserService userservice;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user users= userservice.findByusername(username);
		if (users==null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		} else {
			return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPasswordID(),
					new ArrayList<>());
		}
	}
}