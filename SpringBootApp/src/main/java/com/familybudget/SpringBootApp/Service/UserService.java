package com.familybudget.SpringBootApp.Service;

import java.util.List;

import com.familybudget.SpringBootApp.model.user;


public interface UserService {

	//Get list of records
	
			List<user> list();
			
			user save(user User);
		
			user findByID(long id);
			
			void deleteByID(long id);
			
			void update(long id,user users);
			
			user findByusername(String Username);
}
