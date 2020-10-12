package com.familybudget.SpringBootApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.familybudget.SpringBootApp.model.user;


@Repository

public interface UserRepository extends JpaRepository<user,Long> {

	  user findByUsername(String login_user_name);

	user findByusername(String username);
}
