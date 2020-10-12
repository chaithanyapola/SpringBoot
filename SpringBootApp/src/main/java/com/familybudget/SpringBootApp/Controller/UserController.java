package com.familybudget.SpringBootApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.familybudget.SpringBootApp.Service.UserService;
import com.familybudget.SpringBootApp.model.user;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v2")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@GetMapping("/users")
	
	public ResponseEntity<List<user>> get()
	{

		System.out.println("inside controll");
		List<user> list= userservice.list();
		return new ResponseEntity<List<user>>(list,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/users/{id}")
	
	public ResponseEntity<user> getbyID(@PathVariable("id") long id)
	{

		System.out.println("inside Id");
		user list= userservice.findByID(id);
		return new ResponseEntity<user>(list,HttpStatus.OK);
	}
	
@GetMapping("/user/{username}")
	
	public ResponseEntity<user> findByusername(@PathVariable("username") String username)
	{

		System.out.println("inside name");
		user list= userservice.findByusername(username);
		return new ResponseEntity<user>(list,HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	
	public ResponseEntity<String> deleteByID(@PathVariable("id") long id)
	{

		System.out.println("inside Delete");
		userservice.deleteByID(id);
		return new ResponseEntity<String>("User is deleted",HttpStatus.OK);
	}
	
	@PutMapping("/users/{id}")
	
	public ResponseEntity<?> update(@PathVariable("id") int id,@RequestBody user users){
		userservice.update(id, users);
		return ResponseEntity.ok().body("recod got updated");		
	}

}
