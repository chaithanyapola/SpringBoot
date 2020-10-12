package com.familybudget.SpringBootApp.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.familybudget.SpringBootApp.model.user;
import com.familybudget.SpringBootApp.repository.UserRepository;


@Service
public class UserServiceImplentation implements UserService {
	
	@Autowired
	UserRepository userrepo;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Override
	public List<user> list() {
		// TODO Auto-generated method stub
		return userrepo.findAll();
	}

	@Override
	public user save(user User) {
		// TODO Auto-generated method stub
		user olduser=new user();
		System.out.println(" user"+User.getUsername());
		olduser.setUsername(User.getUsername());
		olduser.setEmailID(User.getEmailID());
		olduser.setPasswordID(bcryptEncoder.encode(User.getPasswordID()));
		olduser.setFirstname(User.getFirstname());
		olduser.setLastname(User.getLastname());
		
		return userrepo.save(olduser);
	}

	@Override
	public user findByID(long id) {
		// TODO Auto-generated method stub
		
		if(userrepo.findById(id).isPresent())
		{
			return userrepo.findById(id).get();
		}
			
		return null;
	
	}

	@Override
	public void deleteByID(long id) {
		// TODO Auto-generated method stub
		user users=findByID(id);
		userrepo.delete(users);
		
	}

	@Override
	public void update(long id,user users) {
		// TODO Auto-generated method stub
		user olduser=userrepo.findById(id).get();
		System.out.println(" user"+users.getUsername());
		olduser.setUsername(users.getUsername());
		olduser.setEmailID(users.getEmailID());
		olduser.setPasswordID(users.getPasswordID());
		olduser.setFirstname(users.getFirstname());
		olduser.setLastname(users.getLastname());
		olduser.setUpadatedDate(users.getUpadatedDate());
		userrepo.save(olduser);
	}

	@Override
	public user findByusername(String Username) {
		// TODO Auto-generated method stub
		 user users = userrepo.findByusername(Username);
		 System.out.println("By Username"+users);
			if (users!=null) {
				return users;
		}
			throw new UsernameNotFoundException("User not found with username: " + users.getUsername());
         
		
	}



}
