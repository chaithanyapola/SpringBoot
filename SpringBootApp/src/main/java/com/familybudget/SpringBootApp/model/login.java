package com.familybudget.SpringBootApp.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "login_table")
public class login {

	@Id
	@Column(nullable=false,unique = true)
	private String login_user_name;
	
	@Column(nullable=false)
	private String password_ID;
	
	
	 @CreationTimestamp
	 private Date Login_date;

	public String getLogin_user_name() {
		return login_user_name;
	}

	public void setLogin_user_name(String login_user_name) {
		this.login_user_name = login_user_name;
	}

	public String getPassword_ID() {
		return password_ID;
	}

	public void setPassword_ID(String password_ID) {
		this.password_ID = password_ID;
	}

	public Date getLogin_date() {
		return Login_date;
	}

	public void setLogin_date(Date login_date) {
		Login_date = login_date;
	}

	@Override
	public String toString() {
		return "login [login_user_name=" + login_user_name + ", password_ID=" + password_ID + ", Login_date="
				+ Login_date + "]";
	}
	
	
}
