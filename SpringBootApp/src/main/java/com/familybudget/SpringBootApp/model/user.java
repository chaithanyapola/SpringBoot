package com.familybudget.SpringBootApp.model;


import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;


@Entity(name = "user_table")
public class user implements Serializable {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	 @SequenceGenerator(name = "id_Sequence1", sequenceName = "ID_SEQ1")
	private long id;
	
	
	@Column(name="username",nullable=false,unique = true)
	private String username;
	
	@Column(nullable=false)
	private String passwordID;
	
	@Column(name="emailID",nullable=false)
	private String emailID;
	
	@Column(nullable=false)
	private String firstname;
	
	@Column(nullable=false)
	private String lastname;
	
	
	 @CreationTimestamp
	private Date createdDate;
	
	 @CreationTimestamp
	 
	private Date upadatedDate;
	 
	// @OneToMany(mappedBy="users")
	//	private List<peroperties> preList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordID() {
		return passwordID;
	}

	public void setPasswordID(String passwordID) {
		this.passwordID = passwordID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpadatedDate() {
		return upadatedDate;
	}

	public void setUpadatedDate(Date upadatedDate) {
		this.upadatedDate = upadatedDate;
	}

	/*public List<peroperties> getPreList() {
		return preList;
	}

	public void setPreList(List<peroperties> preList) {
		this.preList = preList;
	}*/

	@Override
	public String toString() {
		return "user [id=" + id + ", username=" + username + ", passwordID=" + passwordID + ", emailID=" + emailID
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", createdDate=" + createdDate
				+ ", upadatedDate=" + upadatedDate + "]";
	}




}
