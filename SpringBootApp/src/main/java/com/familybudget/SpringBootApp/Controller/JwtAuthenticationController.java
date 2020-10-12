package com.familybudget.SpringBootApp.Controller;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.familybudget.SpringBootApp.Config.JwtTokenUtil;
import com.familybudget.SpringBootApp.Service.JwtUserDetailsService;
import com.familybudget.SpringBootApp.Service.UserService;
import com.familybudget.SpringBootApp.model.JwtRequest;
import com.familybudget.SpringBootApp.model.JwtResponse;
import com.familybudget.SpringBootApp.model.user;



@RestController
@CrossOrigin
public class JwtAuthenticationController {
	@Autowired
	UserService userservice;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST, consumes = {"application/json"} )
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		System.out.println("Cooo"+authenticationRequest.getUsername());	
		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		
	

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		System.out.println("Tokennn"+new JwtResponse(token));	

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	

@RequestMapping(value = "/resgister", method = RequestMethod.POST )
	
	public ResponseEntity<user> save(@RequestBody user User)
	{
		System.out.println(" inside post"+ User.getEmailID());
		user users=userservice.save(User);		
		return new ResponseEntity<user>(users,HttpStatus.OK);
		
	}
}
